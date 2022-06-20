package com.lic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lic.model.Customer;

@Service
public class CustomerService {

	public Customer getCustomerById(Long id) {
		Customer c=new Customer(id,"James Service Bond");
		return c;
	}
	
	public List<Customer> getCustomers(){
		List<Customer> list=new ArrayList<Customer>();
		
				list.add(new Customer(1L,"James Bond"));
				list.add(new Customer(2L,"Sheldon Cooper"));
				list.add(new Customer(3L,"Elon Musk"));
				
		
		return list;
	
	}
	
}
