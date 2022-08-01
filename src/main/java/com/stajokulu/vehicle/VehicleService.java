package com.stajokulu.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle getVehicle(String plate) {

        return vehicleRepository.findById(plate).orElse(null);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {

        return vehicleRepository.save(vehicle);
    }
}
