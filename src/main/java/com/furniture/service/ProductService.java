package com.furniture.service;

import java.util.List;

import com.furniture.Entity.Product;


public interface ProductService {
	
	List<Product> retrieveAllProduct();
	Product retrieveProductById(Long idd);
	Product createProduct(Product product);
	void removeProduct(Long id);

}
