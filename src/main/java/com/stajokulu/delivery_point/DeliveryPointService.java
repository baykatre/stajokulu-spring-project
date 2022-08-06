package com.stajokulu.delivery_point;

import com.stajokulu.vehicle.Vehicle;
import com.stajokulu.vehicle.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryPointService {

    private final DeliveryPointRepository deliveryPointRepository;

    public DeliveryPoint getDeliveryPoint(Integer id) {

        DeliveryPoint deliveryPoint = deliveryPointRepository.findById(id).orElse(null);
        return deliveryPoint;
    }
}
