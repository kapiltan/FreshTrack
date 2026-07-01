package com.freshtrack.invoice.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "invoices")
public class Invoice {
    @Id
    private String id;
    private String invoiceNumber;
    private String warehouseId;
    private String vendorName;
    private LocalDateTime invoiceDate;
    private int totalItems;
    private boolean received;
    private LocalDateTime uploadedAt;
}
