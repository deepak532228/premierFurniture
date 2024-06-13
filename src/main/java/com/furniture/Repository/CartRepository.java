package com.furniture.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furniture.Entity.Cart;

import jakarta.transaction.Transactional;
@Transactional
public interface CartRepository extends JpaRepository<Cart,Long>{
	
	List<Cart> findByUserId(Long id);
    void deleteByUserId(Long id);

}
 