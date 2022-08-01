package com.stajokulu.delivery_point;

import com.stajokulu.shipment.ShipmentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class DeliveryPoint {

    @Id
    private Integer id;

    private String name;

    private ShipmentType supportedShipmentType;
}
