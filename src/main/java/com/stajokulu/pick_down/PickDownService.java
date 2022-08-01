package com.stajokulu.pick_down;

import com.stajokulu.shipment.ShipmentService;
import com.stajokulu.shipment.ShipmentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class PickDownService {

    private ShipmentService shipmentService;

    public PickDownModel pickDown(PickDownModel pickDownModel) {
        return null;
    }
}
