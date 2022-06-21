package com.lic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lic.model.Customer;
import com.lic.services.CustomerService;

import javax.validation.Valid;


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

	@PostMapping
	public String addCustomer(@Valid  @RequestBody Customer customer){
		System.out.println(customer);
		return "OK";
	}
	
	
}
