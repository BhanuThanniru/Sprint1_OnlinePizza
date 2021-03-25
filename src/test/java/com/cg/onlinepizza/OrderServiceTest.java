package com.cg.onlinepizza;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlinepizza.dao.IOrderRepository;
import com.cg.onlinepizza.dao.IPizzaRepository;
import com.cg.onlinepizza.entities.Customer;
import com.cg.onlinepizza.entities.Order;
import com.cg.onlinepizza.exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.services.OrderServiceImpl;
import com.cg.onlinepizza.services.PizzaServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
	
	@Mock
	IOrderRepository orderRepository;
	@InjectMocks
	OrderServiceImpl orderService;
	
	static Order order;
	static Order order2;
	static Order order3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		order = new Order(1, "veg", "ordering veg pizza");
		order2 = new Order(1, "non-veg", "ordering non-veg pizza");
		order3 = new Order(1, "veg", "ordering veg paneer pizza");
		Customer c1 = new Customer();
		c1.setId(1);
		c1.setName("John");
		c1.setName("John123");
		order.setCustomer(c1);
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void bookOrdertest() {
		when(orderRepository.save(Mockito.anyObject())).thenReturn(order);
		assertEquals("John", orderService.bookOrder(order).getCustomer().getName());
	}

	@Test
	public void updateOrderTest() throws PizzaIdNotFoundException
	{
		when(orderRepository.findById(1)).thenReturn(Optional.of(order));
		when(orderRepository.save(Mockito.anyObject())).thenReturn(order);
		assertEquals("John123", orderService.updateOrder(order).getCustomer().getName());	 
	}

	@Test
	public void deleteOrderTest() throws PizzaIdNotFoundException
	{
		when(orderRepository.findById(1)).thenReturn(Optional.of(order));
		Exception exception = assertThrows(OrderIdNotFoundException.class, () -> orderService.cancelOrder(5));
		assertTrue(exception.getMessage().contains("Order Not Found"));
	}

	@Test
	public void getAllOrderList()
	{
		List<Order> list = new ArrayList<Order>();
		list.add(order);
		list.add(order2);
		list.add(order3);

		when(orderRepository.findAll()).thenReturn(list);
		List<Order> orderList = orderService.getOrders();

		assertEquals(3, orderList.size());
		verify(orderRepository, times(1)).findAll();
	}
	@Test
	public void getOrderByIdTest() throws OrderIdNotFoundException
	{
		when(orderRepository.findById(1)).thenReturn(Optional.of(order));
		assertEquals("John123",   orderService.getOrders(1).getCustomer().getName());
	}

}
