package com.vicky.runner;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.vicky.entity.Customer;
import com.vicky.repo.CustomerRepositary;

@Component
public class MyRunner implements ApplicationRunner {

	@Autowired
	private CustomerRepositary repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
		Customer c1 = new Customer();
		
		c1.setName("Galena");
		c1.setEmail("curabitur.lectus@outlook.edu");
		c1.setGender("Female");
		c1.setPlanName("Cash");
		c1.setStartDate(LocalDate.of(2022, 11, 01));
		c1.setEndDate(LocalDate.of(2023, 04, 01));
		c1.setPlanStatus("Approved");
		c1.setBenifitAmount(1500.00);

		Customer c2 = new Customer();

		c2.setName("Salma");
		c2.setEmail("curabitur@outlook.com");
		c2.setGender("Female");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Employeed");

		Customer c3 = new Customer();

		c3.setName("Sridevi");
		c3.setEmail("sri112233@gmail.org");
		c3.setGender("Female");
		c3.setPlanName("Cash");
		c3.setStartDate(LocalDate.of(2022, 10, 01));
		c3.setEndDate(LocalDate.of(2023, 10, 01));
		c3.setPlanStatus("Terminated");
		c3.setTerminateDate(LocalDate.of(2023, 05, 01));
		c3.setTerminationReason("Lost Credentials");

		Customer c4 = new Customer();

		c4.setName("Varun");
		c4.setEmail(" vrun11@gmial.com");
		c4.setGender("Male");
		c4.setPlanName("Cash");
		c4.setStartDate(LocalDate.of(2023, 01, 01));
		c4.setEndDate(LocalDate.of(2023, 12, 01));
		c4.setPlanStatus("Approved");
		c4.setBenifitAmount(2500.00);

		Customer c5 = new Customer();

		c5.setName("Maxoo");
		c5.setEmail("Maxoo@gmail.com");
		c5.setGender("Male");
		c5.setPlanName("Cash");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Criminal Record");

		Customer c6 = new Customer();

		c6.setName("Oxland");
		c6.setEmail("oxx@reediffmail.com");
		c6.setGender("Male");
		c6.setPlanName("Cash");
		c6.setStartDate(LocalDate.of(2022, 11, 01));
		c6.setEndDate(LocalDate.of(2023, 04, 01));
		c6.setPlanStatus("Terminated");
		c6.setTerminateDate(LocalDate.of(2023, 02, 01));
		c6.setTerminationReason("Fake Documentation");

		Customer c7 = new Customer();

		c7.setName("Ginnie");
		c7.setEmail("gini@harry.com");
		c7.setGender("Female");
		c7.setPlanName("Food");
		c7.setStartDate(LocalDate.of(2022, 11, 01));
		c7.setEndDate(LocalDate.of(2023, 07, 01));
		c7.setPlanStatus("Approved");
		c7.setBenifitAmount(500.00);

		Customer c8 = new Customer();

		c8.setName("Malena");
		c8.setEmail("malena123@outlook.edu");
		c8.setGender("Female");
		c8.setPlanName("Food");
		c8.setPlanStatus("Denied");
		c8.setDenialReason("Income Insuffient");

		Customer c9 = new Customer();

		c9.setName("Monica");
		c9.setEmail("monica@yahoo.com");
		c9.setGender("Female");
		c9.setPlanName("Food");
		c9.setStartDate(LocalDate.of(2022, 01, 01));
		c9.setEndDate(LocalDate.of(2023, 01, 01));
		c9.setPlanStatus("Terminated");
		c9.setTerminateDate(LocalDate.of(2022, 8, 30));
		c9.setTerminationReason("Verification failed");

		Customer c10 = new Customer();

		c10.setName("Akash");
		c10.setEmail("aks3455@gmail.com");
		c10.setGender("Male");
		c10.setPlanName("Food");
		c10.setStartDate(LocalDate.of(2023, 01, 01));
		c10.setEndDate(LocalDate.of(2023, 12, 01));
		c10.setPlanStatus("Approved");
		c10.setBenifitAmount(3500.00);

		Customer c11 = new Customer();

		c11.setName("Anand");
		c11.setEmail("andy3457@gmail.in");
		c11.setGender("Male");
		c11.setPlanName("Food");
		c11.setPlanStatus("Denied");
		c11.setDenialReason("Government Employee");

		Customer c12 = new Customer();

		c12.setName("Angat");
		c12.setEmail("angtjahu@rediff.com");
		c12.setGender("Male");
		c12.setPlanName("Food");
		c12.setStartDate(LocalDate.of(2023, 01, 01));
		c12.setEndDate(LocalDate.of(2023, 12, 31));
		c12.setPlanStatus("Terminated");
		c12.setTerminateDate(LocalDate.of(2023, 05, 31));
		c12.setTerminationReason("From Customer");

		Customer c13 = new Customer();

		c13.setName("Sussien");
		c13.setEmail("ssusn@mailgmail.com");
		c13.setGender("Female");
		c13.setPlanName("Medical");
		c13.setStartDate(LocalDate.of(2022, 01, 31));
		c13.setEndDate(LocalDate.of(2023, 12, 01));
		c13.setPlanStatus("Approved");
		c13.setBenifitAmount(4000.00);

		Customer c14 = new Customer();

