package com.product.ecom.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Product")
public class Product {
   	@Id
   	@Field
	private Long prodId;
  	@Field
	private String prodName;
  	@Field
	private double price;
  	@Field
	private String desc;
	
	public Product(Long prodId, String prodName, double price, String desc) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
		this.desc = desc;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
