package com.cg.onlinepizza.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.entities.Order;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
	
	 @Query("select p from Order p where p.customer.id= :customerId")
	  List<Order> getAllOrders(@Param("customerId") int customerId);

}
