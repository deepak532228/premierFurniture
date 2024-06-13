package com.furniture.service;

import java.util.List;

import com.furniture.Entity.Order;

public interface OrderService {
	
	List<Order> retrieveAllOrders();
	Order retrieveOrderById(Long idd);
	Order placeOrder(Order order);
	void removeOrder(Long idd);
	Order updateOrder(Order order);

}
