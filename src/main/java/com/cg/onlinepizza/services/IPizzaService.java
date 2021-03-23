package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.entities.PizzaCost;
import com.cg.onlinepizza.exceptions.InvalidMinCostException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;

@Service
public interface IPizzaService {
	Pizza addPizza(Pizza Pizza);

	Pizza updatePizza(Pizza pizza) throws PizzaIdNotFoundException;

	Pizza deletePizza(int PizzaId) throws PizzaIdNotFoundException;

	Pizza getPizzaById(int PizzaId) throws PizzaIdNotFoundException;

	List<Pizza> getPizzaList();
	
	List<Pizza> getPizzaByType(String pizzaType);
	
	List<Pizza> getPizzaByName(String pizzaName);
	
	List<Pizza> getPizzaMinMaxCost(double minCost, double maxCost) throws InvalidMinCostException;

}
