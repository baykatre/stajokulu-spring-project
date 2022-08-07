package com.stajokulu.shipment;

import com.stajokulu.pick_down.PickDownModel;
import com.stajokulu.shipment.dto.BagDto;
import com.stajokulu.shipment.dto.PackageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Bag> createBag(@RequestBody BagDto bagDto){

        Bag bag = shipmentService.createBag(bagDto);
        return ResponseEntity.ok(bag);
    }

    @GetMapping("/bag/{barcode}")
    public ResponseEntity<Bag> getBagByBarcode(@PathVariable String barcode){

        Bag bag = shipmentService.getBag(barcode);
        return ResponseEntity.ok(bag);
    }

    @PostMapping("/assign/{packageBarcode}/{bagBarcode}")
    public ResponseEntity<Bag> assignPackage(@PathVariable String packageBarcode, @PathVariable String bagBarcode) {

        Bag bag = shipmentService.assignPackage(packageBarcode, bagBarcode);
        return ResponseEntity.ok(bag);
    }
}
