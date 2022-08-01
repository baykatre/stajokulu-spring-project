package com.stajokulu.shipment;

import com.stajokulu.shipment.dto.BagDto;
import com.stajokulu.shipment.dto.PackageDto;
import com.stajokulu.shipment.mapper.ShipmentDefaultMapper;
import com.stajokulu.shipment.mapper.ShipmentMapper;
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

        Bag bag = ShipmentDefaultMapper.convertToBag(bagDto);
        return bagRepository.save(bag);
    }

    public Package createPackage(PackageDto pkgDto) {

        Package pkg = ShipmentDefaultMapper.convertToPackage(pkgDto);
        return packageRepository.save(pkg);
    }

    public Bag assignPackage(String packageBarcode, String bagBarcode) throws Exception {

        Package pkg = packageRepository.findById(packageBarcode).orElse(null);
        Bag bag = bagRepository.findById(bagBarcode).orElse(null);

        if(Objects.isNull(pkg) || Objects.isNull(bag)){
            throw new Exception("Barkodlarda hata var!");
        }

        pkg.setStatus(ShipmentStatus.LOADED_INTO_BAG);
        List<Package> packageList = bag.getPackageList();
        packageList.add(pkg);

        return bagRepository.save(bag);
    }

    public Bag getBag(String barcode) {

        return bagRepository.findById(barcode).orElse(null);
    }
}
