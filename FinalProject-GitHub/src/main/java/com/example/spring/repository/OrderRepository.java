package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
}
