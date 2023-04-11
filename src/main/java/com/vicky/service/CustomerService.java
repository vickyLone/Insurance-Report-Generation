package com.vicky.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vicky.entity.Customer;
import com.vicky.formBinder.SearchRequest;

@Service  
public interface CustomerService {
	
	
	List<Customer> getAll();

	List<Customer> dynamicSearch(SearchRequest search);

	List<String> getPlanName();

	List<String> getPlanStatus();



	

}
