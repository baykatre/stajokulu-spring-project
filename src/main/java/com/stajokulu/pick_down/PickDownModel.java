package com.stajokulu.pick_down;

import com.stajokulu.delivery_point.DeliveryPoint;
import com.stajokulu.shipment.Shipment;
import com.stajokulu.vehicle.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PickDownModel {

    private Vehicle vehicle;

    private Map<DeliveryPoint, List<Shipment>> deliveryPointDeliveriesMap;
}
