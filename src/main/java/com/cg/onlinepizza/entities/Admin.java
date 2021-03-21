package com.cg.onlinepizza.entities;
  import javax.persistence.Entity; 
  import javax.persistence.Id; 
  import javax.persistence.Table;
  import org.apache.tomcat.jni.User;
  import javax.validation.constraints.NotBlank;
  
  @Entity
  
  @Table(name="Sprint1_Admin")
  
  public class Admin extends User {
  
  @Id 
  private int userId;
  @NotBlank(message="Username cannot be blank")
  private String userName;
  @NotBlank(message="Password cannot be blank")
  private String password;
  
  public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
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

public Admin(int userId, String userName, String password) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.password = password;
}

@Override
public String toString() {
	return "Admin [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
}

public Admin() {
	super();
}

  }
  
  