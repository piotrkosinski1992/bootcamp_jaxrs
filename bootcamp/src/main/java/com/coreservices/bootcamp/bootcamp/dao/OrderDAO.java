package com.coreservices.bootcamp.bootcamp.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.coreservices.bootcamp.bootcamp.entity.Order;
import com.coreservices.bootcamp.bootcamp.repository.GenericRepository;



/**
 * 
 * @author Lenovo
 * 
 */
public class OrderDAO {

    private GenericRepository genericRepository;

    public OrderDAO() {
        genericRepository = new GenericRepository();
    }

    
    public int getTotalAmountOfOrders() {
        return genericRepository.getOrders().size();
    }


    public int getAmountOfOrdersByClientId(String clientId) {
    	
    	return getListOfOrdersByClientId(clientId).size();
    }

    public double getTotalSumOfAllOrders() {
        int totalSumOfOrders = 0;

        for(Order order : genericRepository.getOrders()) {
            totalSumOfOrders += order.getPrice();
        }

        return totalSumOfOrders;
    }

    public double getSumOfOrdersByClientId(String clientId) {
    	double sumOfClientOrders = 0;
    	
    	List<Order> clientOrderList = getListOfOrdersByClientId(clientId);

    	for(Order order : clientOrderList) {
    		sumOfClientOrders += order.getPrice();
    	}
    	
        return sumOfClientOrders;
    }

    public List<Order> getListOfAllOrders() {
        return genericRepository.getOrders();
    }

    public List<Order> getListOfOrdersByClientId(String clientId) {
        return genericRepository.getOrders().stream().filter(order -> order.getClientId().equals(clientId)).collect(Collectors.toList());
    }

    public double getAVGPriceOfAllOrders(){
        return getTotalSumOfAllOrders()/getTotalAmountOfOrders();
    }

    public double getAVGPriceOfOrdersByClientId(String clientId){
        return getSumOfOrdersByClientId(clientId)/getAmountOfOrdersByClientId(clientId);
    }

}
