package com.cg.onlinepizza.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "PizzaCost")
public class PizzaCost {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator  = "id_pizza_cost")
	@SequenceGenerator(name = "id_pizza_cost", sequenceName="ID_SEQUENCE_FOR_PIZZA_COST" ,initialValue = 20001, allocationSize = 1)
	private int costId;
	
	@Enumerated
	@NotEmpty(message = "Pizza Size is required")
	private Size pizzaSize;
	
	@NotEmpty(message = "Pizza Cost is required")
	private double cost;
	
	@ManyToOne
	private Pizza pizza;
	
	public PizzaCost() {
		super();
	}
	
	public PizzaCost(Size pizzaSize, double cost, Pizza pizza) {
		super();
		this.pizzaSize = pizzaSize;
		this.cost = cost;
		this.pizza = pizza;
	}
	public PizzaCost(int costId, Size pizzaSize, double cost) {
		super();
		this.costId = costId;
		this.pizzaSize = pizzaSize;
		this.cost = cost;
	}
	public int getCostId() {
		return costId;
	}
	public void setCostId(int costId) {
		this.costId = costId;
	}
	
	public Size getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(Size pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "PizzaCost [costId=" + costId + ", size=" + pizzaSize + ", cost=" + cost + "]";
	}
}
