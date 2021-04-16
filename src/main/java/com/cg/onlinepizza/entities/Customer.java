package com.cg.onlinepizza.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer extends User {

	private String name;
	private String mobileNumber;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	
	
	public Customer() {
		super();
	}
	
	
	public Customer(int id, String mobileNumber, String password) {
		super(id, mobileNumber, password);
		
	}
	public Customer(String email, String password) {
		super(email, password);
		
	}
	public Customer(String name, String email, String address,  List<Order> orders) {
		super();
		this.name = name;
		this.mobileNumber = email;
		this.address = address;
		this.orders = orders;
	}	
	@Override
	public String toString() {
		return "Customer  name=" + name + ", email=" + mobileNumber + ", address=" + address + ", orders=" + orders + "]";
	}
}