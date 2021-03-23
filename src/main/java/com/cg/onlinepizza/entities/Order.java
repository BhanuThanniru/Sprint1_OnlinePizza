package com.cg.onlinepizza.entities;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "PizzaOrder")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator  = "id_order")
	@SequenceGenerator(name = "id_order", sequenceName="ID_SEQUENCE_FOR_ORDER" ,initialValue = 10001)
	private int id;
	
	@NotEmpty(message = "Pizza Type is required while ordering")
	private String type;
	private String description;
	
	@ManyToOne
	private Customer customer;
	
	@NotEmpty(message = "Select mode of transaction to order")
	private String transactionMode;
	
	@ElementCollection
	Map<Integer, Integer> cart; //key - pizzaId , value - quantity
	
	@OneToOne
	private Coupan coupan;
	private double totalCost;
	public Order() {
		super();
	}
	public Order(int id, String type, String description, Customer customer, String transactionMode,
			Map<Integer, Integer> cart, Coupan coupan, double totalCost) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.customer = customer;
		this.transactionMode = transactionMode;
		this.cart = cart;
		this.coupan = coupan;
		this.totalCost = totalCost;
	}
	
	public Order(int id, String type, String description) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
	}
	
	
	public Order(int id, String type, String description, String transactionMode) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.transactionMode = transactionMode;
	}
	public Order(String type, String description, Customer customer, String transactionMode, Map<Integer, Integer> cart,
			Coupan coupan, double totalCost) {
		super();
		this.type = type;
		this.description = description;
		this.customer = customer;
		this.transactionMode = transactionMode;
		this.cart = cart;
		this.coupan = coupan;
		this.totalCost = totalCost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public Map<Integer, Integer> getCart() {
		return cart;
	}
	public void setCart(Map<Integer, Integer> cart) {
		this.cart = cart;
	}
	public Coupan getCoupan() {
		return coupan;
	}
	public void setCoupan(Coupan coupan) {
		this.coupan = coupan;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "Ordered [id=" + id + ", type=" + type + ", description=" + description + ", customer=" + customer
				+ ", transactionMode=" + transactionMode + ", cart=" + cart + ", coupan=" + coupan + ", totalCost="
				+ totalCost + "]";
	}
	
}
