package com.freshtrack.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadInvoiceResponse {
    private String invoiceId;
    private String invoiceNumber;
    private Integer totalItems;
    private String message;
}
