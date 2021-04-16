package com.cg.onlinepizza.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="Users")

public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator  = "id")
    @SequenceGenerator(name = "id" ,initialValue = 10001)
	protected int id;
	
	@NotNull(message="Mobile Number should not be blank")
	@NotBlank(message="Mobile Number should not be blank")
	protected String email;
	
	@NotNull(message="Password can't be blank")
	protected String password;
	
	
	public User(int id, String email, String password) {
		super();
		this.id=id;
		this.email = email;
		this.password = password;
		
	}
	
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	

	public User(@NotNull(message = "Mobile Number should not be blank") String mobileNumber) {
		super();
		this.email = mobileNumber;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + id + ", mobileNumber=" + email + ", password=" + password 
				+ "]";
	}	
}
