package com.stajokulu.shipment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ShipmentDto {

    private String barcode;

    private Integer deliveryPoint;

    private String status;
}
