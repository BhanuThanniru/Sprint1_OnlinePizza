package com.cg.onlinepizza.service;

import java.util.List;

import com.cg.onlinepizza.dao.IOrderRepository;
import com.cg.onlinepizza.dao.OrderRepositoryImpl;
import com.cg.onlinepizza.entities.Order;
import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.exceptions.InvalidSizeException;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;

public class OrderServiceImpl implements IOrderService {
	
	IOrderRepository orderRepo = new OrderRepositoryImpl();

	@Override
	public Order bookOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepo.bookOrder(order);
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepo.updateOrder(order);
	}

	@Override
	public Order cancelOrder(int orderId) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		return orderRepo.cancelOrder(orderId);
	}

	@Override
	public Order viewOrder(int orderId) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		return orderRepo.viewOrder(orderId);
	}

	@Override
	public List<Order> caluculateTotal(String size, int quantity, List<Pizza> pizza) throws InvalidSizeException {
		// TODO Auto-generated method stub
		return orderRepo.caluculateTotal(size, quantity,pizza);
	}

}
