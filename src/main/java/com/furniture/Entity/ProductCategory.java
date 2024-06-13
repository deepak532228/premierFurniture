package com.furniture.Entity;

import java.util.HashSet;

import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="product_category")
@Data
public class ProductCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="category_name",nullable=false)
	private String categoryName;

	public ProductCategory(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	

	 

	
	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getCategoryName() {
		return categoryName;
	}





	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}




	public void setProducts(Set<Product> products) {
		this.products = products;
	}





	public ProductCategory() {
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	  private Set<Product> products = new HashSet<>();
	
}
