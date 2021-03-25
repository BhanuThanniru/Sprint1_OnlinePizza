package com.cg.onlinepizza.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PizzaOrder")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator  = "id_order")
	@SequenceGenerator(name = "id_order", sequenceName="ID_SEQUENCE_FOR_ORDER" ,initialValue = 10001)
	private int id;

	@NotNull(message = "Pizza Type is required while ordering")
	private String type;
	private String description;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customer;

	@NotNull(message = "Select mode of transaction to order")
	@Enumerated(EnumType.STRING)
	private TransactionMode transactionMode;

	private LocalDate localDate = LocalDate.now();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="order_id")
	private List<Cart> cart = new ArrayList<Cart>();

	@OneToOne
	private Coupan coupan;
	private double totalCost;
	public Order() {
		super();
	}

	
	public Order(String type, String description, Customer customer, TransactionMode transactionMode, List<Cart> cart, Coupan coupan, double totalCost) {
		super();
		this.type = type;
		this.description = description;
		this.customer = customer;
		this.transactionMode = transactionMode;
		this.cart = cart;
		this.coupan = coupan;
		this.totalCost = totalCost;
	}


	public Order(int id, String type, String description, Customer customer, TransactionMode transactionMode, List<Cart> cart, Coupan coupan, double totalCost) {
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

	public Order(int id, String type, String description,Customer customer, TransactionMode transactionMode,
			LocalDate localDate, List<Cart> cart, Coupan coupan, double totalCost) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.customer = customer;
		this.transactionMode = transactionMode;
		this.localDate = localDate;
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


	public Order(int id, String type, String description, TransactionMode transactionMode) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.transactionMode = transactionMode;
	}



	public Order(String type, String description, Customer customer, TransactionMode transactionMode, List<Cart> cart, Coupan coupan) {
		super();
		this.type = type;
		this.description = description;
		this.customer = customer;
		this.transactionMode = transactionMode;
		this.cart = cart;
		this.coupan = coupan;
	}



	public Order(String type, String description, Customer customer, TransactionMode transactionMode,
			Coupan coupan) {
		super();
		this.type = type;
		this.description = description;
		this.customer = customer;
		this.transactionMode = transactionMode;
		this.coupan = coupan;	
	}
	
	
	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
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
	public TransactionMode getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(TransactionMode transactionMode) {
		this.transactionMode = transactionMode;
	}
	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
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
		return "Order [id=" + id + ", type=" + type + ", description=" + description + ", customer=" + customer
				+ ", transactionMode=" + transactionMode + ", localDate=" + localDate + ", cart=" + cart + ", coupan="
				+ coupan + ", totalCost=" + totalCost + "]";
	}
}
