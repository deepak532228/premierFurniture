package com.furniture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furniture.Entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

}
