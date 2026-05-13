package com.model;

import java.time.LocalDateTime;

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
	private Integer product_id;

	@Column(name = "product_name", nullable = false, length = 100)
	private String productName;

	@Column(name = "brand", length = 100)
	private String brand;

	@Column(name = "category", length = 50)
	private String category;

	@Column(name = "shelf_life_days")
	private Integer shelfLifeDays;

	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private LocalDateTime createdAt;

	// Constructors
	public Product() {
	}

	public Product(String productName, String brand, String category, Integer shelfLifeDays) {
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.shelfLifeDays = shelfLifeDays;
	}

	// Getters and Setters
	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getShelfLifeDays() {
		return shelfLifeDays;
	}

	public void setShelfLifeDays(Integer shelfLifeDays) {
		this.shelfLifeDays = shelfLifeDays;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}