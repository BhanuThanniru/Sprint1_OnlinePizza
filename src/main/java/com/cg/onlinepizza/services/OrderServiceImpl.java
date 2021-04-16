package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinepizza.dao.ICoupanRepository;
import com.cg.onlinepizza.dao.IOrderRepository;
import com.cg.onlinepizza.dao.IPizzaRepository;
import com.cg.onlinepizza.entities.Cart;
import com.cg.onlinepizza.entities.Coupan;
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
	
	@Autowired
	private ICoupanRepository coupanRepo;
	

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
		order.orElseThrow(() -> new OrderIdNotFoundException("Order Id Not Found"));
		orderRepo.deleteById(orderId);
		return order.get();
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
	public Order calculateTotal(Order order) throws InvalidSizeException, CustomerIdNotFoundException {
		
		List<Cart> cart = order.getCart();
		double totalCost = 0;
		
		for(Cart c : cart) {
			double baseCost = 0;
			int pizzaId = c.getPizzaId();
			Pizza pizza  = pizzaRepo.findById(pizzaId).get();
			List<PizzaCost> pizzaCost = pizza.getCostList();
			for(PizzaCost l : pizzaCost)
			{	
				if(l.getPizzaSize().equals(c.getPizzaSize()))
					baseCost +=l.getCost()*(c.getQuantity());
			}
			totalCost +=baseCost;
		}

		
		if(order.getCoupan()== null) { 
			order.setTotalCost(totalCost);
		}
		else {
			Coupan coupan = coupanRepo.findById(order.getCoupan().getId()).get();
		totalCost -= coupan.getPriceDiscount();
		order.setTotalCost(totalCost);
		}
		return order;
	}
	}