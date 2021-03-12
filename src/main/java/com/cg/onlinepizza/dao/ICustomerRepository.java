package com.cg.onlinepizza.dao;

import java.util.List;

import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;

public interface ICustomerRepository {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException;

	List<Customer> viewCustomers();

	Customer viewCustomer(int customerId) throws CustomerIdNotFoundException;

}
