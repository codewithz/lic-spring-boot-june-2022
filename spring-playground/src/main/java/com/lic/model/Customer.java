package com.lic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	
	private Long id;

	private String name;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private String email;
	

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

	public Customer(Long id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
