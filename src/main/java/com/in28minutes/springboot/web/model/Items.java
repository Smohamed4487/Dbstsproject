package com.in28minutes.springboot.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemid;
	private String brand;
	private String description;
	private int noofproducts;

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNoofproducts() {
		return noofproducts;
	}

	public void setNoofproducts(int noofproducts) {
		this.noofproducts = noofproducts;
	}
	
	public Items(Long itemid, String brand, String description, int noofproducts) {
		super();
		this.itemid = itemid;
		this.brand = brand;
		this.description = description;
		this.noofproducts = noofproducts;
	}

	// Here you need to define a default constructor for Items
	public Items() {
	} 
	
	

}