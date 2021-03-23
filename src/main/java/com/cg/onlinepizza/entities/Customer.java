package com.cg.onlinepizza.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="PizzaCustomer")


public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator  = "id_customer")
	@SequenceGenerator(name = "id_customer", sequenceName="ID_SEQUENCE_FOR_CUSTOMER" ,initialValue = 1)
	private int id;
	private String name;
	private Long mobile;
	private String customerEmail;
	private String customerAddress;
	private String userName;//mobile no.
	private String password;

	@OneToMany(cascade = CascadeType.ALL , mappedBy = "customer")
	private List<Order> orders;
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", Name=" + name + ", customerMobile="
				+ mobile + ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress
				+ ", userName=" + userName + ", password=" + password + "]";
	}

	public Customer() {
		super();
	}

	public Customer(String name, Long mobile, String customerEmail, String userName, String password) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.customerEmail = customerEmail;
		this.userName = userName;
		this.password = password;
	}

	public Customer(String name, Long mobile, String customerEmail, String customerAddress, String userName,
			String password, List<Order> orders) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.userName = userName;
		this.password = password;
		this.orders = orders;
	}

	public Customer(int id, String name, Long mobile, String customerEmail,
			String customerAddress, String userName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.userName = userName;
		this.password = password;
	}

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

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}