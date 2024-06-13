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

import com.furniture.Entity.Product;
import com.furniture.service.ProductService;
@CrossOrigin
@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
	//Get product List
	@GetMapping("/products")
	public ResponseEntity<List<Product>> retrieveAll(){
		 List<Product> productList = service.retrieveAllProduct();
		 return new ResponseEntity<>(productList,HttpStatus.OK);
	}
	
	//Get product By Id
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> retrieveProductById(@PathVariable Long id){
		 Product product = service.retrieveProductById(id);	 
		 return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	//Add New Product
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product obj){
		Product createProduct = service.createProduct(obj);
		return new ResponseEntity<>(createProduct,HttpStatus.CREATED);
	}
	
	//Delete Product by Id
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable Long id){
		service.removeProduct(id);
		return "Product removed";
	}

}
