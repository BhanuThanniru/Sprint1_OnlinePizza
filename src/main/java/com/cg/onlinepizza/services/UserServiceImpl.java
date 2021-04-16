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
	public List<User> getAllUsers() 
	{
		List<User> UserList = (List<User>) userRepo.findAll();
		return UserList;
	}

	
	
	@Override
	public User addUser(User user) {
 
       return userRepo.save(user);
    }
	
	@Override
	public User findCustomer(User user) {
		User dbUser =  userRepo.findByEmail(user.getEmail());
    	System.out.println("db user " +dbUser);
    	if(dbUser==null)
    		throw new RuntimeException("user does nt exist");
    	if(!dbUser.getPassword().contentEquals(user.getPassword())) {
    		throw new RuntimeException("password mismatch");}
    	System.out.println("returning dbuser");
    	return dbUser;
	}

	

	
}
