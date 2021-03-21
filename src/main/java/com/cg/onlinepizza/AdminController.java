package com.cg.onlinepizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.onlinepizza.entities.Admin;
import com.cg.onlinepizza.services.ICoupanService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
@Autowired 
IUserService userService;	
@Autowired 
IPizzaService pizzaService;	
@Autowired 
IOrderService orderService;	
@Autowired 
ICustomerService customerService;
@Autowired 
ICoupanService coupanService;

@PostMapping("/login")
public ResponseEntity<User> login(@RequestBody User user)
{
	userService.login(user);
	return new ResponseEntity<User>(user, HttpStatus.OK);
}

@PostMapping("/logout")
public ResponseEntity<User> logout(@RequestBody User user)
{
	userService.logout(user);
	return new ResponseEntity<User>(user, HttpStatus.OK);
}

@PostMapping("/register")
public ResponseEntity<Admin> addUser(@RequestBody Admin admin)
{
	userService.addUser(admin);
	return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
}


@GetMapping("/customers")
public ResponseEntity<List<Customer>> getCustomers()
{
	List<Customer> customers = customerService.getAllCustomers();
	return new ResponseEntity<>(customers, HttpStatus.OK);
}


@GetMapping("/customers/{id}")
public ResponseEntity<Customer> getCustomer(@PathVariable id)
{
	
	return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
}

@GetMapping("/pizza")
public ResponseEntity<List<Pizza>> getPizza()
{
	List<Pizza> customers = pizzaService.getAllPizza();
	return new ResponseEntity<>(pizza, HttpStatus.OK);
}

@GetMapping("/pizza/{id}")
public ResponseEntity<Pizza> getPizza(@PathVariable id)
{
	
	return new ResponseEntity<>(pizzaService.getPizza(id), HttpStatus.OK);
}

@GetMapping("/order")
public ResponseEntity<List<Order>> getOrder()
{
	List<Pizza> customers = pizzaService.getAllPizza();
	return new ResponseEntity<>(pizzas, HttpStatus.OK);
}
	 
}
