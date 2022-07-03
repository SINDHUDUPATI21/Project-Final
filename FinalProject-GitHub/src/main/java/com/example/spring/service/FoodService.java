package com.example.spring.service;

import java.util.List;

import com.example.spring.entity.Food;

public interface FoodService {
	

	public List<Food> findAllFood();
	public Food findById(int foodId);
	public List<Food> findAllByName(String name);
	public Food saveFood(Food food);
	public String deleteFood(int foodId);
	public Food saveOrUpdate(Food foods);
	public List<Food> findAllByCategory(String category);
	
}
