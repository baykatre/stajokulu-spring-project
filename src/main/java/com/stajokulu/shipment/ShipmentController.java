package com.stajokulu.shipment;

import com.stajokulu.pick_down.PickDownModel;
import com.stajokulu.shipment.dto.BagDto;
import com.stajokulu.shipment.dto.PackageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping("/package")
    public Package createPackage(@RequestBody PackageDto pkg){

        return shipmentService.createPackage(pkg);
    }

    @PostMapping("/bag")
    public Bag createBag(@RequestBody BagDto bag){

        return shipmentService.createBag(bag);
    }

    @GetMapping("/bag/{barcode}")
    public Bag getBagByBarcode(@PathVariable String barcode){

        return shipmentService.getBag(barcode);
    }

    @PostMapping("/assign/{packageBarcode}/{bagBarcode}")
    public Bag assignPackage(@PathVariable String packageBarcode, @PathVariable String bagBarcode) throws Exception {

        return shipmentService.assignPackage(packageBarcode, bagBarcode);
    }
}
