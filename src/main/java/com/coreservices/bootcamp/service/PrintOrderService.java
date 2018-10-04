package com.coreservices.bootcamp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.coreservices.bootcamp.entity.Order;
//import com.coreservices.bootcamp.entity.Request;
import com.coreservices.bootcamp.repository.GenericRepository;



/**
 * 
 * @author Lenovo
 *  
 */
public class PrintOrderService {

    private GenericRepository inMemoryDatabase;

    public PrintOrderService() {
    	inMemoryDatabase = GenericRepository.initializeDatabaseConnection();
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
      return inMemoryDatabase.getOrders().stream().filter(order -> order.getClientId().equals(clientId)).collect(Collectors.toList());
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
