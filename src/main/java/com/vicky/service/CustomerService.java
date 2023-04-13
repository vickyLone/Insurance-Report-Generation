package com.vicky.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.vicky.entity.Customer;
import com.vicky.formBinder.SearchRequest;

@Service  
public interface CustomerService {
	
	

	List<Customer> dynamicSearch(SearchRequest search);

	List<String> getPlanName();

	List<String> getPlanStatus();
	
	public boolean generateExcel(HttpServletResponse response) throws Exception;
	
	public boolean generatePdf(HttpServletResponse response) throws DocumentException, IOException, MessagingException;



	

}
