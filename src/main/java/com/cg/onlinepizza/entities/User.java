package com.cg.onlinepizza.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Sprint1_onlinepizza_User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator  = "id")
    @SequenceGenerator(name = "id" ,initialValue = 10001)
	private int id;
	private String mobileNumber;
	private String password;
	private String role;
	
	public User(int id, String mobileNumber, String password, String role) {
		super();
		this.id=id;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.role = role;
	}
	
	
	public User(String mobileNumber, String password, String role) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.role = role;
	}


	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + id + ", mobileNumber=" + mobileNumber + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
	
	
	

}
