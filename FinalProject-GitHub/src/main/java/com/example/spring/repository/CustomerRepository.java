package com.example.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring.entity.Customer;
import com.example.spring.entity.Food;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public List<Customer> findAllByUserName(String name);
	public String findByFood(Food food);
	public List<Food> findAllFoodByCustomerId(int custstomerId);
	
}
