package com.cg.onlinepizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.dao.ICustomerRepository;
import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;

@Service
public class ICustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepository repo;

	@Override
	public Customer addCustomer(Customer customer) {
		
		return repo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException {
		 repo.deleteById(customerId);
		 Customer c1=new Customer();
		 return c1;
	}

	@Override
	public List<Customer> viewCustomers() {
		return repo.findAll();
	}

	@Override
	public Optional<Customer> viewCustomer(int customerId) throws CustomerIdNotFoundException {
		return repo.findById(customerId);
	}

}