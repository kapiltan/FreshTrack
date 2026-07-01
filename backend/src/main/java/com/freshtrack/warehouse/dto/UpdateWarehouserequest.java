package com.freshtrack.warehouse.dto;

import lombok.Data;

@Data
public class UpdateWarehouserequest {
    private String warehouseName;
    private String city;
    private boolean active;
}
