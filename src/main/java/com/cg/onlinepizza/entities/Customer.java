package com.cg.onlinepizza.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sprint1_onlinepizza_customer")
public class Customer extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator  = "id")
    @SequenceGenerator(name = "id" ,initialValue = 10001)
	private int id;
	private String name;
	private String email;
	private String address;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	 List<Order> orders;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Customer(int id, String name, String email, String address,  List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.orders = orders;
	}
	public Customer() {
		super();
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
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", orders=" + orders + "]";
	}

	
	
	
	
	
	
	}