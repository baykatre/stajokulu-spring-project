package com.stajokulu.pick_down;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.stajokulu.delivery_point.DeliveryPoint;
import com.stajokulu.delivery_point.DeliveryPointService;
import com.stajokulu.shipment.Shipment;
import com.stajokulu.shipment.ShipmentService;
import com.stajokulu.tools.ApplicationContextProvider;
import com.stajokulu.vehicle.Vehicle;
import com.stajokulu.vehicle.VehicleService;

import java.io.IOException;
import java.util.*;

public class PickDownModelDeserializer extends StdDeserializer<PickDownModel> {

    public PickDownModelDeserializer(Class<PickDownModel> t) {
        super(t);
    }

    public PickDownModelDeserializer() {
        this(null);
    }

    @Override
    public PickDownModel deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        final ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        final ObjectNode root = mapper.readTree(jsonParser);
        final String plate = root.get("plate").asText();


        final Iterator<JsonNode> routeIterator = root.get("route").elements();

        final List<JsonNode> routeList = new ArrayList<>();
        while(routeIterator.hasNext()) {
            routeList.add(routeIterator.next());
        }

        final Map<DeliveryPoint, List<Shipment>> deliveryPointDeliveriesMap = new TreeMap<>();
        routeList.forEach(
                route -> {
                    deliveryPointDeliveriesMap.put(
                            getDeliveryPoint(route.get("deliveryPoint").asInt()), getShipmentList(route));
                });

        return new PickDownModel(getVehicle(plate), deliveryPointDeliveriesMap);
    }

    private Vehicle getVehicle(String plate) {
        final VehicleService vehicleService =
                ApplicationContextProvider.getInstance().getBean(VehicleService.class);
        return vehicleService.getVehicle(plate);
    }

    private List<Shipment> getShipmentList(JsonNode route) {
        final Iterator<JsonNode> shipmentIterator = route.get("deliveries").elements();
        final ShipmentService shipmentService =
                ApplicationContextProvider.getInstance().getBean(ShipmentService.class);

        final List<Shipment> shipmentList = new ArrayList<>();
        while(shipmentIterator.hasNext()) {
            shipmentList.add(
                    shipmentService.getShipment(shipmentIterator.next().get("barcode").asText()));
        }

        return shipmentList;
    }

    private DeliveryPoint getDeliveryPoint(int deliveryPointValue) {

        final DeliveryPointService pointService =
                ApplicationContextProvider.getInstance().getBean(DeliveryPointService.class);
        return pointService.getDeliveryPoint(deliveryPointValue);
    }
}
