package com.freshtrack.invoice.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.freshtrack.invoice.dto.UploadInvoiceResponse;

public interface InvoiceService {
    UploadInvoiceResponse uploadInvoice(MultipartFile file) throws IOException;
}
