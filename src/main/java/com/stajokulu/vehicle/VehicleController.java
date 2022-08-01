package com.stajokulu.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;

    @GetMapping("/vehicle/{plate}")
    public Vehicle getVehicle(String plate){

        return vehicleService.getVehicle(plate);
    }

    @PostMapping("/vehicle")
    public Vehicle getVehicle(@RequestBody Vehicle vehicle){

        return vehicleService.saveVehicle(vehicle);
    }
}
