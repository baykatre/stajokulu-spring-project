package com.stajokulu.shipment;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public class ShipmentStatusTypeConverter implements AttributeConverter<ShipmentStatus, String> {


    @Override
    public String convertToDatabaseColumn(ShipmentStatus shipmentStatus) {
        return shipmentStatus.getName();
    }

    @Override
    public ShipmentStatus convertToEntityAttribute(String s) {
        return Arrays.stream(ShipmentStatus.values())
                .filter(status -> status.getName().equals(s))
                .findAny()
                .orElse(null);
    }
}
