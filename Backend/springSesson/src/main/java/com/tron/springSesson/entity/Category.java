package com.tron.springSesson.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorymaster")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cateId; 
	private String name;
	private LocalDate createdOn;
	
	
	Category(){
		
	}


	public Category(int cateId, String name, LocalDate createdOn) {
		super();
		this.cateId = cateId;
		this.name = name;
		this.createdOn = createdOn;
	}


	public int getCateId() {
		return cateId;
	}


	public void setCateId(int cateId) {
		this.cateId = cateId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	
	
	

}
