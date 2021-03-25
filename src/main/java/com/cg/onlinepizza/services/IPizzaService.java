package com.cg.onlinepizza.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.onlinepizza.entities.Pizza;
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

}
