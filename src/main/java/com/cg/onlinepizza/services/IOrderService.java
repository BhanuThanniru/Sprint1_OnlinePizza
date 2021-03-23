package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;

import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.entities.Order;
import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidSizeException;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;

public interface IOrderService {
	Order bookOrder(Order order);

	Order updateOrder(Order order);

	Order cancelOrder(int id) throws OrderIdNotFoundException;

	Order getOrders(int id) throws OrderIdNotFoundException;
	
	List<Order> getOrders();

	Order calculateTotal(String size,  Order order) throws InvalidSizeException, CustomerIdNotFoundException, OrderIdNotFoundException;
	//Order calculateTotal(String size, Order order) throws InvalidSizeException;

	//Order patchTheOrder(Order order);
}


