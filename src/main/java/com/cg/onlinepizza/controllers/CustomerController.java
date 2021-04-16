package com.cg.onlinepizza.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cg.onlinepizza.services.ICustomerService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private ICustomerService customerService;
    
    
    @GetMapping
    public ResponseEntity<List<Customer>> allCustomer()
    {
        List<Customer> listAllCustomer=customerService.viewCustomers();        
        return new ResponseEntity<List<Customer>>(listAllCustomer,HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
    {
        customerService.addCustomer(customer);        
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable int id) throws CustomerIdNotFoundException
    {
        customerService.updateCustomer(id,customer);
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) throws CustomerIdNotFoundException
    {
        customerService.deleteCustomer(id);
        
    return new ResponseEntity<>(id,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> viewCustomer(@PathVariable int id) throws CustomerIdNotFoundException
    {
        Customer c1=customerService.viewCustomer(id);
        
            return new ResponseEntity<>(c1,HttpStatus.OK);
    }
   
}