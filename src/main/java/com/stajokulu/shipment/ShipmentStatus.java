package com.stajokulu.shipment;

import com.stajokulu.shipment.dto.PackageDto;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum ShipmentStatus {

    CREATED("C", null),
    LOADED_INTO_BAG("LIB", PackageDto.class),
    LOADED("L", null),
    UNLOADED("U", null);

    private String name;

    private Class clazz;

    ShipmentStatus(String name, Class clazz) {
        this.name = name;
        this.clazz = clazz;
    }
}
