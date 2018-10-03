package com.coreservices.bootcamp.bootcamp;

import com.coreservices.bootcamp.bootcamp.service.OrderService;

public class Main {

	public static void main(String[] args) {
		OrderService service = new OrderService();
		
		System.out.println(service.getOrders().toString());

	}

}
