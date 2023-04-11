package com.vicky.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.vicky.entity.Customer;
import com.vicky.formBinder.SearchRequest;
import com.vicky.repo.CustomerRepositary;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepositary repo;

	@Override
	public List<Customer> getAll() {

		List<Customer> customers = repo.findAll();

		return customers;

	}

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

}