		c14.setName("Luna");
		c14.setEmail("Lunacourseorg@gmail.edu");
		c14.setGender("Female");
		c14.setPlanName("Medical");
		c14.setPlanStatus("Denied");
		c14.setDenialReason("Employee");

		Customer c15 = new Customer();

		c15.setName("Halen");
		c15.setEmail("hlen@gmail.com");
		c15.setGender("Female");
		c15.setPlanName("Medical");
		c15.setStartDate(LocalDate.of(2022, 11, 01));
		c15.setEndDate(LocalDate.of(2023, 04, 01));
		c15.setPlanStatus("Terminated");
		c15.setTerminateDate(LocalDate.of(2023, 01, 01));
		c15.setTerminationReason("Employement Issue");

		Customer c16 = new Customer();

		c16.setName("Jaanrao");
		c16.setEmail("jaarao@gmail.com");
		c16.setGender("Male");
		c16.setPlanName("Medical");
		c16.setStartDate(LocalDate.of(2022, 05, 01));
		c16.setEndDate(LocalDate.of(2023, 04, 30));
		c16.setPlanStatus("Approved");
		c16.setBenifitAmount(2000.00);

		Customer c17 = new Customer();

		c17.setName("Mahesh");
		c17.setEmail("mahesh123@gmail.com");
		c17.setGender("Male");
		c17.setPlanName("Medical");
		c17.setPlanStatus("Denied");
		c17.setDenialReason("Government Servant");

		Customer c18 = new Customer();

		c18.setName("Rambo");
		c18.setEmail("rambo.cov@gmail.com");
		c18.setGender("Male");
		c18.setPlanName("Medical");
		c18.setStartDate(LocalDate.of(2023, 01, 01));
		c18.setEndDate(LocalDate.of(2024, 04, 01));
		c18.setPlanStatus("Terminated");
		c18.setTerminateDate(LocalDate.of(2023, 05, 01));
		c18.setTerminationReason("Criminal Activity");

		Customer c19 = new Customer();

		c19.setName("Bhavna");
		c19.setEmail("bhavnahedau@gmail.com");
		c19.setGender("Female");
		c19.setPlanName("Employement");
		c19.setStartDate(LocalDate.of(2022, 01, 01));
		c19.setEndDate(LocalDate.of(2023, 01, 01));
		c19.setPlanStatus("Approved");
		c19.setBenifitAmount(4500.00);

		Customer c20 = new Customer();

		c20.setName("Pranoti");
		c20.setEmail("psl@gmail.com");
		c20.setGender("Female");
		c20.setPlanName("Employement");
		c20.setPlanStatus("Denied");
		c20.setDenialReason("Employeed");

		Customer c21 = new Customer();

		c21.setName("Lincy");
		c21.setEmail("lincy@ever.com");
		c21.setGender("Female");
		c21.setPlanName("Employement");
		c21.setStartDate(LocalDate.of(2022, 11, 01));
		c21.setEndDate(LocalDate.of(2023, 04, 01));
		c21.setPlanStatus("Terminated");
		c21.setTerminateDate(LocalDate.of(2023, 01, 01));
		c21.setTerminationReason("Not enough Funds");

		Customer c22 = new Customer();

		c22.setName("Hancock");
		c22.setEmail("hancock123@gmail.com");
		c22.setGender("Male");
		c22.setPlanName("Employement");
		c22.setStartDate(LocalDate.of(2022, 11, 01));
		c22.setEndDate(LocalDate.of(2023, 04, 01));
		c22.setPlanStatus("Approved");
		c22.setBenifitAmount(1000.00);

		Customer c23 = new Customer();

		c23.setName("Mangoor");
		c23.setEmail("mngoor@gmail.com");
		c23.setGender("Male");
		c23.setPlanName("Employement");
		c23.setPlanStatus("Denial");
		c23.setDenialReason("Invalid Documents");

		Customer c24 = new Customer();

		c24.setName("Sloth");
		c24.setEmail("slothAdmin.gmail.@gmail.com");
		c24.setGender("Male");
		c24.setPlanName("Employement");
		c24.setStartDate(LocalDate.of(2022, 10, 01));
		c24.setEndDate(LocalDate.of(2023, 05, 01));
		c24.setPlanStatus("Terminated");
		c24.setTerminateDate(LocalDate.of(2023, 01, 01));
		c24.setTerminationReason("Failed Installments");

		Customer c25 = new Customer();

		c25.setName("Mowgli");
		c25.setEmail("curabitur.mogli@gmail.edu");
		c25.setGender("male");
		c25.setPlanName("Cash");
		c25.setStartDate(LocalDate.of(2022, 11, 01));
		c25.setEndDate(LocalDate.of(2023, 04, 01));
		c25.setPlanStatus("Approved");
		c25.setBenifitAmount(1500.00);

		Customer c26 = new Customer();

		c26.setName("Samba");
		c26.setEmail("samba.lectus@outlook.com");
		c26.setGender("Male");
		c26.setPlanName("Food");
		c26.setStartDate(LocalDate.of(2022, 11, 01));
		c26.setEndDate(LocalDate.of(2023, 04, 01));
		c26.setPlanStatus("Approved");
		c26.setBenifitAmount(2500.00);

		repo.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18,
				c19, c20, c21, c22, c23, c24, c25, c26));



	}

}
