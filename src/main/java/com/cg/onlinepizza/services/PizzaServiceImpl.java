package com.cg.onlinepizza.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.dao.IPizzaRepository;
import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.entities.PizzaCost;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;

@Service
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
		pizza.orElseThrow(() -> new PizzaIdNotFoundException("Pizza Not Found"));
		pizzaRepository.save(pizza.get());
		return pizza.get();
	}
	@Override
	public Pizza getPizza(int pizzaId) throws PizzaIdNotFoundException {
		Optional<Pizza> pizza = pizzaRepository.findById(pizzaId);
		return pizza.orElseThrow(() -> new PizzaIdNotFoundException("Pizza Not Found"));	
	}

	@Override
	public List<Pizza> getPizzaList() {
		List<Pizza> pizzaList = pizzaRepository.findAll();
		//System.out.println("Pizza list ::::"+pizzaList);
		return pizzaList;
	}

	//@Query("select p1.pizzaName from Pizza p1 where exists (select p from PizzaCost p where p.cost between ?1 and ?2)")
	//List<Pizza> viewPizza(@Param("list") List<PizzaCost> list);
	
	//@Query("select p from PizzaCost p where p.cost between ?1 and ?2")
	//List<PizzaCost> viewPizzaListOfMinMaxCost(@Param("minCost")double minCost, @Param("maxCost") double maxCost);
	//getPizzaByMinMaxCost
	@Override
	public List<Pizza> viewPizzaMinMaxCost(double minCost, double maxCost) {
		
		List<PizzaCost> pizzaCost = pizzaRepository.viewPizzaListOfMinMaxCost(minCost, maxCost);
		
		List<Pizza> pizza = pizzaRepository.findAll(); 
				
		/*
		 * List<Pizza> listOutput = pizza.stream() .filter(e ->
		 * pizza.stream().map(pizzaCost::).anyMatch(name -> name.equals(e.getName())))
		 * .collect(Collectors.toList());
		 */
		
		/*
		 * List<Pizza> pizzaList = repo.findAll();
		 * System.out.println("Pizza list ::::"+pizzaList);
		 * 
		 * List<Pizza> finalList = pizzaList.stream().filter((pizza) ->
		 * pizza.getCostList().contains(list1.get())).collect(Collectors.toList());
		 * //List<Pizza> finalList = repo.viewPizza(list1);
		 * //System.out.println("finalList :" +finalList);
		 */		
		return pizza;
	}

	@Override
	public Pizza updatePizza(Pizza pizza) {
		return pizzaRepository.save(pizza);
	}
}