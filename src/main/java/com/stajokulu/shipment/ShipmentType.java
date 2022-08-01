package com.stajokulu.shipment;

import lombok.Getter;

@Getter
public enum ShipmentType {

    PACKAGE(Package.class, "P"), BAG(Bag.class, "B");

    private Class clazz;

    private String name;

    ShipmentType(Class clazz, String name) {
        this.clazz = clazz;
        this.name = name;
    }
}
