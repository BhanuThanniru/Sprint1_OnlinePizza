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

@Entity
@Table(name="Sprint1_onlinepizza_User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator  = "id")
    @SequenceGenerator(name = "id" ,initialValue = 10001)
	protected int id;
	
	@NotNull(message="Mobile Number should not be blank")
	@NotBlank(message="Mobile Number should not be blank")
	@Column(unique=true,name="mobileNumber")
	protected String mobileNumber;
	
	@NotNull(message="Password can't be blank")
	protected String password;
	
	@NotNull(message="Role should either be customer or admin")
	protected String role;
	
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
	
	


	public User(@NotNull(message = "Mobile Number should not be blank") String mobileNumber,
			@NotNull(message = "Role should either be customer or admin") String role) {
		super();
		this.mobileNumber = mobileNumber;
		this.role = role;
	}


	public User(@NotNull(message = "Mobile Number should not be blank") String mobileNumber) {
		super();
		this.mobileNumber = mobileNumber;
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
