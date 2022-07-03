package com.example.spring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring.entity.Food;
import com.example.spring.service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodController {
	
		@Autowired
		private FoodService foodService;
		

		@GetMapping("/")
		public List<Food> getAllFood() {
			List<Food> foodList = foodService.findAllFood();
			return foodList;
			
		}
	
		@GetMapping("/{foodId}")
		public Food getFood(@PathVariable int foodId) {
			
			return this.foodService.findById(foodId);
		}
		
		@GetMapping("/category/{category}")
		public List<Food> findAllByCategory(@PathVariable String category){
			return foodService.findAllByCategory(category);
		}
		
		
		@GetMapping("/name/{name}")
		public List<Food> findAllByName(@PathVariable String name){
			return foodService.findAllByName(name);
		}
		@PostMapping("/")
		public Food saveFood(@RequestBody Food food) {
			Food foods=foodService.saveFood(food);
			return foods;
		}
		@DeleteMapping("/{Id}")
		public String deleteById(@PathVariable int Id) {
			
			foodService.deleteFood(Id);
			return "Data Deleted";
		}
		
		@PutMapping("/")
		public Food updateFood(@RequestBody Food food) {
			
			Food result = foodService.saveOrUpdate(food);
			
			System.out.println("Updated");
			return result;
		}

}
