package com.cg.onlinepizza.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Coupan1")
public class Coupan {
	@Id
	private int coupanId;
	private String coupanName;
	private String coupanType;
	private String coupanDescription;
	
	
	public int getCoupanId() {
		return coupanId;
	}


	public void setCoupanId(int coupanId) {
		this.coupanId = coupanId;
	}


	public String getCoupanName() {
		return coupanName;
	}


	public void setCoupanName(String coupanName) {
		this.coupanName = coupanName;
	}


	public String getCoupanType() {
		return coupanType;
	}


	public void setCoupanType(String coupanType) {
		this.coupanType = coupanType;
	}


	public String getCoupanDescription() {
		return coupanDescription;
	}


	public void setCoupanDescription(String coupanDescription) {
		this.coupanDescription = coupanDescription;
	}


	public Coupan(int coupanId, String coupanName, String coupanType, String coupanDescription) {
		super();
		this.coupanId = coupanId;
		this.coupanName = coupanName;
		this.coupanType = coupanType;
		this.coupanDescription = coupanDescription;
		
	}


	public Coupan() {
		super();
	}
	
	@Override
	public String toString() {
		return "Coupan [coupanId=" + coupanId + ", coupanName=" + coupanName + ", coupanType=" + coupanType
				+ ", coupanDescription=" + coupanDescription + "]";
	}
	
}


	/*
	 * @OneToOne private PizzaOrder pizzaorder;
	 * 
	 */

	/*
	 * @Override public String toString() { return "Coupan [coupanId=" + coupanId +
	 * ", coupanName=" + coupanName + ", coupanType=" + coupanType +
	 * ", coupanDescription=" + coupanDescription + ", coupanPizzaId=" +
	 * coupanPizzaId + "]"; }
	 * 
	 */
	/*
	 * public Coupan() { super(); }
	 * 
	 * 
	 * 
	 * public int getCoupanId() { return coupanId; }
	 * 
	 * public void setCoupanId(int cn) { this.coupanId = cn; }
	 * 
	 * public String getCoupanName() { return coupanName; }
	 * 
	 * public void setCoupanName(String coupanName) { this.coupanName = coupanName;
	 * }
	 * 
	 * public String getCoupanType() { return coupanType; }
	 * 
	 * public void setCoupanType(String coupanType) { this.coupanType = coupanType;
	 * }
	 * 
	 * public String getCoupanDescription() { return coupanDescription; }
	 * 
	 * public void setCoupanDescription(String coupanDescription) {
	 * this.coupanDescription = coupanDescription; }
	 * 
	 * public int getCoupanPizzaId() { return coupanPizzaId; }
	 * 
	 * public void setCoupanPizzaId(int coupanPizzaId) { this.coupanPizzaId =
	 * coupanPizzaId; }
	 * 
	 * public Coupan(int coupanId, String coupanName, String coupanType, String
	 * coupanDescription, int coupanPizzaId) { super(); this.coupanId = coupanId;
	 * this.coupanName = coupanName; this.coupanType = coupanType;
	 * this.coupanDescription = coupanDescription; this.coupanPizzaId =
	 * coupanPizzaId; }
	 */

	


	

	
	


