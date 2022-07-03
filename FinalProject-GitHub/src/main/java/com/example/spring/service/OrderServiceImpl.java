package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.entity.Order;
import com.example.spring.exception.NotFoundException;
import com.example.spring.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order addOrder(Order order) {
		Order order1 = orderRepository.save(order);
		return order1;
	}
	
	@Override
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order getById(int orderId) {
		// TODO Auto-generated method stub
		Optional<Order> result = orderRepository.findById(orderId);
		Order order = null;
		if(result.isPresent()) {
			order = result.get();
			
		}else
		{
			throw new NotFoundException("Order ID :"+orderId+" Not Found");
		}
		return order;
	}

	@Override
	public String deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		Optional<Order> result = orderRepository.findById(orderId);
		//Order order = null;
		if(!result.isPresent()) {
			throw new NotFoundException("Order ID :"+orderId+" Not Found");
		}
		orderRepository.deleteById(orderId);
		return "Deleted order with ID: "+orderId;
	}

}
