package com.stajokulu.pick_down;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.stajokulu.delivery_point.DeliveryPoint;
import com.stajokulu.shipment.Shipment;
import com.stajokulu.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = PickDownModelSerializer.class)
@JsonDeserialize(using = PickDownModelDeserializer.class)
public class PickDownModel {

    private Vehicle vehicle;

    private Map<DeliveryPoint, List<Shipment>> deliveryPointDeliveriesMap;

    //serialize
}
