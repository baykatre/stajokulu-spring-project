package com.stajokulu.dto;

import com.stajokulu.shipment.ShipmentStatus;
import com.stajokulu.shipment.ShipmentStatusTypeConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public abstract class ShipmentDto {

    private String barcode;

    private Integer deliveryPoint;

    private String status;
}
