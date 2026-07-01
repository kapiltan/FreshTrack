package com.freshtrack.invoice.parser;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.freshtrack.invoice.dto.InvoiceUploadRow;

public interface InvoiceParser {
    boolean supports(String fileName);

    List<InvoiceUploadRow> parse(MultipartFile file) throws IOException;
}
