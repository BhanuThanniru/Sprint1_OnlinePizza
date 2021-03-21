package com.cg.onlinepizza.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.exceptions.InvalidMinCostException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.services.IPizzaService;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private IPizzaService pizzaService;

	@GetMapping("")
	public ResponseEntity<List<Pizza>> getPizzaList() {

		List<Pizza> listAllPizzas = pizzaService.getPizzaList();
		return new ResponseEntity<List<Pizza>>(listAllPizzas, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Pizza> addPizza(@Valid @RequestBody Pizza pizza) {
		//System.out.println("Inserting pizza's:");
		pizzaService.addPizza(pizza);
		return new ResponseEntity<Pizza>(pizza, HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<Pizza> updatePizza(@Valid @RequestBody Pizza pizza) {
		// Pizza customerById = pizzaService.getCustomerById(id);
		 pizzaService.updatePizza(pizza);
		return new ResponseEntity<Pizza>(pizza, HttpStatus.ACCEPTED);

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Pizza> deletePizza(@PathVariable int id) throws PizzaIdNotFoundException {
		pizzaService.deletePizza(id);
		return new ResponseEntity<Pizza>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pizza> viewPizzaListById(@PathVariable int id) throws PizzaIdNotFoundException {

		Pizza pizza = pizzaService.getPizza(id);
		return new ResponseEntity<Pizza>(pizza, HttpStatus.OK);
	}


	@GetMapping("/pizzas/{minCost}/{maxCost}") 
	public ResponseEntity<List<Pizza>> viewPizzaListByMincostMaxCost(@PathVariable double minCost,@PathVariable
			double maxCost) throws PizzaIdNotFoundException, InvalidMinCostException {

		List<Pizza> pizza = pizzaService.viewPizzaMinMaxCost(minCost, maxCost); 
		return new  ResponseEntity<List<Pizza>>(pizza, HttpStatus.OK);
	}
}
