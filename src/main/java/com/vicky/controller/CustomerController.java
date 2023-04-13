package com.vicky.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lowagie.text.DocumentException;
import com.vicky.entity.Customer;
import com.vicky.formBinder.SearchRequest;
import com.vicky.service.CustomerService;

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
	public String getExcelFile(HttpServletResponse response, Model model) throws Exception {

		service.generateExcel(response);

		model.addAttribute("searchRequest", new SearchRequest());
		init(model);

		return "index";

	}

	@GetMapping("/pdf")
	public String exportToPdfFile(HttpServletResponse response, Model model) throws IOException, DocumentException, MessagingException {

		service.generatePdf(response);

		model.addAttribute("searchRequest", new SearchRequest());
		init(model);

		return "index";
	}

}
