package com.cg.onlinepizza.services;

import java.util.List;

import com.cg.onlinepizza.entities.User;

public interface UserService {
	
	public User addUser(User user);
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(int id, User user);
	List<User> getAllUsers();
	User getUserByMobile(String mobileNumber); 

}
