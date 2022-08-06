package com.stajokulu.pick_down;

import com.stajokulu.delivery_point.DeliveryPoint;
import com.stajokulu.shipment.*;
import com.stajokulu.shipment.Package;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PickDownService {

    private final ShipmentService shipmentService;

    public PickDownModel pickDown(PickDownModel pickDownModel) {

        Map<DeliveryPoint, List<Shipment>> deliveryPointDeliveriesMap = pickDownModel.getDeliveryPointDeliveriesMap();

        deliveryPointDeliveriesMap.forEach(
                (deliveryPoint, shipments) -> {
                    shipments.forEach(shipment -> {
                        DeliveryPoint shipmentDeliveryPoint = shipment.getDeliveryPoint();
                        if(deliveryPoint.equals(shipmentDeliveryPoint)
                                && isAllowedDeliveryPoint(deliveryPoint, shipment)){
                            shipment.setStatus(ShipmentStatus.UNLOADED);
                        }
                        else {
                            shipment.setStatus(ShipmentStatus.LOADED);
                        }
                        shipmentService.save(shipment);
                    });
                }
        );
        return pickDownModel;
    }

    private boolean isAllowedDeliveryPoint(DeliveryPoint deliveryPoint, Shipment shipment) {

        ShipmentType supportedShipmentType = deliveryPoint.getSupportedShipmentType();
        if(Objects.isNull(supportedShipmentType)){
            return true;
        }

        if(ShipmentType.BAG.equals(supportedShipmentType) && (shipment instanceof Bag
                || (shipment instanceof Package
                    && Objects.nonNull(((Package) shipment).getBag())))){
            return true;
        }

        if(ShipmentType.PACKAGE.equals(supportedShipmentType) && shipment instanceof Package){
            return true;
        }

        return false;
    }
}
