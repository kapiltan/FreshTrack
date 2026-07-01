package com.freshtrack.invoice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.freshtrack.invoice.model.InvoiceItem;

public interface InvoiceItemRepository extends MongoRepository<InvoiceItem, String> {
    List<InvoiceItem> findByInvoiceId(String invoiceId);
}
