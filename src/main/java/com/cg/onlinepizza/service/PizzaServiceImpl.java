package com.cg.onlinepizza.service;

import java.util.List;

import com.cg.onlinepizza.dao.IPizzaRepository;
import com.cg.onlinepizza.dao.PizzaRepositoryImpl;
import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.exceptions.InvalidMinCostException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;

public class PizzaServiceImpl implements IPizzaService {

	IPizzaRepository repo = new PizzaRepositoryImpl();
	
	@Override
	public Pizza addPizza(Pizza Pizza) {
		// TODO Auto-generated method stub
		return repo.addPizza(Pizza);
	}

	@Override
	public Pizza updatePizza(int pizzaId, String pizzaName) {
		// TODO Auto-generated method stub
		return repo.updatePizza(pizzaId, pizzaName);
	}

	@Override
	public Pizza deletePizza(int pizzaId) throws PizzaIdNotFoundException {
		// TODO Auto-generated method stub
		return repo.deletePizza(pizzaId);
	}

	@Override
	public Pizza viewPizza(int pizzaId) throws PizzaIdNotFoundException {
		// TODO Auto-generated method stub
		return repo.viewPizza(pizzaId);
	}

	@Override
	public List<Pizza> viewPizzaList() {
		// TODO Auto-generated method stub
		return repo.viewPizzaList();
	}

	@Override
	public List<Pizza> viewPizzaList(double minCost, double maxCost) throws InvalidMinCostException {
		// TODO Auto-generated method stub
		return repo.viewPizzaList(minCost, maxCost);
	}

}
