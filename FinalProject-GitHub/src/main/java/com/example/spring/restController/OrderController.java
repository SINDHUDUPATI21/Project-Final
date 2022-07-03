package com.example.spring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring.entity.Order;
import com.example.spring.service.CustomerService;
import com.example.spring.service.FoodService;
import com.example.spring.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {


	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderService orderService;

	@Autowired
	@Qualifier("customerServiceImpl")
	private CustomerService customerService;

	@Autowired
	@Qualifier("foodServiceImpl")
	private FoodService foodService;
	
	@GetMapping("/orders")
	public List<Order> listOrders() {
		List<Order> orders = orderService.getOrders();
		return orders;
	}
	
	@GetMapping("/{orderId}")
	public Order getOrderById(@PathVariable int orderId) {
		Order order = orderService.getById(orderId);
		return order;
		
	}
	
	@PostMapping("/")
	public Order saveOrder(@RequestBody Order order) {
		order.setOrderId(0);
		Order orders =orderService.addOrder(order);
		return orders;
	}
	
	@DeleteMapping("/{orderId}")
	public String deleteById(@PathVariable int orderId) {
		
		String deletedOrder = orderService.deleteOrder(orderId);
		return deletedOrder;
	}
	
	@PutMapping("/")
	public Order updateOrder(@RequestBody Order order) {
		
		Order orders =orderService.addOrder(order);
		return orders;
	}

}
