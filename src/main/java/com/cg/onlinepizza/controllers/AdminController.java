package com.cg.onlinepizza.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlinepizza.entities.Coupan;
import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.entities.Order;
import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.entities.User;
import com.cg.onlinepizza.exceptions.CoupanIdNotFoundException;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.services.ICoupanService;
import com.cg.onlinepizza.services.ICustomerService;
import com.cg.onlinepizza.services.IOrderService;
import com.cg.onlinepizza.services.IPizzaService;
import com.cg.onlinepizza.services.IUserService;

@RestController
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

	@PostMapping("/signIn")
	public ResponseEntity<?> signIn(@RequestBody User user)
	{
		userService.signIn(user);
		return new ResponseEntity<>("Sign in successful", HttpStatus.OK);
	}

	@PostMapping("/signOut")
	public ResponseEntity<?> signOut(@RequestBody User user)
	{
		userService.signOut(user);
		return new ResponseEntity<>("Signed Out Successfully", HttpStatus.OK);
	}

	@GetMapping("/customers") 
	public ResponseEntity<List<Customer>> getCustomers() 
	{ 
		List<Customer> customers = customerService.viewCustomers();
		return new ResponseEntity<>(customers,HttpStatus.OK); 

	}

	@GetMapping("/customers/{id}") 
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) throws CustomerIdNotFoundException
	{

		return new ResponseEntity<>(customerService.viewCustomer(id), HttpStatus.OK);
	}

	@PostMapping("/pizzas")
	public ResponseEntity<Pizza> addPizza(@Valid @RequestBody Pizza pizza) {
		pizzaService.addPizza(pizza);
		return new ResponseEntity<Pizza>(pizza, HttpStatus.CREATED);
	}


	@GetMapping("/pizzas")
	public ResponseEntity<List<Pizza>> getAllPizza() 
	{
		List<Pizza> pizza = pizzaService.getPizzaList(); 
		return new ResponseEntity<>(pizza, HttpStatus.OK); 
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pizza> getPizzaListById(@PathVariable int id) throws PizzaIdNotFoundException {
		Pizza pizza = pizzaService.getPizzaById(id);
		return new ResponseEntity<Pizza>(pizza, HttpStatus.OK);
	}


	@GetMapping("/orders")
	public ResponseEntity<List<Order>> viewOrder() throws OrderIdNotFoundException {

		List<Order> order = orderService.getOrders();
		return new ResponseEntity<List<Order>>(order, HttpStatus.OK); 
	}

	@GetMapping("/orders/{id}") 
	public ResponseEntity<Order> getOrder(@PathVariable int id) throws OrderIdNotFoundException {

		return new ResponseEntity<>(orderService.getOrders(id), HttpStatus.OK); 
	}


	@GetMapping("/coupans")
	public ResponseEntity<List<Coupan>> listCoupans()
	{
		List<Coupan> listAllCoupan = coupanService.listAllCoupans();
		return new ResponseEntity<List<Coupan>>(listAllCoupan,HttpStatus.OK);
	}

	@GetMapping("/coupans/{id}")
	public ResponseEntity<Coupan> listCoupanById(@PathVariable int id) throws CoupanIdNotFoundException 
	{
		Coupan c1=coupanService.listCoupanById(id);
		return new ResponseEntity<Coupan>(c1,HttpStatus.OK);
	}


	@DeleteMapping("/coupans/{id}") 
	public ResponseEntity<Coupan> deleteCoupans(@PathVariable int id) throws CoupanIdNotFoundException
	{
		coupanService.deleteCoupanById(id);
		return new ResponseEntity<Coupan>(HttpStatus.OK);
		//return new ResponseEntity<Optional<Coupan>>(c1,HttpStatus.OK);
	}

	@PutMapping("/coupans/{id}") 
	public ResponseEntity<Coupan> editCoupans(@Valid @RequestBody Coupan coupan, @PathVariable int id) throws CoupanIdNotFoundException
	{
		coupanService.editCoupans(id,coupan);
		return new ResponseEntity<Coupan>(coupan,HttpStatus.OK);
	}


}
