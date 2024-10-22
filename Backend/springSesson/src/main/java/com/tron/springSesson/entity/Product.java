package com.tron.springSesson.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prodId;
	private String prdname;
	private String img;
	private LocalDate createdOn;
	private double prdprice;
	
	
	@ManyToOne
	@JoinColumn(name = "cateId")
	private Category category;


	public Product(int prodId, String prdname, String img, double prdprice, Category category) {
		super();
		this.prodId = prodId;
		this.prdname = prdname;
		this.img = img;
		this.prdprice = prdprice;
		this.category = category;
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getProdId() {
		return prodId;
	}


	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	

	public LocalDate getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}


	public void setPrdprice(double prdprice) {
		this.prdprice = prdprice;
	}


	public String getPrdname() {
		return prdname;
	}


	public void setPrdname(String prdname) {
		this.prdname = prdname;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public double getPrdprice() {
		return prdprice;
	}


	public void setPrdprice(int prdprice) {
		this.prdprice = prdprice;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
}
