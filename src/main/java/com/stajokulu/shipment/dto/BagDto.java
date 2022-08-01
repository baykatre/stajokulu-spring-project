package com.stajokulu.shipment.dto;

import com.stajokulu.shipment.Shipment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BagDto extends ShipmentDto {

    private List<PackageDto> packageDtoList;
}
