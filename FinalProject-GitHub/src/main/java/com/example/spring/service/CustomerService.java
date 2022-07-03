package com.example.spring.service;

import java.util.List;

import com.example.spring.entity.Customer;
import com.example.spring.entity.Food;
import com.example.spring.exception.CustomerNotFoundException;

public interface CustomerService {
	
	public List<Customer> findAllCustomer();
	public List<Customer> findAllByName(String name);
	public Customer findById(int Id) throws CustomerNotFoundException;
	public Customer saveCustomer(Customer customer);
	public String deleteCustomer(int Id);
	public Customer update(Customer customers);
	public String findByFood(Food food);
	public List<Food> findAllFoodByCustomerId(int customerId);

}
