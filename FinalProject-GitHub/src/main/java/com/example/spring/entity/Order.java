package com.example.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "order_id")
		private int orderId;

	    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "customer_id", nullable = false) 
	    private Customer customer;

	    @ManyToOne(fetch = FetchType.LAZY)

	    private Food food;

		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Order(int orderId, Customer customer, Food food) {
			super();
			this.orderId = orderId;
			this.customer = customer;
			this.food = food;
		}


		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "Order [orderId=" + orderId + ", customer=" + customer + ", food=" + food + "]";
		}


		public Food getFood() {
			return food;
		}


		public void setFood(Food food) {
			this.food = food;
		}

	}
