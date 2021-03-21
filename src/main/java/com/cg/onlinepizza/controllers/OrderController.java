package com.cg.onlinepizza.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.entities.Order;
import com.cg.onlinepizza.exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.exceptions.InvalidSizeException;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.services.ICoupanService;
import com.cg.onlinepizza.services.ICustomerService;
import com.cg.onlinepizza.services.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private ICustomerService custService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> viewOrderListById(@PathVariable int id) throws OrderIdNotFoundException {

		Order order = orderService.getOrder(id);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Order>> viewOrder() throws OrderIdNotFoundException {

		List<Order> order = orderService.getOrder();
		return new ResponseEntity<List<Order>>(order, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Order> bookOrder( @Valid @RequestBody Order order) {
		//System.out.println("Booking pizza's:");
	
		orderService.bookOrder(order);
		
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}
	
	/*
	 * @PutMapping("/orders") public ResponseEntity<Order> updateOrder(@RequestBody
	 * Order order){ orderService.updateOrder(order); return new
	 * ResponseEntity<Order>(order, HttpStatus.ACCEPTED); }
	 */

	@PatchMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Customer customer) throws OrderIdNotFoundException, CustomerIdNotFoundException{
		Order order2 = orderService.getOrder(id);
		
		int custId = customer.getId();
		
		Customer cust = custService.getCustomer(custId).get();
		
		order2.setCustomer(cust);
		
		Order updatedOrder = orderService.updateOrder(order2);
		
		
		return new ResponseEntity<Order>(updatedOrder, HttpStatus.ACCEPTED);
	}

	/*
	 * @PatchMapping("/orders/{id}/{custId}") public ResponseEntity<Order>
	 * updateOrder(@PathVariable int id,@PathVariable int custId,@RequestBody Coupan
	 * coupan) throws OrderIdNotFoundException, CustomerIdNotFoundException{ Order
	 * order2 = orderService.viewOrder(id); System.out.println(order2); Customer
	 * cust = custService.viewCustomer(custId).get(); Coupan coupan1 =
	 * coupanService.viewCoupans(custId); System.out.println(cust);
	 * order2.setCustomer(cust); //Order updatedOrder =
	 * orderService.patchTheOrder(order2);
	 * 
	 * Order updatedOrder = orderService.updateOrder(order2);
	 * System.out.println(updatedOrder);
	 * 
	 * return new ResponseEntity<Order>(updatedOrder, HttpStatus.ACCEPTED); }
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Order> cancelOrder(@PathVariable int id) throws OrderIdNotFoundException{
		orderService.cancelOrder(id);
		return new ResponseEntity<Order>(HttpStatus.ACCEPTED);
		
	}
	@PutMapping("/{size}")
	public ResponseEntity<Order> calculateTotalCost(@PathVariable String size, @RequestBody Order order) throws InvalidSizeException, CustomerIdNotFoundException, OrderIdNotFoundException
	{
		order = orderService.calculateTotal(size, order);
		//System.out.println("updating in order");
		orderService.updateOrder(order);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
}
