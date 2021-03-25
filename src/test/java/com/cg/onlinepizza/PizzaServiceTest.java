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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlinepizza.dao.IPizzaRepository;
import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.services.PizzaServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PizzaServiceTest {

	@Mock
	IPizzaRepository pizzaRepository;
	@InjectMocks
	PizzaServiceImpl pizzaService;

	static Pizza pizza1;
	static Pizza pizza2;
	static Pizza pizza3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		pizza1 = new Pizza(1, "Veg", "Paneer", "yummmy");
		pizza2 = new Pizza(2, "Veg", "Tandoori", "goood");
		pizza3 = new Pizza(3, "Non-veg", "Chicken", "woowww");	
	}

	@Test
	public void addPizzaTest()
	{
		when(pizzaRepository.save(Mockito.anyObject())).thenReturn(pizza1);
		assertEquals("Paneer", pizzaService.addPizza(pizza1).getName());
	}

	@Test
	public void updatePizzaTest() throws PizzaIdNotFoundException
	{
		when(pizzaRepository.findById(1)).thenReturn(Optional.of(pizza1));
		when(pizzaRepository.save(Mockito.anyObject())).thenReturn(pizza1);
		assertEquals("Paneer", pizzaService.updatePizza(pizza1).getName());	 
	}

	@Test
	public void deletePizzaTest() throws PizzaIdNotFoundException
	{
		when(pizzaRepository.findById(1)).thenReturn(Optional.of(pizza1));
		Exception exception = assertThrows(PizzaIdNotFoundException.class, () -> pizzaService.deletePizza(5));
		assertTrue(exception.getMessage().contains("Pizza Id Not Found"));
	}

	@Test
	public void getAllPizzaList()
	{
		List<Pizza> list = new ArrayList<Pizza>();
		list.add(pizza1);
		list.add(pizza2);
		list.add(pizza3);

		when(pizzaRepository.findAll()).thenReturn(list);
		List<Pizza> pizzaList = pizzaService.getPizzaList();

		assertEquals(3, pizzaList.size());
		verify(pizzaRepository, times(1)).findAll();
	}

	@Test
	public void getPizzaByIdTest() throws PizzaIdNotFoundException
	{
		when(pizzaRepository.findById(1)).thenReturn(Optional.of(pizza1));
		assertEquals("Paneer",  pizzaService.getPizzaById(1).getName());
	}

}
