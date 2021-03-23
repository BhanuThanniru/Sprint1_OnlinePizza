package com.cg.onlinepizza.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="Pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator  = "id_pizza")
	@SequenceGenerator(name = "id_pizza", sequenceName="ID_SEQUENCE_FOR_PIZZA" ,initialValue = 101)
	private int id;
	
	@NotEmpty(message = "Pizza Type is required")
	private String type;
	
	@NotEmpty(message = "Pizza Name is required")
	private String name;
	
	private String description;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Pizza_ID")
	List<PizzaCost> costList = new ArrayList<PizzaCost>();

	public Pizza() {
		super();
	}

	public Pizza(String type, String name, String description, List<PizzaCost> costList) {
		super();
		this.type = type;
		this.name = name;
		this.description = description;
		this.costList = costList;
	}

	public Pizza(int id, String type, String name, String description) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
	}
	public Pizza(int id, String type, String name, String description, List<PizzaCost> costList) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
		this.costList = costList;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<PizzaCost> getCostList() {
		return costList;
	}
	public void setCostList(List<PizzaCost> costList) {
		this.costList = costList;
	}
	@Override
	public String toString() {
		return "Pizza [id=" + id + ", type=" + type + ", name=" + name + ", description=" + description + ", costList="
				+ costList + "]";
	}
}