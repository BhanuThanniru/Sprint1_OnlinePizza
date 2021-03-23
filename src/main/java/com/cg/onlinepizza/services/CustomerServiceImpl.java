package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
import javax.transaction.Transactional;

=======
>>>>>>> Pizza
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.dao.ICustomerRepository;
import com.cg.onlinepizza.entities.Customer;
<<<<<<< HEAD
import com.cg.onlinepizza.entities.Order;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;

@Service
@Transactional
=======
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.services.ICustomerService;

@Service
>>>>>>> Pizza
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepository repo;
<<<<<<< HEAD
	
	
=======
>>>>>>> Pizza

	@Override
	public Customer addCustomer(Customer customer) {
		
		return repo.save(customer);
	}

	@Override
<<<<<<< HEAD
	public Customer updateCustomer(int customerId,Customer customer)throws CustomerIdNotFoundException {
		Optional<Customer> c1=repo.findById(customerId);
		c1.orElseThrow(() -> new CustomerIdNotFoundException("Customer Not Found"));
		repo.save(customer);
		return customer;
=======
	public Customer updateCustomer(Customer customer) {
		return repo.save(customer);
>>>>>>> Pizza
	}

	@Override
	public Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException {
<<<<<<< HEAD
		Optional<Customer> c1=repo.findById(customerId); 
		c1.orElseThrow(() -> new CustomerIdNotFoundException("Customer Id Not Found"));
		repo.deleteById(customerId);
		return c1.get();
		
		}

	@Override
	public List<Customer> viewCustomers() {
=======
		 repo.deleteById(customerId);
		 Customer c1=new Customer();
		 return c1;
	}

	@Override
	public List<Customer> getCustomers() {
>>>>>>> Pizza
		return repo.findAll();
	}

	@Override
<<<<<<< HEAD
	public Customer viewCustomer(int customerId) throws CustomerIdNotFoundException {
		Optional<Customer> c1=repo.findById(customerId); 
		return c1.orElseThrow(() -> new CustomerIdNotFoundException("Customer Not Found"));
	}
	
	
	
=======
	public Optional<Customer> getCustomer(int customerId) throws CustomerIdNotFoundException {
		return repo.findById(customerId);
	}
>>>>>>> Pizza

}