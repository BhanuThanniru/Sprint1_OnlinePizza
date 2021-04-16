package com.cg.onlinepizza.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.dao.ICustomerRepository;
import com.cg.onlinepizza.dao.IUserRepository;
import com.cg.onlinepizza.entities.Customer;
@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserService service;
	
	@Autowired
	private ICustomerService custService;
	@Autowired
	private ICustomerRepository repo;
	
	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		com.cg.onlinepizza.entities.User user =   userRepo.findByEmail(username);
		System.out.println(userRepo.findByEmail("admin1"));
		//System.out.println(userRepo.findByEmail(username));
		//System.out.println(user);
		//System.out.println(username);
	      
		com.cg.onlinepizza.entities.User validuser= service.findCustomer(user);
	      if(validuser==null)
	    	  throw new UsernameNotFoundException("user not found"+username);
	      
	      return  new org.springframework.security.core.userdetails.User(validuser.getEmail(), validuser.getPassword(), new ArrayList<>());
	      
	
	}

	public Customer save(Customer user) {
		user.setEmail(user.getEmail());
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return custService.addCustomer(user);
	}
	
	

}
