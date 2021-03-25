package com.cg.onlinepizza.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="id_cart")
	@SequenceGenerator(name = "id_cart", sequenceName="ID_SEQUENCE_FOR_CART" ,initialValue = 300000)
	private int cartId;
	
	@NotNull(message = "Pizza ID is mandatory")
	private int pizzaId;
	
	@NotNull(message = "Please select Pizza Size to confirm the order")
	private Size pizzaSize;
	
	@NotNull(message = "Please select Quantity of Pizza Selected")
	private int quantity;
	
	public Cart(int pizzaId, Size pizzaSize, int quantity) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaSize = pizzaSize;
		this.quantity = quantity;
	}

	public Cart(int cartId, int pizzaId, Size pizzaSize, int quantity) {
		super();
		this.cartId = cartId;
		this.pizzaId = pizzaId;
		this.pizzaSize = pizzaSize;
		this.quantity = quantity;
	}

	public Cart() {
		super();
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public Size getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(Size pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", pizzaId=" + pizzaId + ", pizzaSize=" + pizzaSize + ", quantity=" + quantity
				+ "]";
	}
	
}
