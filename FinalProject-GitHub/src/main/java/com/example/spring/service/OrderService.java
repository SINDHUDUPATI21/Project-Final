package com.example.spring.service;

import java.util.List;

import com.example.spring.entity.Order;

public interface OrderService {
	
	
	 //Adds a new order
	
	public Order addOrder(Order order);
	public List<Order> getOrders();
	public Order getById(int orderId);
	public String deleteOrder(int orderId);

}
