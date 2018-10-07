package com.coreservices.bootcamp.service;


import java.util.List;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.repository.OrderRepository;
import com.coreservices.bootcamp.utils.ReportGenerator;

public class ReportOrderService {
	
    private OrderRepository inMemoryDatabase;

    public ReportOrderService() {
    	inMemoryDatabase = OrderRepository.getDatabaseInstance();
    }

	public String generateReport(String message, Object value) {
		return ReportGenerator.generateReport(message, value);
		
	}
	
	public String generateReport(List<Order> orders) {
		return ReportGenerator.generateReport(orders);		
	}

}
