/*
 * package com.cg.onlinepizza.entities;
 * 
 * import java.util.Map;
 * 
 * import javax.persistence.ElementCollection; import javax.persistence.Entity;
 * import javax.persistence.Id; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name ="PizzaMain")
 * 
 * 
 * // PizzaMain pizza = new PizzaMain(2, "Paneer", "Paneer", "Medium",
 * "Too good")
 * 
 * //PizzaMain pizza2 = new PizzaMain(3, "Paneer", "Paneer", "Large",
 * "Too good") //PizzaMain pizza3 = new PizzaMain(4, "Paneer", "Paneer",
 * "Regular", "Too good") public class Pizza {
 * 
 * @Id private int pizzaId; private String pizzaType; private String pizzaName;
 * private String pizzaDescription;
 * 
 * @ElementCollection private Map<String,Integer> map1 ;//String - PizzaSize,
 * Integer - price
 * 
 * public Pizza() { super(); }
 * 
 * 
 * public Pizza(int pizzaId, String pizzaType, String pizzaName, String
 * pizzaDescription) { super(); this.pizzaId = pizzaId; this.pizzaType =
 * pizzaType; this.pizzaName = pizzaName; this.pizzaDescription =
 * pizzaDescription; }
 * 
 * 
 * public Pizza(int pizzaId, String pizzaType, String pizzaName, String
 * pizzaDescription, Map<String, Integer> map1) { super(); this.pizzaId =
 * pizzaId; this.pizzaType = pizzaType; this.pizzaName = pizzaName;
 * this.pizzaDescription = pizzaDescription; this.map1 = map1; }
 * 
 * @Override public String toString() { return "PizzaMain [pizzaId=" + pizzaId +
 * ", pizzaType=" + pizzaType + ", pizzaName=" + pizzaName +
 * ", pizzaDescription=" + pizzaDescription + ", map1=" + map1 + "]"; }
 * 
 * public int getPizzaId() { return pizzaId; }
 * 
 * public void setPizzaId(int pizzaId) { this.pizzaId = pizzaId; }
 * 
 * public String getPizzaType() { return pizzaType; }
 * 
 * public void setPizzaType(String pizzaType) { this.pizzaType = pizzaType; }
 * 
 * public String getPizzaName() { return pizzaName; }
 * 
 * public void setPizzaName(String pizzaName) { this.pizzaName = pizzaName; }
 * 
 * public String getPizzaDescription() { return pizzaDescription; }
 * 
 * public void setPizzaDescription(String pizzaDescription) {
 * this.pizzaDescription = pizzaDescription; }
 * 
 * public Map<String, Integer> getMap1() { return map1; }
 * 
 * public void setMap1(Map<String, Integer> map1) { this.map1 = map1; }
 * 
 * 
 * 
 * 
 * 
 * }
 */