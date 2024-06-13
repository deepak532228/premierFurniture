package com.furniture.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.Entity.ProductCategory;
import com.furniture.service.ProductCategoryService;

@CrossOrigin
@RestController
public class ProductCategoryController {
	
	@Autowired
	ProductCategoryService service;
	
	//Get all Category
	@GetMapping("/categories")
	public ResponseEntity<List<ProductCategory>> retrieveAll(){
		 List<ProductCategory> categoryList = service.retrieveAll();
		 return new ResponseEntity<>(categoryList,HttpStatus.OK);
	}
	
	//Get Category By Id
	@GetMapping("/categories/{id}")
	public ResponseEntity<ProductCategory> retrieveCategoryById(@PathVariable Long id){
		 ProductCategory category = service.retrieveById(id);
		 return new ResponseEntity<>(category,HttpStatus.OK);
	}
	
	//Create new Category
	@PostMapping("/categories")
	public ResponseEntity<ProductCategory> creatCategory(@RequestBody ProductCategory obj){
		 ProductCategory category = service.createProductCategory(obj);
		 return new ResponseEntity<>(category,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/categories/{id}")
	public String removeCategory(@PathVariable Long id){
		service.deleteCategory(id);
		return "Category removed from data";
	}
	

}
