package com.cg.onlinepizza.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.exceptions.InvalidMinCostException;
import com.cg.onlinepizza.exceptions.PizzaIdNotFoundException;

public class PizzaRepositoryImpl implements IPizzaRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
	EntityManager em = factory.createEntityManager();
	Pizza pizza ;
	
	@Override
	public Pizza addPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		System.out.println("Adding pizza...");
		em.getTransaction().begin();
		em.persist(pizza);
		em.getTransaction().commit();
		em.close();
		System.out.println("Pizza Data inserted");
		return pizza;
	}

	
	@Override
	public Pizza updatePizza(int pizzaId, String pizzaName) {
		// TODO Auto-generated method stub
		 
		System.out.println("Updating data.....");
		em.getTransaction().begin();
		 pizza = em.find(Pizza.class,pizzaId); 
		pizza.setPizzaName(pizzaName);
		em.getTransaction().commit();
		em.close();
		System.out.println("Pizza Data updated");
		return pizza;
	}

	@Override
	public Pizza deletePizza(int pizzaId) throws PizzaIdNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Deleting pizza.......");
		em.getTransaction().begin();
		pizza = em.find(Pizza.class, pizzaId);
		em.remove(pizza);
		em.getTransaction().commit();
		em.close();
		System.out.println("pizza after deleting :"+pizza);		
		return pizza;
	}

	@Override
	public Pizza viewPizza(int pizzaId) throws PizzaIdNotFoundException {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		System.out.println("listing all pizza's based on id.....");
		pizza= em.find(Pizza.class, pizzaId);
		//System.out.println(pizza.toString());
		em.close();
		
		return pizza;
	}

	@Override
	public List<Pizza> viewPizzaList() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		System.out.println("listing all pizza's........");
		List<Pizza> list1 = new ArrayList<Pizza>();
		Query query = em.createQuery("select s from pizzamain s ");
		list1 =query.getResultList();
		
		System.out.println("list1 "+list1);
		return list1;
	}

	@Override
	public List<Pizza> viewPizzaList(double minCost, double maxCost) throws InvalidMinCostException {
		// TODO Auto-generated method stub
		
		em.getTransaction().begin();
		List<Pizza> list1 = new ArrayList<Pizza>();
		list1 = em.createQuery("select * from pizza p join pizza_map1 pm where pm.map1 =p.pizzaId").getResultList();		
		return list1;
		
	}

	

}
