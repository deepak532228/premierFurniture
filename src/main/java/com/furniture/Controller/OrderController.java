package com.furniture.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.Entity.Order;
import com.furniture.Entity.User;
import com.furniture.service.OrderService;
import com.furniture.service.UserService;

@CrossOrigin
@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private UserService us;
	
	//Get all Orders
	@GetMapping("/orders")
	public List<Order> retrieveAllOrders(){
		 List<Order> OrderList = service.retrieveAllOrders();
		 return OrderList;
	}
	
	//Get Order by id
	@GetMapping("/orders/{id}")
	public Order retrieveOrder(@PathVariable Long id){
		Order order2 = service.retrieveOrderById(id); 
		 return order2;
	}
	
	// Create new Order
	@PostMapping("/orders")
	public Order saveOrder(@RequestBody Order order){
		
		Order order2 = service.placeOrder(order);
		 User user = us.findOne(order2.getUser().getId());
		 user.setTotalOrder((user.getTotalOrder()!=0?user.getTotalOrder():0)+1);
		 us.update(user);
		 return order2;
	}
	
	// Delete a order
	@DeleteMapping("/orders/{id}")
	public String deleteOrder(@PathVariable Long id) {
		service.removeOrder(id);
		return "Order record get deleted";
	}
	
	@PutMapping("/orders")
     public Order updateOrder(@RequestBody Order order){
		
		Order order2 = service.updateOrder(order);
		 
		 return order2;
	} 	

}
