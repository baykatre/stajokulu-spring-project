package com.stajokulu.shipment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BagRepository extends JpaRepository<Bag, String> {
}
