package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.dao.ICustomerRepository;
import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.entities.Order;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepository repo;
	
	

	@Override
	public Customer addCustomer(Customer customer) {
		
		return repo.save(customer);
	}

	@Override
	public Customer updateCustomer(int customerId,Customer customer)throws CustomerIdNotFoundException {
		Optional<Customer> c1=repo.findById(customerId);
		c1.orElseThrow(() -> new CustomerIdNotFoundException("Customer Not Found"));
		repo.save(customer);
		return customer;
	}

	@Override
	public Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException {
		Optional<Customer> c1=repo.findById(customerId); 
		c1.orElseThrow(() -> new CustomerIdNotFoundException("Customer Id Not Found"));
		repo.deleteById(customerId);
		return c1.get();
		
		}

	@Override
	public List<Customer> viewCustomers() {
		return repo.findAll();
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerIdNotFoundException {
		Optional<Customer> c1=repo.findById(customerId); 
		return c1.orElseThrow(() -> new CustomerIdNotFoundException("Customer Not Found"));
	}
	
	
	

}