package com.vicky.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
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

	private List<Customer> customerExcel;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	//private EmailSender emailSender;


	public ExcelGenerator(List<Customer> customerExcel ) {
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
		createCell(row, 3, "Email", style);
		createCell(row, 4, "Plan Name", style);
		createCell(row, 5, "Plan Status", style);
		createCell(row, 6, "Start Date", style);
		createCell(row, 7, "End Date", style);
		createCell(row, 8, "Denial Reason", style);
		createCell(row, 9, "Termination Reason", style);
		createCell(row, 10, "Termination Date", style);
		createCell(row, 11, "Benefit amount", style);

		
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
		} else if (valueOfCell instanceof LocalDate) {
			cell.setCellValue((LocalDate) valueOfCell);
		}else if (valueOfCell instanceof Double) {
			cell.setCellValue((Double) valueOfCell);
		}

		cell.setCellStyle(style);
	}

	private void write() {
		int rowCount = 1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(10);
		style.setFont(font);
		for (Customer reportExcel : customerExcel) {
			XSSFRow row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, reportExcel.getId(), style);
			createCell(row, columnCount++, reportExcel.getName(), style);
			createCell(row, columnCount++, reportExcel.getGender(), style);
			createCell(row, columnCount++, reportExcel.getEmail(), style);
			createCell(row, columnCount++, reportExcel.getPlanName(), style);
			createCell(row, columnCount++, reportExcel.getPlanStatus(), style);
			createCell(row, columnCount++, reportExcel.getStartDate() + "", style);
			createCell(row, columnCount++, reportExcel.getEndDate() + "", style);
			createCell(row, columnCount++, reportExcel.getDenialReason(), style);
			createCell(row, columnCount++, reportExcel.getTerminationReason(), style);
			createCell(row, columnCount++, reportExcel.getTerminateDate() + "", style);
			createCell(row, columnCount++, reportExcel.getBenifitAmount(), style);

		}
	}

	public void generateExcelFile(HttpServletResponse response,File file) throws IOException {
		writeHeader();
		write();
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		//outputStream.close();
	
		workbook.close();
      
	}		
	


}
