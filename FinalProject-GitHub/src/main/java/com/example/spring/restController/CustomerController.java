package com.example.spring.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring.entity.Customer;
import com.example.spring.entity.Food;
import com.example.spring.exception.CustomerNotFoundException;
import com.example.spring.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public List<Customer> getAllCustomers()
	{
		List<Customer> customerList = customerService.findAllCustomer();
		return customerList;
	}
	
	@GetMapping("/name/{name}")
	public List<Customer> findAllByName(@PathVariable String name)
	{
		return customerService.findAllByName(name);
	}
	
	@GetMapping("/{Id}")
	public Customer findById(@PathVariable int Id) throws CustomerNotFoundException
	{
		return customerService.findById(Id);
	}
	
	@PostMapping("/")
	public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid Customer customer)
	{
		Customer customers = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(customers, HttpStatus.OK);
	}
	
	@DeleteMapping("/{Id}")
	public String deleteById(@PathVariable int Id)
	{
		customerService.deleteCustomer(Id);
		return "Customer Deleted";
	}
	
	@PutMapping("/")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		Customer result = customerService.update(customer);
		return result;
	}
	@GetMapping("/listOfFood/{customerId}")
	public List<Food> findAllByCustomerId(@PathVariable int customerId){
		List<Food> food= customerService.findAllFoodByCustomerId(customerId);
		return food;
	}
	
}
