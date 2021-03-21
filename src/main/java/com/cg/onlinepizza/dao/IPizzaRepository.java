package com.cg.onlinepizza.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizza.entities.Pizza;
import com.cg.onlinepizza.entities.PizzaCost;
import com.cg.onlinepizza.exceptions.InvalidMinCostException;

@Repository

public interface IPizzaRepository extends JpaRepository<Pizza, Integer> {
	
	@Query("select distinct(p) from PizzaCost p where cost between ?1 and ?2")
	List<PizzaCost> viewPizzaListOfMinMaxCost(@Param("minCost")double minCost, @Param("maxCost") double maxCost);
	
	/*
	 * Pizza deletePizza(int pizzaId) throws PizzaIdNotFoundException;
	 * 
	 * Pizza viewPizza(int pizzaId) throws PizzaIdNotFoundException;
	 * 
	 * List<Pizza> viewPizzaList();
	 * 
	 * List<Pizza> viewPizzaList(double minCost, double maxCost)throws
	 * InvalidMinCostException;
	 * 
	 * Pizza addPizza(Pizza pizza);
	 * 
	 * Pizza updatePizza(int pizzaId, String pizzaName);
	 */
}
//@Query(nativeQuery=true, name ="viewPizzaListOfMinMaxCost" , value ="select p.pizza_name,p.pizza_type,pc.cost from pizza p join pizza_pizza_cost_list pclist on p.pizza_id = pclist.pizza_pizza_id \r\n"
		//	+ "join pizza_cost pc on pc.pizza_cost_id = pclist.pizza_cost_list_pizza_cost_id and pc.cost > :minCost and pc.cost < :maxCost")
	
	
	//@Query("select p from Pizza p where p.costList IN :list1")
	//List<Pizza> viewPizza(@Param("list1") List<Double> list1);
	
	//@Query("select p from PizzaCost p where p.cost between ?1 and ?2 order by p.cost")
	//@Query("select p1 from Pizza p1 where p1.costList IN (select p from PizzaCost p where p.cost between ?1 and ?2)")
	//@Query("select p, pc.cost from Pizza p join PizzaCost pc on p.id = pc.Pizza and  pc.cost between ?1 and ?2")