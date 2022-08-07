package com.stajokulu.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;

    @GetMapping("/vehicle/{plate}")
    public ResponseEntity<Vehicle> getVehicle(String plate){

        Vehicle vehicle = vehicleService.getVehicle(plate);
        return ResponseEntity.ok(vehicle);
    }

    @PostMapping("/vehicle")
    public ResponseEntity<Vehicle> getVehicle(@RequestBody Vehicle vehicle){

        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok(savedVehicle);
    }
}
