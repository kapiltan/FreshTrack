package com.freshtrack.warehouse.Service;

import java.util.List;

import com.freshtrack.warehouse.dto.CreateWarehouseRequest;
import com.freshtrack.warehouse.dto.UpdateWarehouserequest;
import com.freshtrack.warehouse.dto.WarehouseResponse;

public interface WarehouseService {
    WarehouseResponse create(CreateWarehouseRequest request);

    List<WarehouseResponse> getAll();

    WarehouseResponse getById(String id);

    WarehouseResponse update(String id, UpdateWarehouserequest request);

    void delete(String id);
}
