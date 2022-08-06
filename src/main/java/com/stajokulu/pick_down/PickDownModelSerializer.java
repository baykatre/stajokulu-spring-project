package com.stajokulu.pick_down;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class PickDownModelSerializer extends StdSerializer<PickDownModel> {

    public PickDownModelSerializer(Class<PickDownModel> t) {
        super(t);
    }

    public PickDownModelSerializer() {
        this(null);
    }

    @Override
    public void serialize(PickDownModel pickDownModel, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("plate", pickDownModel.getVehicle().getPlate());
        jsonGenerator.writeFieldName("route");
        jsonGenerator.writeStartArray();
        pickDownModel
                .getDeliveryPointDeliveriesMap()
                .forEach(
                        (deliveryPoint, shipments) -> {
                            try {
                                jsonGenerator.writeStartObject();
                                jsonGenerator.writeNumberField("deliveryPoint", deliveryPoint.getId());
                                jsonGenerator.writeFieldName("deliveries");
                                jsonGenerator.writeStartArray();
                                shipments.forEach(
                                        shipment -> {
                                            try {
                                                jsonGenerator.writeStartObject();
                                                jsonGenerator.writeStringField("barcode", shipment.getBarcode());
                                                jsonGenerator.writeStringField("state", shipment.getStatus().getName());
                                                jsonGenerator.writeEndObject();
                                            } catch (IOException e) {
                                                throw new RuntimeException(e);
                                            }
                                        });
                                jsonGenerator.writeEndArray();
                                jsonGenerator.writeEndObject();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
