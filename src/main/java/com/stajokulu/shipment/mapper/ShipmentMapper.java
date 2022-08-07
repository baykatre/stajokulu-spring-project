package com.stajokulu.shipment.mapper;

import com.stajokulu.delivery_point.DeliveryPoint;
import com.stajokulu.delivery_point.DeliveryPointService;
import com.stajokulu.shipment.Bag;
import com.stajokulu.shipment.Package;
import com.stajokulu.shipment.ShipmentStatus;
import com.stajokulu.shipment.dto.BagDto;
import com.stajokulu.shipment.dto.PackageDto;
import com.stajokulu.tools.ApplicationContextProvider;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShipmentMapper {

    ShipmentMapper INSTANCE = Mappers.getMapper(ShipmentMapper.class);
    @Mapping(source = "deliveryPoint", target = "deliveryPoint", qualifiedByName = "mapToDeliveryPoint")
    @Mapping(source = "status", target = "status", qualifiedByName = "mapToShipmentStatus")
    Package convertToPackage(PackageDto packageDto);

    @Mapping(source = "deliveryPoint", target = "deliveryPoint", qualifiedByName = "mapToDeliveryPoint")
    @Mapping(source = "status", target = "status", qualifiedByName = "mapToShipmentStatus")
    Bag convertToBag(BagDto bagDto);

    @Named("mapToDeliveryPoint")
    public static DeliveryPoint mapToDeliveryPoint(int id) {
        DeliveryPointService deliveryPointService = ApplicationContextProvider.getInstance().getBean(DeliveryPointService.class);

        return deliveryPointService.getDeliveryPoint(id);
    }

    @Named("mapToShipmentStatus")
    public static ShipmentStatus mapToShipmentStatus(String name) {

        return ShipmentStatus.getFromName(name);
    }
}
