package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.dao.IUserRepository;
import com.cg.onlinepizza.entities.User;

@Service
public class UserServiceImpl implements UserService {

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
		if (user == null)
            return null;
        
        List<User> userList = getAllUsers();
        for (User systemUser : userList) 
        {
            if ( (systemUser.getMobileNumber().equals(user.getMobileNumber())) && (systemUser.getPassword().equals(user.getPassword())) ) 
            {
                System.out.println("Successfully signed in...");
                return user;
            }
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

	@Override
	public User changePassword(int id, User user) {
		Optional<User> userOptional = userRepo.findById(user.getMobileNumber());
        if (userOptional.isEmpty())
            return null;
        
        return userRepo.save(user);
	}

	@Override
	    public User getUserByMobile(String mobileNumber) 
	    {
	        Optional<User> userOptional = userRepo.findById(mobileNumber);
	        return userOptional.isEmpty() ? null : userOptional.get();
	    }

	
	

}
