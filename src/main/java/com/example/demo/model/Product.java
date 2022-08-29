package com.example.demo.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCTS_NO")
	private long productNo;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "QUANTITY")
	private BigInteger quantity;
	@Column(name = "PRICE")
	private BigDecimal price;
	
	public Product() {
		
	}

	public Product(int productNo, String productName, BigInteger quantity, BigDecimal price) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public long getProductNo() {
		return productNo;
	}

	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigInteger getQuantity() {
		return quantity;
	}

	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
