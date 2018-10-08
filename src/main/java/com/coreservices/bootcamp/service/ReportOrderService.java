package com.coreservices.bootcamp.service;

import java.util.List;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.repository.OrderRepository;
import com.coreservices.bootcamp.utils.ReportGenerator;

/**
 * Service, that is responsible of business logic, related with generating
 * report
 * 
 */
public class ReportOrderService {

	private OrderRepository inMemoryDatabase;

	public ReportOrderService() {
		inMemoryDatabase = OrderRepository.getDatabaseInstance();
	}

	/**
	 * Generates report based on calculated value
	 * 
	 * @param message
	 * @param operationOutputValue Result value after operations on orders
	 * @return Path to the report
	 */
	public String generateReport(String message, Object operationOutputValue) {
		return ReportGenerator.generateReport(message, operationOutputValue);

	}
	
	/**
	 * Generates report based on list of order objects
	 * 
	 * @param orders
	 * @return Path to the report
	 */
	public String generateReport(List<Order> orders) {
		return ReportGenerator.generateReport(orders);
	}

}
