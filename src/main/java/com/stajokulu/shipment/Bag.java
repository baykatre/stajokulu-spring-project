package com.stajokulu.shipment;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Bag extends Shipment{

    @OneToMany(fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
    private List<Package> packageList;
}
