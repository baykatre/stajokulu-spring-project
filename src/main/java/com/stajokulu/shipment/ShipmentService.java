package com.stajokulu.shipment;

import com.stajokulu.shipment.dto.BagDto;
import com.stajokulu.shipment.dto.PackageDto;
import com.stajokulu.shipment.mapper.ShipmentDefaultMapper;
import com.stajokulu.shipment.mapper.ShipmentMapper;
import com.stajokulu.tools.CustomGenericException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final BagRepository bagRepository;

    private final PackageRepository packageRepository;

    public Bag createBag(BagDto bagDto) {

        Bag bag = ShipmentMapper.INSTANCE.convertToBag(bagDto);
        return bagRepository.save(bag);
    }

    public Package createPackage(PackageDto pkgDto) {

        Package pkg = ShipmentMapper.INSTANCE.convertToPackage(pkgDto);
        return packageRepository.save(pkg);
    }

    public Bag assignPackage(String packageBarcode, String bagBarcode) {

        Package pkg = packageRepository.findById(packageBarcode).orElse(null);
        Bag bag = bagRepository.findById(bagBarcode).orElse(null);

        if(Objects.isNull(pkg) || Objects.isNull(bag)){
            throw new CustomGenericException("Barkodlarda hata var!");
        }

        pkg.setStatus(ShipmentStatus.LOADED_INTO_BAG);
        List<Package> packageList = bag.getPackageList();
        packageList.add(pkg);

        return bagRepository.save(bag);
    }

    public Bag getBag(String barcode) {

        return bagRepository.findById(barcode).orElse(null);
    }

    public Shipment getShipment(String barcode){
        Package pkg = packageRepository.findById(barcode).orElse(null);
        Bag bag = bagRepository.findById(barcode).orElse(null);

        if(Objects.isNull(pkg) && Objects.isNull(bag)){
            throw new RuntimeException("Barkod bulunamad─▒!");
        }

        return Objects.nonNull(pkg) ? pkg : bag; //ternary
    }

    public void save(Shipment shipment) {

        if(shipment instanceof Package){
            packageRepository.save((Package) shipment);
            return;
        }

        bagRepository.save((Bag) shipment);
    }
}
