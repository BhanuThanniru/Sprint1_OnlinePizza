package com.cg.onlinepizza.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.onlinepizza.entities.Order;
import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.exceptions.InvalidSizeException;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;

public class OrderRepositoryImpl implements IOrderRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
	EntityManager em = factory.createEntityManager();
	Order order;
	
	@Override
	public Order bookOrder(Order order) {
		// TODO Auto-generated method stub
		System.out.println("Booking Order");
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		em.close();
		System.out.println("Order booked successfully");
		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		System.out.println("Updating order....");
		return null;
	}

	@Override
	public Order cancelOrder(int orderId) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		System.out.println("Cancelling Order initiated");
		order = em.find(Order.class, orderId);
		em.remove(order);
		em.getTransaction().commit();
		em.close();
		System.out.println("order cancelled successfully");		
		return order;
		
	}

	@Override
	public Order viewOrder(int orderId) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		
		em.getTransaction().begin();
		System.out.println("listing all pizza's based on id.....");
		order= em.find(Order.class, orderId);
		//System.out.println(pizza.toString());
		em.close();
	
		return order;
		
	}

	@Override
	public List<Order> caluculateTotal(String size, int quantity,List<Pizza> pizza) throws InvalidSizeException {
		// TODO Auto-generated method stub
		List<Order> orderList = new ArrayList<Order>();
		int totalCost;
		int costOfPizzaForSize;
		Pizza pizza3;
		for(Pizza pizza1 : pizza)
		{
			pizza3 = em.find(Pizza.class, pizza1.getPizzaId());
			costOfPizzaForSize = pizza3.getMap1().get(size);
			totalCost = costOfPizzaForSize * quantity;
			order.setTotalCost(totalCost);
			orderList.add(order);
			System.out.println(orderList);
			
		}
			
		return orderList;
	}

}
