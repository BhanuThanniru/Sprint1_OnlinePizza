package com.cg.onlinepizza.entities;
/*
 * package com.cg.onlinepizza.entities;
 * 
 * import java.util.List; import java.util.Map; import java.util.Set;
 * 
 * import javax.persistence.CascadeType; import
 * javax.persistence.ElementCollection; import javax.persistence.Entity; import
 * javax.persistence.FetchType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.ManyToOne; import
 * javax.persistence.OneToMany; import javax.persistence.OneToOne; import
 * javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "Ordering") public class Order {
 * 
 * @Id private int id; private String type; private String description;
 * 
 * @ManyToOne//bi-directional private Customer customer; private String
 * transactionMode;
 * 
 * //@ElementCollection// Map<Pizza,Integer> cart;//// 1st- pizzaid,value -
 * quantity
 * 
 * @OneToOne
 * 
 * @JoinColumn(name ="cart_id") private Cart cart;
 * 
 * 
 * //@OneToMany//pizzacart //Map<Integer, Pizza> key - pizzaid value - pizza
 * object
 * 
 * @OneToOne private Coupan coupan; private double totalCost;
 * 
 * public Order() { super(); }
 * 
 * public Order(int id, String type, String description, Customer customer,
 * String transactionMode, Cart cart, Coupan coupan, double totalCost) {
 * super(); this.id = id; this.type = type; this.description = description;
 * this.customer = customer; this.transactionMode = transactionMode; this.cart =
 * cart; this.coupan = coupan; this.totalCost = totalCost; }
 * 
 * @Override public String toString() { return "Order [id=" + id + ", type=" +
 * type + ", description=" + description + ", customer=" + customer +
 * ", transactionMode=" + transactionMode + ", cart=" + cart + ", coupan=" +
 * coupan + ", totalCost=" + totalCost + "]"; }
 * 
 * public int getId() { return id; }
 * 
 * public void setId(int id) { this.id = id; }
 * 
 * public String getType() { return type; }
 * 
 * public void setType(String type) { this.type = type; }
 * 
 * public String getDescription() { return description; }
 * 
 * public void setDescription(String description) { this.description =
 * description; }
 * 
 * public String getTransactionMode() { return transactionMode; }
 * 
 * public void setTransactionMode(String transactionMode) { this.transactionMode
 * = transactionMode; }
 * 
 * 
 * public Customer getCustomer() { return customer; }
 * 
 * public void setCustomer(Customer customer) { this.customer = customer; }
 * 
 * 
 * 
 * public Cart getCart() { return cart; }
 * 
 * public void setCart(Cart cart) { this.cart = cart; }
 * 
 * public Coupan getCoupan() { return coupan; }
 * 
 * public void setCoupan(Coupan coupan) { this.coupan = coupan; }
 * 
 * public double getTotalCost() { return totalCost; }
 * 
 * public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
 * 
 * 
 * }
 */