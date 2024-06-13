package com.furniture.service;

import java.util.List;

import com.furniture.Entity.ProductCategory;


public interface ProductCategoryService {
	
	List<ProductCategory> retrieveAll();
	ProductCategory retrieveById(Long id);
	ProductCategory createProductCategory(ProductCategory obj);
	void deleteCategory(Long id);

}
