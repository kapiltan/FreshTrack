package com.freshtrack.invoice.model;

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
@Document(collection = "invoice_items")
public class InvoiceItem {
    @Id
    private String id;
    private String invoiceId;
    private String sku;
    private String productName;
    private Integer expectedQuantity;
    private Integer receivedQuantity;
}
