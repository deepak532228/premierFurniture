package com.furniture.service;

import java.util.List;

import com.furniture.Entity.Cart;


public interface CartService {
	
	List<Cart> retrieveAll();
	Cart createCart(Cart obj);
	Cart updateCart(Cart obj);
	void removeCart(Long id);

}
