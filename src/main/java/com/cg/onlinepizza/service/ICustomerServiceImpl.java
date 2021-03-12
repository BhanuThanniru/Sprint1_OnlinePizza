package com.cg.onlinepizza.service;

import java.util.List;

import com.cg.onlinepizza.dao.ICustomerRepository;
import com.cg.onlinepizza.dao.ICustomerRepositoryImpl;
import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;

public class ICustomerServiceImpl implements ICustomerService {
	ICustomerRepository repo=new ICustomerRepositoryImpl();

	@Override
	public Customer addCustomer(Customer customer) {
		
		return repo.addCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return repo.updateCustomer(customer);
	}

	@Override
	public Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException {
		return repo.deleteCustomer(customerId);
	}

	@Override
	public List<Customer> viewCustomers() {
		return repo.viewCustomers();
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerIdNotFoundException {
		return repo.viewCustomer(customerId);
	}

}