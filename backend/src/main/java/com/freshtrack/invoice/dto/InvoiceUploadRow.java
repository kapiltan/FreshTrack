package com.freshtrack.invoice.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InvoiceUploadRow {
    private String invoiceNumber;
    private String warehouseCode;
    private String vendorName;
    private LocalDate invoiceDate;
    private String sku;
    private String productName;
    private Integer quantity;
}
