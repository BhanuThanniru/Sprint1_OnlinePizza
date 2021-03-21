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

	//Pizza updatePizza(int pizzaId, String pizzaName);
	
	Pizza updatePizza(Pizza pizza);

	Pizza deletePizza(int PizzaId) throws PizzaIdNotFoundException;

	Pizza getPizza(int PizzaId) throws PizzaIdNotFoundException;

	List<Pizza> getPizzaList();

	/*
	 * @Query("select p.pizzaName from Pizza p where p.pizzaCostList in :pizzaCost")
	 * List<Pizza> viewPizza(@Param("list") List<PizzaCost> pizzaCost);
	 * 
	 * @Query("select p.pizzaCostId from PizzaCost p where p.cost between ?1 and ?2"
	 * ) List<PizzaCost> viewPizzaListOfMinMaxCost(@Param("minCost")double
	 * minCost, @Param("maxCost") double maxCost);
	 */

	List<Pizza> viewPizzaMinMaxCost(double minCost, double maxCost);
}
