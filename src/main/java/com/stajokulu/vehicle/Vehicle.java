package com.stajokulu.vehicle;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Vehicle {

    @Id
    private String plate;
}
