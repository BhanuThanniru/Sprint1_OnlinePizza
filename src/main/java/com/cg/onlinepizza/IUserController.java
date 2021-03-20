package com.cg.onlinepizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.entities.User;
import com.cg.onlinepizza.services.UserService;


@RestController
public class IUserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(User user)
	{
		userService.addUser(user);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	@GetMapping("/user")
	public ResponseEntity<?> getUser(){
		List<User> list1 = userService.getAllUsers();
		return new ResponseEntity<>(list1,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody User user)
	{
		userService.signIn(user);
		return new ResponseEntity<>("LoginSuccessful",HttpStatus.OK);
	}
	
	@PostMapping("/signout")
	public ResponseEntity<?> signOut(@RequestBody User user)
	{
		userService.signOut(user);
		return new ResponseEntity<>("You have been logged out successfully",HttpStatus.OK);
	}
	

}
