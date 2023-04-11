package com.vicky.utils;

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

	 public void create(List<Customer> customersPdf, HttpServletResponse response)throws DocumentException, IOException{

		 Document document = new Document(PageSize.A4);

		 PdfWriter.getInstance(document, response.getOutputStream());
		 document.open();
			Font fontTitle = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE);
			fontTitle.setSize(20);
			Paragraph p1 = new Paragraph("Customer List", fontTitle);
			// aligning the paragraph
			p1.setAlignment(Paragraph.ALIGN_CENTER);
			// adding the created paragraph in the document obj
			document.add(p1);
			// Creating a table of 4 columns
			PdfPTable table = new PdfPTable(4);
			// Setting width of the table and its columns and spacing
			table.setWidthPercentage(100f);
			table.setWidths(new int[] { 3, 3, 3, 3 });
			table.setSpacingBefore(5);
			// Creating table cells for the table header
			
			PdfPCell cell = new PdfPCell();
			// setting background color and padding of the table cells
			cell.setBackgroundColor(CMYKColor.MAGENTA);
			cell.setPadding(7);
			// Creating font and Setting font style and size
			Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			font.setColor(CMYKColor.WHITE);
			font.setStyle(Font.BOLD);
			font.setSize(12);

			// Adding headings in the created table cell or header
			// Adding Cell to table
			cell.setPhrase(new Phrase("ID", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Name", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Gender", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Email", font));
			
			table.addCell(cell);
			// Iterating the list of students
			for (Customer pdf : customersPdf) {
				// Adding student id
				table.addCell(String.valueOf(pdf.getId()));
				// Adding student name
				table.addCell(pdf.getName());
				// Adding student email
				table.addCell(pdf.getGender());
				// Adding student mobile
				table.addCell(pdf.getEmail());
			}
			// Adding the created table to the document
			document.add(table);
			// Closing the document
			document.close();



	 }
}
