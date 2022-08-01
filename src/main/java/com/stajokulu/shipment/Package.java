package com.stajokulu.shipment;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Package extends Shipment {

    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "BAG_BARCODE")
    private Bag bag;
}
