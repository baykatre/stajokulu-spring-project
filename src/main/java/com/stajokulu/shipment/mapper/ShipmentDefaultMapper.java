package com.stajokulu.shipment.mapper;

import com.stajokulu.shipment.Bag;
import com.stajokulu.shipment.Package;
import com.stajokulu.shipment.ShipmentStatus;
import com.stajokulu.shipment.dto.BagDto;
import com.stajokulu.shipment.dto.PackageDto;
import com.stajokulu.shipment.dto.ShipmentDto;

import java.util.Arrays;
import java.util.Objects;

public class ShipmentDefaultMapper {

    public static Bag convertToBag(BagDto bagDto) {
        Bag bag = new Bag();
        bag.setBarcode(bagDto.getBarcode());
        bag.setStatus(getStatus(bagDto));
        return bag;
    }

    public static Package convertToPackage(PackageDto packageDto) {
        Package pkg = new Package();
        pkg.setBarcode(packageDto.getBarcode());
        pkg.setStatus(getStatus(packageDto));
        return pkg;
    }

    private static ShipmentStatus getStatus(ShipmentDto shipmentDto) {

        if(Objects.isNull(shipmentDto.getStatus())){
            return ShipmentStatus.CREATED;
        }
        return Arrays.stream(ShipmentStatus.values())
                .filter(shipmentStatus ->
                        shipmentStatus.getName().equals(shipmentDto.getStatus()))
                .filter(shipmentStatus ->
                        Objects.isNull(shipmentStatus.getClazz())
                                || shipmentDto.getClass().equals(shipmentStatus.getClazz()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Hatalı tip gönderildi!"));
    }
}
