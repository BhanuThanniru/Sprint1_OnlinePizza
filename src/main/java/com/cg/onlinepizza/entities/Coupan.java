package com.cg.onlinepizza.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Coupan")
public class Coupan {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator  = "id_coupan")
	@SequenceGenerator(name = "id_coupan", sequenceName="ID_SEQUENCE_FOR_COUPAN" ,initialValue = 5001)
	
	private int id;
	private String name;
	private String type;
	private String description;
	

	public Coupan() {
		super();
	}
	
	
	public Coupan(String name, String type, String description) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
	}
	public Coupan(int id, String name, String type, String description) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "Coupan [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description + "]";
	}
	
	
}