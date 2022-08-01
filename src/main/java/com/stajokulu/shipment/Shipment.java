package com.stajokulu.shipment;

import com.stajokulu.delivery_point.DeliveryPoint;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.utility.nullability.NeverNull;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Shipment {

    @Id
    private String barcode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_POINT_VALUE")
    private DeliveryPoint deliveryPoint;

    @Convert(converter = ShipmentStatusTypeConverter.class)
    private ShipmentStatus status;
}
