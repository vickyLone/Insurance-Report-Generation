package com.vicky.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="CustomerTab")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String gender;
	private String planName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String planStatus;
	private Double benifitAmount;
	private LocalDate terminateDate;
	private String terminationReason;
	private String denialReason;

}
