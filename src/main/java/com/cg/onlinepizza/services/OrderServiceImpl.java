package com.cg.onlinepizza.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.dao.IOrderRepository;
import com.cg.onlinepizza.dao.IPizzaRepository;
import com.cg.onlinepizza.entities.Order;
import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.entities.PizzaCost;
import com.cg.onlinepizza.entities.Size;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidSizeException;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderRepository orderRepo;
	
	@Autowired
	private IPizzaRepository pizzaRepo;

	@Override
	public Order bookOrder(Order order) {
		//System.out.println("Before Adding orders in service");
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
	public Order getOrder(int orderId) throws OrderIdNotFoundException  {
		
		Optional<Order> order = orderRepo.findById(orderId);
		return order.orElseThrow(() -> new OrderIdNotFoundException("Order Not Found"));
	}

	@Override
	public List<Order> getOrder() {
		
		return orderRepo.findAll();
	}
	/*
	 * @Override public Order calculateTotal(String size, Order order) throws
	 * InvalidSizeException {
	 * 
	 * 
	 * 
	 * return null; }
	 */
	/*
	 * @Override public Order patchTheOrder(Order order) { return
	 * orderRepo.save(order); }
	 */

	@Override
	public Order calculateTotal(String size, Order order) throws InvalidSizeException, CustomerIdNotFoundException, OrderIdNotFoundException {
		
		Map<Integer, Integer> keys = order.getCart();
		double totalCost =0, baseCost;
		
		for ( Map.Entry<Integer, Integer> entry : keys.entrySet()) {
		    Integer pizzaID = entry.getKey();
		    Integer quantity = entry.getValue();
		    baseCost =0;
		    //System.out.println("pizzaId: " + pizzaID + " quantity :"+ quantity);
		    Pizza pizza  = pizzaRepo.findById(pizzaID).get();
			//System.out.println("pizza:"+pizza);
			List<PizzaCost> pizzaCost = pizza.getCostList();
			//System.out.println(pizzaCost);
			for(PizzaCost l : pizzaCost)
			{
				//for(Size size1 : enumSize) {
//					l.getPizzaSize()
				/*
				 * Size size1 = Size.valueOf(size.toUpperCase()); System.out.println(size1);
				 */				
				if(l.getPizzaSize().name().equalsIgnoreCase(size.toUpperCase()))
				{
					baseCost +=l.getCost()*quantity;
				//	System.out.println("BASECOST : "+baseCost);
				}
				//}
				else throw new InvalidSizeException("Invalid Size");
				}
			totalCost +=baseCost;
			//System.out.println("totalcost : "+totalCost);
		}
		order.setTotalCost(totalCost);
		
		//System.out.println(order.getTotalCost());
		return order;
		    
		}
}
