package com.vicky.service;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.vicky.entity.Customer;
import com.vicky.formBinder.SearchRequest;
import com.vicky.repo.CustomerRepositary;
import com.vicky.utils.EmailSender;
import com.vicky.utils.ExcelGenerator;
import com.vicky.utils.PdfGenerator;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepositary repo;
	
	@Autowired
    EmailSender emailSender;


	
	@Override
	public List<Customer> dynamicSearch(SearchRequest search) {
		// TODO Auto-generated method stub

		Customer query = new Customer();

		if (search.getPlanName() != null && !"".equals(search.getPlanName())) {

			query.setPlanName(search.getPlanName());

		}

		if (search.getPlanStatus() != null && !"".equals(search.getPlanStatus())) {

			query.setPlanStatus(search.getPlanStatus());

		}

		if (search.getGender() != null && !"".equals(search.getGender())) {

			query.setGender(search.getGender());
		}

		if (search.getStartDate() != null && !"".equals(search.getStartDate())) {

			String startDate = search.getStartDate();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, format);
			query.setStartDate(localDate);
		}

		if (null != search.getEndDate() && !"".equals(search.getEndDate())) {

			String endDate = search.getEndDate();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(endDate, format);

			query.setEndDate(localDate);

		}

		Example<Customer> exmp = Example.of(query);
		
		return repo.findAll(exmp);

	}

	@Override
	public List<String> getPlanName() {
		return repo.getPlanName();

	}

	@Override
	public List<String> getPlanStatus() {

		return repo.getPlanStatus();
	}

	@Override
	public boolean generateExcel(HttpServletResponse response) throws Exception {
		
        		 
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=reports" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		File f = new File("report.xlsx");
		List<Customer> excel = repo.findAll();
		ExcelGenerator generator = new ExcelGenerator(excel);
		generator.generateExcelFile(response,f);
		
		 emailSender.sendEmail("lonevicky@gmail.com", "Hi,Please find  attachment",
					"Customer Report", f);
		
        		
		return true;
	}

	@Override
	public boolean generatePdf(HttpServletResponse response) throws DocumentException, IOException, MessagingException {
        
		File f = new File("report.pdf");
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=reports" +currentDateTime+ ".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<Customer> pdf = repo.findAll();
		PdfGenerator generate = new PdfGenerator();
		generate.create(pdf, response,f);
		
		 emailSender.sendEmail("lonevicky@gmail.com", "Hi,Please find  attachment",
					"Customer Report", f);

       return true;
	}

}
