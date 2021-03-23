package com.cg.onlinepizza.services;

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

	List<Customer> getCustomers();

	Optional<Customer> getCustomer(int customerId) throws CustomerIdNotFoundException;
}
