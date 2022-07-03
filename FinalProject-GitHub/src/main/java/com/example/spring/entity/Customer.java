package com.example.spring.entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	@NotNull(message = "username shouldn't be null")
	private String userName;
	@NotBlank(message = "*Required")
	@Size(min = 3, message = "Min. 3 characters are mandatory")
	private String firstName;
	private String lastName;
	@NotBlank(message = "*Required")
	@Email(message = "Invalid email address")
	private String email;
	@NotBlank(message = "*Required")
	@Size(min = 3, message = "Min. 3 characters are mandatory")
	private String password;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "foodId")
	private Food food;
	


	// 1 : M
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    //@JsonIgnore
	private Set<Order> orders = new HashSet<>();
	
	public Customer() {
		super();
	}




	public Customer(int customerId, @NotNull(message = "username shouldn't be null") String userName,
			@NotBlank(message = "*Required") @Size(min = 3, message = "Min. 3 characters are mandatory") String firstName,
			String lastName, @NotBlank(message = "*Required") @Email(message = "Invalid email address") String email,
			@NotBlank(message = "*Required") @Size(min = 3, message = "Min. 3 characters are mandatory") String password,
			Food food) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.food = food;
	}




	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}




	public Food getFood() {
		return food;
	}




	public void setFood(Food food) {
		this.food = food;
	}




	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", password=" + password + "]";
	}
	
//	public List<Food> getFoodList() {
//		return foodList;
//	}
//
//	public void setFoodList(List<Food> foodList) {
//		this.foodList = foodList;
//	}
	
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}



}
