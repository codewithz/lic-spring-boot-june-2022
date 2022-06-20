package com.lic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lic.model.Customer;
import com.lic.services.CustomerService;



@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	
	public CustomerController(CustomerService customerService) {
		// TODO Auto-generated constructor stub
	}

	@GetMapping
	public Customer getCustomer() {
		Customer c=customerService.getCustomer();
		return c;
	}
	
}
