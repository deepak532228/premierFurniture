package com.furniture.Impl;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furniture.Entity.Cart;
import com.furniture.Entity.Order;
import com.furniture.Entity.OrderDetails;
import com.furniture.Entity.Product;
import com.furniture.Exception.ThrowValidException;
import com.furniture.Repository.CartRepository;
import com.furniture.Repository.OrderDetailsRepository;
import com.furniture.Repository.OrderRepository;
import com.furniture.Repository.ProductRepository;
import com.furniture.Repository.UserRepository;
import com.furniture.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository or;
	
	@Autowired
	ProductRepository pr;
	
	@Autowired
	CartRepository cartrepo;
	
	@Autowired
	OrderDetailsRepository oi;
	
	@Autowired
	UserRepository userRepo;
	
	public List<Order> retrieveAllOrders(){
		 List<Order> orderList = or.findAll();
		 if(orderList.isEmpty()) {
			 throw new ThrowValidException("There are no orders yet");
		 }
		 return orderList;
	}

	public Order retrieveOrderById(Long idd) {
		try {
		 Order order = or.findById(idd).get();
		 return order;
		}catch(Exception e) {
			throw new ThrowValidException("Wrong order id:"+idd);
		}
	}

	public Order placeOrder(Order order) {
		
		  List<Order> orderList = or.findAll();
		  
		  order.setOrderTrackingNumber("VRO-"+(orderList.size()+1));
		
		  List<Cart> cartList = cartrepo.findByUserId(order.getUser().getId());
		  Integer quantity=0;
		  BigDecimal price = new BigDecimal("0");
		  for(Cart i: cartList) {
			  quantity+=i.getQuantity();
			  price = i.getPrice().add(price);
		  }
		  order.setTotalQuantity(quantity);
		  order.setTotalPrice(price);
		  order.setStatus("Processed");
		  
		  order.setUser(userRepo.findById(order.getUser().getId()).get());
		  Order order2 = or.save(order);
		  
		  for(Cart i: cartList) {
			  OrderDetails orderDetails = new OrderDetails(i.getQuantity(),i.getPrice(),
					                                 order2,i.getProduct());
			  Product product = pr.findById(i.getProduct().getId()).get();
			  
			  product.setUnitsInStock(product.getUnitsInStock()-i.getQuantity());
			  pr.save(product);
			  oi.save(orderDetails);
		  }
//		
//		if(product.getUnitsInStock()<order.getTotalQuantity()) {
//			return null;
//		}
		cartrepo.deleteByUserId(order.getUser().getId());
		return order2;
	}

	public void removeOrder(Long id) {
		
		retrieveOrderById(id); // checked in retrieveOrderById
		or.deleteById(id);
	}

	public Order updateOrder(Order order) {
		return or.save(order);
	}

	
	
}
