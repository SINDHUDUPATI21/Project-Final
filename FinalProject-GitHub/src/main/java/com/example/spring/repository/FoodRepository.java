package com.example.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {
	
	public List<Food> findAllByName(String name);

	public List<Food> findAllByCategory(String category);
	
}
