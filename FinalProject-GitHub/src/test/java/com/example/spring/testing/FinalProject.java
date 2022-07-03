package com.example.spring.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring.entity.Customer;
import com.example.spring.entity.Food;
import com.example.spring.exception.CustomerNotFoundException;
import com.example.spring.service.CustomerService;

@SpringBootTest
class FinalProject {

	@Autowired
	CustomerService customerService;
	
	@Test
	public void testFindAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> list = customerService.findAllCustomer();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testSaveCustomer()
	{
		Food food = new Food();
		Customer cust = new Customer(3, "abc", "abc", "xyz", "pqr@gmail.com", "pqr", food);
		Customer customers = customerService.saveCustomer(cust);
		assertNotNull(customers);
	}
	
	@Test
	public void testFindById()
	{
		Exception ex =  assertThrows(CustomerNotFoundException.class, ()->{customerService.findById(84);});
		String actualMsg = ex.getMessage();
		System.out.println(actualMsg);
		String expectedMsg = "Error in Customer ID";
		assertFalse(actualMsg.equals(expectedMsg));
	}
	
	@Test
	public void testingFindById()
	{
		Exception ex =  assertThrows(CustomerNotFoundException.class, ()->{customerService.findById(84);});
		String actualMsg = ex.getMessage();
		System.out.println(actualMsg);
		String expectedMsg = "Customer not found!!";
		assertTrue(actualMsg.equals(expectedMsg));
	}
	
}
