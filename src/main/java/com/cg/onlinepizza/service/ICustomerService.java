package com.cg.onlinepizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;

@Service
public interface ICustomerService {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException;

	List<Customer> viewCustomers();

	Optional<Customer> viewCustomer(int customerId) throws CustomerIdNotFoundException;
}
