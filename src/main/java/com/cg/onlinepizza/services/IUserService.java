package com.cg.onlinepizza.services;

import java.util.List;
import com.cg.onlinepizza.entities.User;

public interface IUserService {
	
	public User addUser(User user);
	
	List<User> getAllUsers();

	public User findCustomer(User user);
	

}
