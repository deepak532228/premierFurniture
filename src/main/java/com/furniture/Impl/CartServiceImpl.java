package com.furniture.Impl;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furniture.Entity.Cart;
import com.furniture.Entity.Product;
import com.furniture.Exception.ThrowValidException;
import com.furniture.Repository.CartRepository;
import com.furniture.Repository.ProductRepository;
import com.furniture.Repository.UserRepository;
import com.furniture.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartRepository cr;

	@Autowired
	ProductRepository pr;
	
	@Autowired
	UserRepository ur;

	@Override
	public List<Cart> retrieveAll() {
		List<Cart> cartList = cr.findAll();
		if (cartList.isEmpty()) {
			throw new ThrowValidException("There are not any item selected");
		}
		return cartList;
	}

	@Override
	public Cart createCart(Cart obj) {
		try {
			List<Cart> cartList = cr.findAll();
			if (cartList != null) {
				for (Cart i : cartList) {
					if (i.getUser().getId() == obj.getUser().getId()) {
						if (i.getProduct().getId() == obj.getProduct().getId()) {
							BigDecimal price = i.getPrice();
							Product product = pr.findById(obj.getProduct().getId()).get();
							BigDecimal unitPrice = product.getUnitPrice();
							i.setPrice((unitPrice.multiply(BigDecimal.valueOf(obj.getQuantity()))).add(price));
							i.setQuantity(obj.getQuantity() + i.getQuantity());
							return cr.save(i);
						}
					}
				}
			}

			Product product = pr.findById(obj.getProduct().getId()).get();
			BigDecimal unitPrice = product.getUnitPrice();
			obj.setPrice(unitPrice.multiply(BigDecimal.valueOf(obj.getQuantity())));
			
			obj.setProduct(product);
			obj.setUser(ur.findById(obj.getUser().getId()).get());
			Cart cart = cr.save(obj);
			
			return cart;
		} catch (Exception e) {
			throw new ThrowValidException("Select product not exists in database");
		}
	}

	@Override
	public void removeCart(Long id) {
		try {
			Cart cart = cr.findById(id).get();
			cr.deleteById(id);
		} catch (Exception e) {
			throw new ThrowValidException("Sorry something went wrong");
		}

	}

	@Override
	public Cart updateCart(Cart obj) {
		try {
			cr.findById(obj.getId()).get();
			Product product = pr.findById(obj.getProduct().getId()).get();
			BigDecimal unitPrice = product.getUnitPrice();
			obj.setPrice(unitPrice.multiply(BigDecimal.valueOf(obj.getQuantity())));
			Cart cart = cr.save(obj);
			return cart;
		} catch (Exception e) {
			throw new ThrowValidException("Something wrong input");
		}
	}

	
	

}
