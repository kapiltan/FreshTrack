package com.freshtrack.invoice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.freshtrack.invoice.model.Invoice;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {
    Optional<Invoice> findByInvoiceNumber(String invoiceNumber);
}
