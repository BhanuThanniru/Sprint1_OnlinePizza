package com.cg.onlinepizza.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer extends User {

	private String name;
	private String email;
	private String address;

	@OneToMany(cascade=CascadeType.ALL,mappedBy = "customer")
	@JsonManagedReference
	private List<Order> orders;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public Customer(int id, String mobileNumber, String password, String role, String address) {
		super(id, mobileNumber, password, role);
		this.address = address;
	}
	public Customer(String mobileNumber, String password, String role) {
		super(mobileNumber, password, role);
	}
	public Customer() {
		super();
	}
	public Customer(int id, String mobileNumber, String password, String role, String name, String email) {
		super(id, mobileNumber, password, role);
		this.name = name;
		this.email = email;
	}
	
	public Customer(String mobileNumber, String password, String role,String name) {
		super(mobileNumber, password, role);
		this.name=name;
	}
	public Customer(int id, String mobileNumber, String password, String role, String name, String email, String address) {
		super(id, mobileNumber, password, role);
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public Customer(String name, String email, String address,  List<Order> orders) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.orders = orders;
	}	
	@Override
	public String toString() {
		return "Customer  name=" + name + ", email=" + email + ", address=" + address + ", orders=" + orders + "]";
	}
}