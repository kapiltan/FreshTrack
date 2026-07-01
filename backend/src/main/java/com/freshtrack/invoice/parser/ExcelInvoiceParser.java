package com.freshtrack.invoice.parser;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.freshtrack.invoice.dto.InvoiceUploadRow;

@Component
public class ExcelInvoiceParser implements InvoiceParser {
    @Override
    public boolean supports(String fileName) {
        return fileName.endsWith(".xlsx") || fileName.endsWith(".xls");
    }

    @Override
    public List<InvoiceUploadRow> parse(MultipartFile file) throws IOException {

        List<InvoiceUploadRow> rows = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();

        boolean header = true;
        for (Row excelRow : sheet) {
            if (header) {
                header = false;
                continue; // Skip header row
            }
            InvoiceUploadRow row = new InvoiceUploadRow();
            row.setInvoiceNumber(formatter.formatCellValue(excelRow.getCell(0)));
            row.setWarehouseCode(formatter.formatCellValue(excelRow.getCell(1)));
            row.setVendorName(formatter.formatCellValue(excelRow.getCell(2)));
            Cell dateCell = excelRow.getCell(3);
            if (DateUtil.isCellDateFormatted(dateCell)) {
                row.setInvoiceDate(dateCell.getLocalDateTimeCellValue().toLocalDate());
            } else {
                String date = formatter.formatCellValue(dateCell);
                if (date.contains("T")) {
                    date = date.substring(0, 10);
                }
                row.setInvoiceDate(LocalDate.parse(date));
            }
            row.setSku(formatter.formatCellValue(excelRow.getCell(4)));
            row.setProductName(formatter.formatCellValue(excelRow.getCell(5)));
            String quantity = formatter.formatCellValue(excelRow.getCell(6));
            row.setQuantity(Integer.parseInt(quantity));
            rows.add(row);
        }

        workbook.close();
        // Implement the logic to parse Excel files here
        System.out.println("Parsing Excel file: " + file.getOriginalFilename());
        return rows; // Replace with actual parsed rows
    }

}
