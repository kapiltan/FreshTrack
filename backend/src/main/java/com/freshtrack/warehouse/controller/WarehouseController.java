package com.freshtrack.warehouse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freshtrack.warehouse.Service.WarehouseService;
import com.freshtrack.warehouse.dto.CreateWarehouseRequest;
import com.freshtrack.warehouse.dto.UpdateWarehouserequest;
import com.freshtrack.warehouse.dto.WarehouseResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/warehouses")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;

    @GetMapping
    public List<WarehouseResponse> getAllWarehouses() {
        return warehouseService.getAll();
    }

    @GetMapping("/{id}")
    public WarehouseResponse getWarehouseById(@PathVariable String id) {
        return warehouseService.getById(id);
    }

    @PostMapping
    public WarehouseResponse createWarehouse(@RequestBody CreateWarehouseRequest request) {
        return warehouseService.create(request);
    }

    @PutMapping("/{id}")
    public WarehouseResponse updateWarehouse(@PathVariable String id, @RequestBody UpdateWarehouserequest request) {
        return warehouseService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable String id) {
        warehouseService.delete(id);
    }
}
