package com.freshtrack.warehouse.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freshtrack.warehouse.dto.CreateWarehouseRequest;
import com.freshtrack.warehouse.dto.UpdateWarehouserequest;
import com.freshtrack.warehouse.dto.WarehouseResponse;
import com.freshtrack.warehouse.mapper.WarehouseMapper;
import com.freshtrack.warehouse.model.Warehouse;
import com.freshtrack.warehouse.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;

    @Override
    public WarehouseResponse create(CreateWarehouseRequest request) {
        if (warehouseRepository.findByWarehouseCode(request.getWarehouseCode()).isPresent()) {
            throw new IllegalArgumentException("Warehouse with the same code already exists");
        }
        // Implementation for creating warehouse
        Warehouse warehouse = Warehouse.builder()
                .warehouseCode(request.getWarehouseCode())
                .warehouseName(request.getWarehouseName())
                .city(request.getCity())
                .active(true)
                .build();
        warehouse = warehouseRepository.save(warehouse);
        return WarehouseMapper.toResponse(warehouse);
    }

    @Override
    public List<WarehouseResponse> getAll() {
        return warehouseRepository.findAll().stream()
                .map(WarehouseMapper::toResponse)
                .toList();
    }

    @Override
    public WarehouseResponse getById(String id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
        return WarehouseMapper.toResponse(warehouse);
    }

    @Override
    public WarehouseResponse update(String id, UpdateWarehouserequest request) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
        warehouse.setWarehouseName(request.getWarehouseName());
        warehouse.setCity(request.getCity());
        warehouse.setActive(request.isActive());
        warehouse = warehouseRepository.save(warehouse);
        return WarehouseMapper.toResponse(warehouse);
    }

    @Override
    public void delete(String id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
        warehouseRepository.delete(warehouse);
    }

}
