package com.vicky.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vicky.entity.Customer;
import com.vicky.formBinder.SearchRequest;
import com.vicky.service.CustomerService;
import com.vicky.utils.ExcelGenerator;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;


	@PostMapping("/search")
	public String searchButton(@ModelAttribute("searchRequest") SearchRequest search, Model model) {

		List<Customer> dynamicSearch = service.dynamicSearch(search);
		model.addAttribute("dynamicSearch", dynamicSearch);
		init(model);

		return "index";

	}

	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		
		model.addAttribute("searchRequest", new SearchRequest());
		init(model);

		return "index";

	}

	private void init(Model model) {
		model.addAttribute("name", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	}

	@GetMapping("/excel")
	public void getExcelFile(HttpServletResponse response) throws IOException {

		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=Reports" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<Customer> excel = service.getAll();
		ExcelGenerator generator = new ExcelGenerator(excel);
		generator.generateExcelFile(response);
		

	}
    
	
    
	
	
	
	
}
