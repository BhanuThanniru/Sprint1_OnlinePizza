package com.cg.onlinepizza;

import java.util.List;
import java.util.Optional;

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

import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.service.ICustomerService;

@RestController
@RequestMapping("/rest")
public class ICustomerController {
	
	@Autowired
	private ICustomerService customerservice;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> allCustomer()
	{
		List<Customer> listAllCustomer=customerservice.viewCustomers();
		
		return new ResponseEntity<List<Customer>>(listAllCustomer,HttpStatus.CREATED);
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		customerservice.addCustomer(customer);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable int id) throws CustomerIdNotFoundException
	{
		Optional<Customer> c1=customerservice.viewCustomer(id);
		if(c1.isPresent()==false)
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
		customerservice.updateCustomer(customer);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) throws CustomerIdNotFoundException
	{
		Optional<Customer> c1=customerservice.viewCustomer(id);
		if(c1.isPresent()==false)
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
		customerservice.deleteCustomer(id);
		
	return new ResponseEntity<Customer>(HttpStatus.OK);
	}
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Optional<Customer>> viewCustomer(@PathVariable int id) throws CustomerIdNotFoundException
	{
		Optional<Customer> c1=customerservice.viewCustomer(id);
		if(c1.isPresent()==false)
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			customerservice.viewCustomer(id);
			return new ResponseEntity<Optional<Customer>>(c1,HttpStatus.OK);
		}
	}

}
