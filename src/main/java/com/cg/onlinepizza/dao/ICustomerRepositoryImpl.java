package com.cg.onlinepizza.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;

public class ICustomerRepositoryImpl implements ICustomerRepository {
	EntityManagerFactory factory =  Persistence.createEntityManagerFactory("test1");
	EntityManager em  =  factory.createEntityManager();

	@Override
	public Customer addCustomer(Customer customer) {
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		em.getTransaction().begin();
		em.find(Customer.class, customer.getCustomerId());
		em.merge(customer);
		em.getTransaction().commit();
		return customer;
		
		
		
		
	}

	@Override
	public Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException {
		Customer customer=em.find(Customer.class,customerId);
		em.getTransaction().begin();
		em.remove(customer);
		em.getTransaction().commit();
		Customer customer1=em.find(Customer.class,customerId);
		
		return customer1;
		
	}

	@Override
	public List<Customer> viewCustomers() {
		Query query = em.createQuery("select c from Customer c");
	    List<Customer> resultList2 = query.getResultList();
	    
	    return resultList2;
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerIdNotFoundException {
		em.getTransaction().begin();
		Customer c1=em.find(Customer.class, customerId);
		em.getTransaction().commit();
		
		return c1;
		
	}

}