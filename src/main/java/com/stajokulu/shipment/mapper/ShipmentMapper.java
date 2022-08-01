package com.stajokulu.shipment.mapper;

import com.stajokulu.shipment.Bag;
import com.stajokulu.shipment.Package;
import com.stajokulu.shipment.dto.BagDto;
import com.stajokulu.shipment.dto.PackageDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShipmentMapper {

    ShipmentMapper INSTANCE = Mappers.getMapper(ShipmentMapper.class);

    Package convertToPackage(PackageDto packageDto);

    Bag convertToBag(BagDto bagDto);
}
