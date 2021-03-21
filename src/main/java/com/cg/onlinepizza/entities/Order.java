/*
 * package com.cg.onlinepizza.entities;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import javax.persistence.ElementCollection; import javax.persistence.Entity;
 * import javax.persistence.Id; import javax.persistence.OneToOne; import
 * javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "Order") public class Order {
 * 
 * @Id private int orderId; private String orderType; private String
 * orderDescription;
 * 
 * @OneToOne private Customer customerId; private String transactionMode;
 * 
 * @ElementCollection Map<Pizza,Integer> mapPizzaQuantity;
 * 
 * @OneToOne private Coupan coupan; private double totalCost;
 * 
 * public Order() { super(); }
 * 
 * public Order(int orderId, String orderType, String orderDescription, Customer
 * customerId, String transactionMode, Map<Pizza, Integer> mapPizzaQuantity,
 * Coupan coupan, double totalCost) { super(); this.orderId = orderId;
 * this.orderType = orderType; this.orderDescription = orderDescription;
 * this.customerId = customerId; this.transactionMode = transactionMode;
 * this.mapPizzaQuantity = mapPizzaQuantity; this.coupan = coupan;
 * this.totalCost = totalCost; }
 * 
 * @Override public String toString() { return "OrderMain [orderId=" + orderId +
 * ", orderType=" + orderType + ", orderDescription=" + orderDescription +
 * ", customerId=" + customerId + ", transactionMode=" + transactionMode +
 * ", mapPizzaQuantity=" + mapPizzaQuantity + ", coupan=" + coupan +
 * ", totalCost=" + totalCost + "]"; }
 * 
 * public int getOrderId() { return orderId; }
 * 
 * public void setOrderId(int orderId) { this.orderId = orderId; }
 * 
 * public String getOrderType() { return orderType; }
 * 
 * public void setOrderType(String orderType) { this.orderType = orderType; }
 * 
 * public String getOrderDescription() { return orderDescription; }
 * 
 * public void setOrderDescription(String orderDescription) {
 * this.orderDescription = orderDescription; }
 * 
 * public Customer getCustomerId() { return customerId; }
 * 
 * public void setCustomerId(Customer customerId) { this.customerId =
 * customerId; }
 * 
 * public String getTransactionMode() { return transactionMode; }
 * 
 * public void setTransactionMode(String transactionMode) { this.transactionMode
 * = transactionMode; }
 * 
 * public Map<Pizza, Integer> getMapPizzaQuantity() { return mapPizzaQuantity; }
 * 
 * public void setMapPizzaQuantity(Map<Pizza, Integer> mapPizzaQuantity) { }
 * 
 * public Coupan getCoupan() { return coupan; }
 * 
 * public void setCoupan(Coupan coupan) { this.coupan = coupan; }
 * 
 * public double getTotalCost() { return totalCost; }
 * 
 * public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
 * 
 * }
 */