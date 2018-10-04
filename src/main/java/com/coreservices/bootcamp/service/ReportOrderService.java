package com.coreservices.bootcamp.service;


import java.util.List;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.repository.GenericRepository;
import com.coreservices.bootcamp.utils.ReportGenerator;

public class ReportOrderService {
	
    private GenericRepository inMemoryDatabase;

    public ReportOrderService() {
    	inMemoryDatabase = GenericRepository.initializeDatabaseConnection();
    }

	public String generateReport(String message, Object value) {
		return ReportGenerator.generateReport(message, value);
		
	}
	
	public String generateReport(List<Order> orders) {
		return ReportGenerator.generateReport(orders);
		
	}

}
