package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.dao.IOrderRepository;
import com.cg.onlinepizza.dao.IPizzaRepository;
import com.cg.onlinepizza.entities.Order;
import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.entities.PizzaCost;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidSizeException;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderRepo;

	@Autowired
	private IPizzaRepository pizzaRepo;

	@Override
	public Order bookOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Order updateOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Order cancelOrder(int orderId) throws OrderIdNotFoundException{

		Optional<Order> order = orderRepo.findById(orderId);
		orderRepo.deleteById(orderId);
		return order.orElseThrow(() -> new OrderIdNotFoundException("Order Not Found"));
	}

	@Override
	public Order getOrders(int orderId) throws OrderIdNotFoundException  {

		Optional<Order> order = orderRepo.findById(orderId);
		return order.orElseThrow(() -> new OrderIdNotFoundException("Order Not Found"));
	}

	@Override
	public List<Order> getOrders() {

		return orderRepo.findAll();
	}
	@Override
	public Order calculateTotal(String size, Order order) throws InvalidSizeException, CustomerIdNotFoundException, OrderIdNotFoundException {

		Map<Integer, Integer> keys = order.getCart();
		double totalCost =0, baseCost;
		System.out.println(keys);
		for ( Map.Entry<Integer, Integer> entry : keys.entrySet()) {
			Integer pizzaID = entry.getKey();
			Integer quantity = entry.getValue();
			baseCost =0;

			Pizza pizza  = pizzaRepo.findById(pizzaID).get();
			List<PizzaCost> pizzaCost = pizza.getCostList();

			for(PizzaCost l : pizzaCost)
			{
				if(l.getPizzaSize().name().equalsIgnoreCase(size.toUpperCase()))
				{
					baseCost +=l.getCost()*quantity;
				}
			}
			totalCost +=baseCost;
		}
		order.setTotalCost(totalCost);
		return order;

	}
}