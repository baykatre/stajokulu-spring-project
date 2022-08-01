package com.stajokulu.shipment.dto;

import com.stajokulu.shipment.Shipment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageDto extends ShipmentDto {

    private Integer weight;
}
