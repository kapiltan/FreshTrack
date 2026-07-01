package com.freshtrack.warehouse.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WarehouseResponse {
    private String id;
    private String warehouseName;
    private String warehouseCode;
    private String city;
    private boolean active;
}
