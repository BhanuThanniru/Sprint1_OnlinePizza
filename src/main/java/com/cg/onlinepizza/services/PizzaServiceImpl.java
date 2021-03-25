package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinepizza.dao.IPizzaRepository;
import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;

@Service
@Transactional
public class PizzaServiceImpl implements IPizzaService {

	@Autowired
	private IPizzaRepository pizzaRepository ;

	@Override
	public Pizza addPizza(Pizza pizza) {
		return pizzaRepository.save(pizza);
	}

	@Override
	public Pizza deletePizza(int id) throws PizzaIdNotFoundException{
		Optional<Pizza> pizza = pizzaRepository.findById(id);
		pizza.orElseThrow(() -> new PizzaIdNotFoundException("Pizza Id Not Found"));
		pizzaRepository.deleteById(id);
		return pizza.get();
	}
	@Override
	public Pizza getPizzaById(int pizzaId) throws PizzaIdNotFoundException {
		Optional<Pizza> pizza = pizzaRepository.findById(pizzaId);
		return pizza.orElseThrow(() -> new PizzaIdNotFoundException("Pizza Id Not Found"));	
	}

	@Override
	public List<Pizza> getPizzaList() {
		List<Pizza> pizzaList = pizzaRepository.findAll();
		return pizzaList;
	}
	
	@Override
	public Pizza updatePizza(Pizza pizza) throws PizzaIdNotFoundException {
		int pizzaId = pizza.getId();
		Optional<Pizza> pizza1 = pizzaRepository.findById(pizzaId);
		pizza1.orElseThrow(() -> new  PizzaIdNotFoundException("Pizza Id Not Found"));
		pizzaRepository.save(pizza);
		return pizza;
		
	}

	@Override
	public List<Pizza> getPizzaByType(String pizzaType) {
		List<Pizza> pizza = pizzaRepository.getPizzaByType(pizzaType);
		return pizza;
	}

	@Override
	public List<Pizza> getPizzaByName(String pizzaName) {
		List<Pizza> pizza = pizzaRepository.getPizzaByName(pizzaName);
		return pizza;
	}
}