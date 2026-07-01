package com.freshtrack.warehouse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "warehouses")
public class Warehouse {

    @Id
    private String id;
    private String warehouseName;
    private String warehouseCode;
    private String city;
    private boolean active;
}
