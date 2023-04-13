package com.vicky.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vicky.entity.Customer;

public class PdfGenerator {

	
	
	public void create(List<Customer> customersPdf, HttpServletResponse response,File file)
			throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document,new FileOutputStream(file) );
		document.open();
		Font fontTitle = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE);
		fontTitle.setSize(20);
		Paragraph p1 = new Paragraph("Customer List", fontTitle);
		// aligning the paragraph
		p1.setAlignment(Paragraph.ALIGN_CENTER);
		// adding the created paragraph in the document obj
		document.add(p1);
		// Creating a table of with column numbers
		PdfPTable table = new PdfPTable(10);
		// Setting width of the table and its columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 });
		table.setSpacingBefore(2);
		// Creating table cells for the table header

		PdfPCell cell = new PdfPCell();
		// setting background color and padding of the table cells
		cell.setBackgroundColor(CMYKColor.CYAN);
		cell.setPadding(3);
		// Creating font and Setting font style and size
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);
		font.setStyle(Font.BOLD);
		font.setSize(10);

		// Adding headings in the created table cell or header
		// Adding Cell to table
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Holder's Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Gender", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Email", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Status", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Start Date", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("End Date", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Termination Date", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Benifit Amount", font));
		table.addCell(cell);

		// Iterating the list of students
		for (Customer pdf : customersPdf) {
			table.addCell(String.valueOf(pdf.getId()));
			table.addCell(pdf.getName());
			table.addCell(pdf.getGender());
			table.addCell(pdf.getEmail());
			table.addCell(pdf.getPlanName());
			table.addCell(pdf.getPlanStatus());
			if (null != pdf.getStartDate()) {
				table.addCell(pdf.getStartDate() + "");
			} else {
				table.addCell("N/A");
			}
			if (null != pdf.getEndDate()) {
				table.addCell(pdf.getEndDate() + "");
			} else {
				table.addCell("N/A");
			}
			if (null != pdf.getTerminateDate()) {
				table.addCell(pdf.getTerminateDate() + "");
			} else {
				table.addCell("N/A");
			}
			if (null != pdf.getBenifitAmount()) {
				table.addCell(String.valueOf(pdf.getBenifitAmount()));
			} else {
				table.addCell("N/A");
			}

		}
		// Adding the created table to the document
		document.add(table);

		document.close();

	}

}