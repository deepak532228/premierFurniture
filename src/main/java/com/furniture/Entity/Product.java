package com.furniture.Entity;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;


@Entity
@Table(name="product")
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="unit_price",nullable=false)
	private BigDecimal unitPrice;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="active")
	private boolean isActive;
	
	@Column(name="units_in_stock",nullable=false)
	private int unitsInStock;
	
	@Column(name="date_created")
	@CreationTimestamp
	private LocalDate dateCreated;
	
	@Column(name="last_updated")
	@UpdateTimestamp
	private LocalDate lastUpdated;



	public Product() {
	}

	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public BigDecimal getUnitPrice() {
		return unitPrice;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public boolean isActive() {
		return isActive;
	}


	public int getUnitsInStock() {
		return unitsInStock;
	}


	public LocalDate getDateCreated() {
		return dateCreated;
	}


	public LocalDate getLastUpdated() {
		return lastUpdated;
	}


	public ProductCategory getCategory() {
		return category;
	}


	
	@ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	private Set<Cart> cart = new HashSet<>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	private Set<OrderDetails> orderItems = new HashSet<>();

	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}


	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	
	
}
