package com.coreservices.bootcamp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.repository.OrderRepository;



/**
 * 
 * @author Lenovo
 *  
 */
public class PrintOrderService {

    private OrderRepository inMemoryDatabase;

    public PrintOrderService() {
    	inMemoryDatabase = OrderRepository.getDatabaseInstance();
    }
  
    
    public List<Order> getOrders() {
    	return inMemoryDatabase.getOrders();
    }
    
    public int getTotalAmountOfOrders() {
        return inMemoryDatabase.getOrders().size();
    }
    
    public double getTotalPriceOfOrders() {
        return inMemoryDatabase.getOrders().stream().mapToDouble(order -> order.getPrice()).sum();
    }
    
    public double getAVGOfOrderPrice() {
        return getTotalPriceOfOrders()/getTotalAmountOfOrders();
    }

	public List<Order> getUserOrders(String clientId) {
		List <Order> listOfUserOrders = new ArrayList<>();
		listOfUserOrders.addAll(inMemoryDatabase.getOrders().stream().filter(order -> order.getClientId().equals(clientId)).collect(Collectors.toList()));
		
		if(listOfUserOrders.isEmpty()) {
			throw new NotFoundException("There is no user with id: " + clientId);
		}
		
      return listOfUserOrders;
	}

	public double getAVGOfOrderPriceFromClient(String clientId) {
		return getTotalPriceOfOrdersFromClient(clientId)/getTotalAmountOfOrdersFromClient(clientId);		
	}

	public double getTotalPriceOfOrdersFromClient(String clientId) {
		return getUserOrders(clientId).stream().mapToDouble(order -> order.getPrice()).sum();
	}

	public int getTotalAmountOfOrdersFromClient(String clientId) {
		return getUserOrders(clientId).size();
	}
    
}
