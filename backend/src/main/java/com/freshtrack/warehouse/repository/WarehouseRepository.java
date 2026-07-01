package com.freshtrack.warehouse.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.freshtrack.warehouse.model.Warehouse;

public interface WarehouseRepository extends MongoRepository<Warehouse, String> {
    Optional<Warehouse> findByWarehouseCode(String warehouseCode);
}