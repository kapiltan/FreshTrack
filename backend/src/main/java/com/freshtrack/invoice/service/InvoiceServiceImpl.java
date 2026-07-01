package com.freshtrack.invoice.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.freshtrack.invoice.dto.InvoiceUploadRow;
import com.freshtrack.invoice.dto.UploadInvoiceResponse;
import com.freshtrack.invoice.model.Invoice;
import com.freshtrack.invoice.model.InvoiceItem;
import com.freshtrack.invoice.parser.InvoiceParser;
import com.freshtrack.invoice.repository.InvoiceItemRepository;
import com.freshtrack.invoice.repository.InvoiceRepository;
import com.freshtrack.warehouse.model.Warehouse;
import com.freshtrack.warehouse.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceItemRepository invoiceItemRepository;
    private final WarehouseRepository warehouseRepository;
    private final List<InvoiceParser> parsers;

    @Override
    public UploadInvoiceResponse uploadInvoice(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.isEmpty()) {
            throw new RuntimeException("File name cannot be null or empty");
        }

        InvoiceParser parser = parsers.stream()
                .filter(p -> p.supports(file.getOriginalFilename()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unsupported file format: " + fileName));

        List<InvoiceUploadRow> row = parser.parse(file);
        if (row.isEmpty()) {
            throw new RuntimeException("No rows found in the uploaded file: " + fileName);
        }
        InvoiceUploadRow firstRow = row.get(0);
        if (invoiceRepository.findByInvoiceNumber(firstRow.getInvoiceNumber()).isPresent()) {
            throw new RuntimeException("Invoice with number " + firstRow.getInvoiceNumber() + " already exists.");
        }
        System.out.println("Parsed " + row.size() + " rows from file: " + fileName);

        Warehouse warehouse = warehouseRepository.findByWarehouseCode(firstRow.getWarehouseCode())
                .orElseThrow(() -> new RuntimeException(
                        "Warehouse with code " + firstRow.getWarehouseCode() + " does not exist."));

        Invoice invoice = Invoice.builder()
                .invoiceNumber(firstRow.getInvoiceNumber())
                .warehouseId(warehouse.getId())
                .vendorName(firstRow.getVendorName())
                .invoiceDate(firstRow.getInvoiceDate().atStartOfDay())
                .totalItems(row.size())
                .received(false)
                .uploadedAt(LocalDateTime.now())
                .build();

        Invoice savedInvoice = invoiceRepository.save(invoice);

        List<InvoiceItem> items = row.stream()
                .map(r -> InvoiceItem.builder()
                        .invoiceId(savedInvoice.getId())
                        .sku(r.getSku())
                        .productName(r.getProductName())
                        .expectedQuantity(r.getQuantity())
                        .receivedQuantity(0)
                        .build())
                .toList();
        invoiceItemRepository.saveAll(items);

        return UploadInvoiceResponse.builder()
                .invoiceId(savedInvoice.getId())
                .invoiceNumber(savedInvoice.getInvoiceNumber())
                .totalItems(items.size())
                .build();
    }
}
