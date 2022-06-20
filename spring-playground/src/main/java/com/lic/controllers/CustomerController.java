package com.lic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lic.model.Customer;
import com.lic.services.CustomerService;



@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	public CustomerController(CustomerService customerService) {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable Long customerId) {
		Customer c=customerService.getCustomerById(customerId);
		return c;
	}
	
	@GetMapping
	public List<Customer> getCustomers(){
		List<Customer> list=customerService.getCustomers();
		return list;
	}
	
	
}
