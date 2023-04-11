package com.vicky.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vicky.entity.Customer;

public class ExcelGenerator {
	
	private List < Customer > customerExcel;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenerator(List < Customer > customerExcel) {
        this.customerExcel = customerExcel;
        workbook = new XSSFWorkbook();
    }
    private void writeHeader() {
        sheet = workbook.createSheet("Customers_Report");
        XSSFRow row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "ID", style);
        createCell(row, 1, "Name", style);
        createCell(row, 2, "Gender", style);
    }
    private void createCell(XSSFRow row, int columnCount, String valueOfCell, CellStyle style) {
		// TODO Auto-generated method stub
		
	}
	private void createCell(XSSFRow row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        XSSFCell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }
    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (Customer reportExcel: customerExcel) {
            XSSFRow row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, reportExcel.getId(), style);
            createCell(row, columnCount++, reportExcel.getName(), style);
            createCell(row, columnCount++, reportExcel.getGender(), style);
            createCell(row, columnCount++, reportExcel.getEmail(), style);

        }
    }
    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
