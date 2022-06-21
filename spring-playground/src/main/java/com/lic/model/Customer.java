package com.lic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	
	private Long id;
	private String name;

	private String password;
	
	
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Customer(Long id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	//You want to pass something with a different name
	@JsonProperty("customer_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
