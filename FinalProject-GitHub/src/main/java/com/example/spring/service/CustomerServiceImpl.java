package com.example.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring.entity.Customer;
import com.example.spring.entity.Food;
import com.example.spring.exception.CustomerNotFoundException;
import com.example.spring.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	@Override
	public List<Customer> findAllByName(String name) {
		// TODO Auto-generated method stub
		List<Customer> list = customerRepository.findAllByUserName(name);
		if(list.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found!!");
		}
		return list;
	}
	
	public Customer findById(int Id){
		// TODO Auto-generated method stub
		Optional<Customer> cust = customerRepository.findById(Id);
		Customer obj = null;
		if(cust.isPresent()) {
			obj=cust.get();
		return obj;
		}
		else
			throw new CustomerNotFoundException("Customer not found!!");
		
	}
	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer customers = customerRepository.save(customer);
		return customers;
	}

	@Override
	public String deleteCustomer(int Id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(Id);
		return "Customer Deleted";
	}

	@Override
	public Customer update(Customer customers) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.save(customers);
		return customer;
	}

	@Override
	public String findByFood(Food food) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> findAllFoodByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		
		List<Food> food= customerRepository.findAllFoodByCustomerId(customerId);
		return food;
	}
	
}
