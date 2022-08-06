package com.stajokulu.delivery_point;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stajokulu.shipment.ShipmentType;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPoint implements Comparable<DeliveryPoint>  {

    @Id
    private Integer id;

    private String name;

    private ShipmentType supportedShipmentType;

    @Override
    public int compareTo(DeliveryPoint o) {
        return o.getId();
    }
}
