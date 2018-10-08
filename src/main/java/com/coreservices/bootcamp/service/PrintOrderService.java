package com.coreservices.bootcamp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.repository.OrderRepository;

/**
 * Service, that is responsible of business logic, related with printing report
 * content
 * 
 */
public class PrintOrderService {

	private OrderRepository inMemoryDatabase;

	public PrintOrderService() {
		inMemoryDatabase = OrderRepository.getDatabaseInstance();
	}

	/**
	 * 
	 * @return List of orders
	 */
	public List<Order> getOrders() {
		return inMemoryDatabase.getOrders();
	}

	/**
	 * 
	 * @return Amount of all orders
	 */
	public int getTotalAmountOfOrders() {
		return inMemoryDatabase.getOrders().size();
	}

	/**
	 * 
	 * @return Total price of all orders
	 */
	public double getTotalPriceOfOrders() {
		return inMemoryDatabase.getOrders().stream().mapToDouble(order -> order.getPrice()).sum();
	}

	/**
	 * 
	 * @return Average price of order
	 */
	public double getAVGOfOrderPrice() {
		return getTotalPriceOfOrders() / getTotalAmountOfOrders();
	}

	/**
	 * 
	 * @param clientId
	 * @return list of Orders from particular client
	 */
	public List<Order> getUserOrders(String clientId) {
		List<Order> listOfUserOrders = new ArrayList<>();
		listOfUserOrders.addAll(inMemoryDatabase.getOrders().stream()
				.filter(order -> order.getClientId().equals(clientId)).collect(Collectors.toList()));

		if (listOfUserOrders.isEmpty()) {
			throw new NotFoundException("There is no user with id: " + clientId);
		}

		return listOfUserOrders;
	}

	/**
	 * 
	 * @param clientId
	 * @return Average price of order from particualar client
	 */
	public double getAVGOfOrderPriceFromClient(String clientId) {
		return getTotalPriceOfOrdersFromClient(clientId) / getTotalAmountOfOrdersFromClient(clientId);
	}

	/**
	 * 
	 * @param clientId
	 * @return Total price of order from particualar client
	 */
	public double getTotalPriceOfOrdersFromClient(String clientId) {
		return getUserOrders(clientId).stream().mapToDouble(order -> order.getPrice()).sum();
	}

	/**
	 * 
	 * @param clientId
	 * @return Amount of orders from particular client
	 */
	public int getTotalAmountOfOrdersFromClient(String clientId) {
		return getUserOrders(clientId).size();
	}

}
