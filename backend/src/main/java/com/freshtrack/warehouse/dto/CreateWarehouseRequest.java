package com.freshtrack.warehouse.dto;

import lombok.Data;

@Data
public class CreateWarehouseRequest {
    private String warehouseName;
    private String warehouseCode;
    private String city;
}
