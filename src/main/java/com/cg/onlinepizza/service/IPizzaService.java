package com.cg.onlinepizza.service;

import java.util.List;

import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.exceptions.InvalidMinCostException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;


public interface IPizzaService {
	Pizza addPizza(Pizza Pizza);

	Pizza updatePizza(int pizzaId, String pizzaName);

	Pizza deletePizza(int PizzaId) throws PizzaIdNotFoundException;

	Pizza viewPizza(int PizzaId) throws PizzaIdNotFoundException;

	List<Pizza> viewPizzaList();

	List<Pizza> viewPizzaList(double minCost, double maxCost)throws InvalidMinCostException;

}
