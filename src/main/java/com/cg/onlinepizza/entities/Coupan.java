package com.cg.onlinepizza.entities;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Coupan")
public class Coupan {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "id_coupan")
	@SequenceGenerator(name = "id_coupan", sequenceName="ID_SEQUENCE_FOR_COUPAN" ,initialValue = 10001, allocationSize=1)
	private int id;
	@NotEmpty(message="Coupan Name is mandatory")
	private String name;
	@NotEmpty(message=" Coupan Type should be specified")
	private String type;
	private String description;
	private int priceDiscount;
	private LocalDate ExpiryDate = LocalDate.now().plusMonths(3);

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
	public int getPriceDiscount() {
		return priceDiscount;
	}
	public void setPriceDiscount(int priceDiscount) {
		this.priceDiscount = priceDiscount;
	}

	public LocalDate getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		ExpiryDate = expiryDate;
	}
	public Coupan(int id, String name, String type, String description, int priceDiscount) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.priceDiscount = priceDiscount;
	}



	public Coupan(@NotEmpty(message = "Coupan Name is mandatory") String name,
			@NotEmpty(message = " Coupan Type should be specified") String type, String description,
			int priceDiscount) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.priceDiscount = priceDiscount;
	}
	@Override
	public String toString() {
		return "Coupan [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description
				+ ", priceDiscount=" + priceDiscount + ", ExpiryDate=" + ExpiryDate + "]";
	}
	public Coupan() {
		super();
	}
}