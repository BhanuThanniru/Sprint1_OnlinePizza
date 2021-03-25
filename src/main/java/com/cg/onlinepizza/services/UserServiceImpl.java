package com.cg.onlinepizza.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinepizza.dao.IUserRepository;
import com.cg.onlinepizza.entities.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepo;

	@Override
	public User addUser(User user) {

		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() 
	{
		List<User> UserList = (List<User>) userRepo.findAll();
		return UserList;
	}

	@Override
	public User signIn(User user) {

		List<User> userList = getAllUsers();
		for (User systemUser : userList) 
		{
			if ( (systemUser.getMobileNumber().equals(user.getMobileNumber())) && (systemUser.getPassword().equals(user.getPassword()))) 
			{
				System.out.println("Successfully signed in...");
			}
			return user;
		}
		return null;
	}

	@Override
	public User signOut(User user) {
		List<User> userList = getAllUsers();
		for (User systemUser : userList) 
		{
			if(systemUser.getMobileNumber().equals(user.getMobileNumber()))
			{
				System.out.println("Successfully signed out...");
				return user;
			}

			else
				return null;	
		}
		return null;
	}
}
