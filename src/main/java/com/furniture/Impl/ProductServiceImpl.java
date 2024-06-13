package com.furniture.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furniture.Entity.Product;
import com.furniture.Entity.ProductCategory;
import com.furniture.Exception.ThrowValidException;
import com.furniture.Repository.ProductCategoryRepository;
import com.furniture.Repository.ProductRepository;
import com.furniture.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository pr;

	@Autowired
	ProductCategoryRepository repo;

	public List<Product> retrieveAllProduct() {
		List<Product> productList = pr.findAll();
		if (productList.isEmpty()) {
			throw new ThrowValidException("There are no products");
		}
		return productList;
	}

	public Product retrieveProductById(Long idd) {
		Optional<Product> product = pr.findById(idd);
		try {
			return product.get();
		} catch (Exception e) {
			throw new ThrowValidException("Product not exits");
		}
	}

	public Product createProduct(Product product) { // here create and update both works

		if (product.getId() != null) {
			try {
				pr.findById(product.getId()).get();
				return pr.save(product);
			} catch (Exception e) {
				throw new ThrowValidException("Product out of record so cannot update it");
			}
		}

		Long id = product.getCategory().getId();
		Optional<ProductCategory> category = repo.findById(id);
		try {
			category.get();
			return pr.save(product);
		} catch (Exception e) {
			throw new ThrowValidException("Category is not in Record");
		}
	}

	public void removeProduct(Long id) {
		try {
			pr.findById(id).get();
			pr.deleteById(id);
		} catch (Exception e) {
			throw new ThrowValidException("Id:" + id + " Invalid Product");
		}
	}

}
