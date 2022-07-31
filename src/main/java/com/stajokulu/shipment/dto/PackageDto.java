package com.stajokulu.dto;

import com.stajokulu.shipment.Shipment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class PackageDto extends Shipment {

    private Integer weight;
}
