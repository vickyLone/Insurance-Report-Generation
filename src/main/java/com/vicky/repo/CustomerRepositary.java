package com.vicky.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vicky.entity.Customer;

public interface CustomerRepositary extends JpaRepository<Customer , Integer>{

	@Query("Select distinct(planName) from Customer")
	public List<String> getPlanName();

	
	@Query("Select distinct(planStatus) from Customer")
	public List<String> getPlanStatus();

	
}
