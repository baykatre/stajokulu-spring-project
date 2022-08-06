package com.stajokulu.shipment;

import org.springframework.util.ObjectUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Objects;

@Converter(autoApply = true)
public class ShipmentTypeConverter implements AttributeConverter<ShipmentType, String> {


    @Override
    public String convertToDatabaseColumn(ShipmentType shipmentType) {

        if (Objects.nonNull(shipmentType)) {
            return shipmentType.getName();
        }
        return null;
    }

    @Override
    public ShipmentType convertToEntityAttribute(String s) {

        if(ObjectUtils.isEmpty(s)){
            return null;
        }

        return Arrays.stream(ShipmentType.values())
                .filter(type -> type.getName().equals(s))
                .findAny()
                .orElse(null);
    }
}
