package com.cg.onlinepizza;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.entities.User;
import com.cg.onlinepizza.services.IUserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping
	public ResponseEntity<User> addUser(User user)
	{
		userService.addUser(user);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<?> getUser(){
		List<User> list1 = userService.getAllUsers();
		return new ResponseEntity<>(list1,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@Valid @RequestBody User user)
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
