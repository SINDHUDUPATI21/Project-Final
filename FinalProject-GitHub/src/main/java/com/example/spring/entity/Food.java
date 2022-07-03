package com.example.spring.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Food {
	@Id
	@GeneratedValue(generator = "IdGen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "IdGen",initialValue = 202)
	private int foodId;
	private String name;
	private int price;
	private String category;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "food")
	@JsonIgnore
	private List<Customer> customers;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "food")
	private Set<Order> orders = new HashSet<>();
	

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(int foodId, String name, int price, String category, List<Customer> customers, Set<Order> orders) {
		super();
		this.foodId = foodId;
		this.name = name;
		this.price = price;
		this.category = category;
		this.customers = customers;
		this.orders = orders;
	}


	public int getFoodId() {
		return foodId;
	}


	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	public List<Customer> getCustomers() {
		return customers;
	}



	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", name=" + name + ", price=" + price + ", category=" + category
				+ ", customers=" + customers + ", orders=" + orders + "]";
	}

}
