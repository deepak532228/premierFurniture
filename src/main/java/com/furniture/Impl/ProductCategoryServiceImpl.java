package com.furniture.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furniture.Entity.ProductCategory;
import com.furniture.Exception.ThrowValidException;
import com.furniture.Repository.ProductCategoryRepository;
import com.furniture.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	
	@Autowired
	ProductCategoryRepository repository;

	public List<ProductCategory> retrieveAll() {
		List<ProductCategory> categoryList = repository.findAll();
		if (categoryList.isEmpty()) {
			throw new ThrowValidException("There are no product categories");
		}
		return categoryList;
	}

	public ProductCategory retrieveById(Long id) {
		Optional<ProductCategory> category = repository.findById(id);
		try {
			return category.get();
		} catch (Exception e) {
			throw new ThrowValidException("Id:" + id + " is Wrong category");
		}
	}

	public ProductCategory createProductCategory(ProductCategory obj) {

		if (obj.getId() != null) {
			try {
				repository.findById(obj.getId()).get();
			} catch (Exception e) {
				throw new ThrowValidException("Category out of record so cannot update it");
			}
		}

		ProductCategory ob = repository.save(obj);
		return ob;
	}

	public void deleteCategory(Long id) {
		try {
			repository.findById(id).get();
			repository.deleteById(id);
		}catch(Exception e) {
			throw new ThrowValidException("Id:" + id + " Invalid Category");
		}
	}

}
