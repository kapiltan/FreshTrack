package com.freshtrack.invoice.dto;

import lombok.Data;

@Data
public class InvoiceItemUpload {
    private String sku;
    private String productName;
    private Integer quantity;
}
