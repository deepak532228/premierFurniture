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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.Entity.Cart;
import com.furniture.service.CartService;

@CrossOrigin
@RestController
public class CartController {
	
	@Autowired
	private CartService service;
	
	@GetMapping("/carts")
	public ResponseEntity<List<Cart>> retrieveAll(){
		List<Cart> cartList = service.retrieveAll();
		return new ResponseEntity<>(cartList,HttpStatus.OK);
	}
	
	@PostMapping("/carts")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart){
		Cart cart2 = service.createCart(cart);
		return new ResponseEntity<>(cart2,HttpStatus.OK);
	}
	
	@DeleteMapping("/carts/{id}")
	public String removeCartItem(@PathVariable Long id) {
		      service.removeCart(id);
		return "Item removed from cart";
	}
	
	@PutMapping("/carts")
	public ResponseEntity<Cart> updatecart(@RequestBody Cart cart){
		Cart cart2 = service.updateCart(cart);
		return new ResponseEntity<>(cart2,HttpStatus.OK);
	}


}
