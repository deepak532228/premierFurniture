package com.furniture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furniture.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	
}
