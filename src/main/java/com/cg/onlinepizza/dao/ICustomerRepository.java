package com.cg.onlinepizza.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinepizza.entities.Customer;



@Repository

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	/*
	 * Customer addCustomer(Customer customer);
	 * 
	 * Customer updateCustomer(Customer customer);
	 * 
	 * Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException;
	 * 
	 * List<Customer> viewCustomers();
	 * 
	 * Customer viewCustomer(int customerId) throws CustomerIdNotFoundException;
	 */

}
