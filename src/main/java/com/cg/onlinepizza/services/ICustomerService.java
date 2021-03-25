package com.cg.onlinepizza.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;

@Service
public interface ICustomerService {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(int customerId, Customer customer)throws CustomerIdNotFoundException;

	Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException;

	List<Customer> viewCustomers();

	Customer viewCustomer(int customerId) throws CustomerIdNotFoundException;

	Customer custSignIn(Customer cust);

}
