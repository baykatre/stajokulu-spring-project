package com.stajokulu.dto;

import com.stajokulu.shipment.Shipment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class BagDto extends Shipment {

    private List<PackageDto> packageDtoList;
}
