package com.stajokulu.delivery_point;

import com.stajokulu.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPointRepository extends JpaRepository<DeliveryPoint, Integer> {
}
