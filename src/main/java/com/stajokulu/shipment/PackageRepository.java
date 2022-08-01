package com.stajokulu.shipment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, String> {
}
