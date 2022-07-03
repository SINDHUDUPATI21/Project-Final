package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring.entity.Food;
import com.example.spring.exception.NotFoundException;
import com.example.spring.repository.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService{

	
	List<Food> list;
	@Autowired
	FoodRepository foodRepository;
	
	public List<Food> Bill() {
		// TODO Auto-generated method stub
		List<Food> list=foodRepository.findAll();
		return list;
	}
	
	@Override
	public List<Food> findAllFood() {
		// TODO Auto-generated method stub
		List<Food> list=foodRepository.findAll();
		return list;
	}
	
	@Override
	public List<Food> findAllByCategory(String category) {
		// TODO Auto-generated method stub
		List<Food> list;
		list=foodRepository.findAllByCategory(category);
		if(list.isEmpty()) {
			throw new NotFoundException("Food not found!!");
		}
		return list;
	}



	@Override
	public List<Food> findAllByName(String name) {
		// TODO Auto-generated method stub
		List<Food> list;
		list=foodRepository.findAllByName(name);
		if(list.isEmpty()) {
			throw new NotFoundException("Food not found!!");
		}
		return list;
	}


	@Override
	public Food saveFood(Food food) {
		// TODO Auto-generated method stub
		
		Food foods=foodRepository.save(food);
		return foods;
	}


	@Override
	public String deleteFood(int Id) {
		// TODO Auto-generated method stub
		foodRepository.deleteById(Id);
		return "Data Deleted";
	}


	@Override
	public Food saveOrUpdate(Food foods) {
		Food food = foodRepository.save(foods);
		if(food == null) {
			throw new NotFoundException("Food is not present");
		}
		return food;
	}

	@Override
	public Food findById(int foodId) {
		// TODO Auto-generated method stub

		Optional<Food> food = foodRepository.findById(foodId);
		Food obj = null;
		if(food.isPresent()) {
			obj=food.get();
		return obj;
		}
		else
			throw new NotFoundException("Food not found!!");
	}

}
