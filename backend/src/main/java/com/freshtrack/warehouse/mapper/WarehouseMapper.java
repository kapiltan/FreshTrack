package com.freshtrack.warehouse.mapper;

import com.freshtrack.warehouse.dto.WarehouseResponse;
import com.freshtrack.warehouse.model.Warehouse;

public class WarehouseMapper {

    public static WarehouseResponse toResponse(Warehouse warehouse) {
        return WarehouseResponse.builder()
                .id(warehouse.getId())
                .warehouseName(warehouse.getWarehouseName())
                .warehouseCode(warehouse.getWarehouseCode())
                .city(warehouse.getCity())
                .active(warehouse.isActive())
                .build();
    }
}
