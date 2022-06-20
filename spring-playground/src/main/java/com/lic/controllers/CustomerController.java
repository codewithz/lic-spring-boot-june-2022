package com.lic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lic.model.Customer;



@RestController
public class CustomerController {

	@GetMapping
	public Customer getCustomer() {
		return new Customer(1L,"James Bond");
	}
	
}
