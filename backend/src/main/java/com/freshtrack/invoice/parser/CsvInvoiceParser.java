package com.freshtrack.invoice.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.freshtrack.invoice.dto.InvoiceUploadRow;

@Component
public class CsvInvoiceParser implements InvoiceParser {
    @Override
    public boolean supports(String fileName) {
        return fileName.toLowerCase().endsWith(".csv");
    }

    @Override
    public List<InvoiceUploadRow> parse(MultipartFile file) throws IOException {
        // Implement CSV parsing logic here
        List<InvoiceUploadRow> rows = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build()
                .parse(reader);
        System.out.println("Parsing CSV file: " + file.getOriginalFilename());
        for (CSVRecord record : records) {
            InvoiceUploadRow row = new InvoiceUploadRow();
            row.setInvoiceNumber(record.get("Invoice Number"));
            row.setWarehouseCode(record.get("Warehouse Code"));
            row.setVendorName(record.get("Vendor Name"));
            row.setInvoiceDate(LocalDate.parse(record.get("Invoice Date")));
            row.setSku(record.get("SKU"));
            row.setProductName(record.get("Product Name"));
            row.setQuantity(Integer.parseInt(record.get("Quantity")));
            rows.add(row);
        }
        return rows;
    }
}
