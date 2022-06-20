package com.lic.services;

import org.springframework.stereotype.Service;

import com.lic.model.Customer;

@Service
public class CustomerService {

	public Customer getCustomer() {
		Customer c=new Customer(1L,"James Service Bond");
		return c;
	}
	
}
