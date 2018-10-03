//package com.coreservices.bootcamp.bootcamp.dao;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import com.coreservices.bootcamp.bootcamp.entity.Order;
//import com.coreservices.bootcamp.bootcamp.repository.GenericRepository;
//
//
//
///**
// * 
// * @author Lenovo
// * 
// */
//public class OrderDAO {
//
//
//
//
//    public int getAmountOfOrdersByClientId(String clientId) {
//    	
//    	return getListOfOrdersByClientId(clientId).size();
//    }
//
//
//
//    public double getSumOfOrdersByClientId(String clientId) {
//    	double sumOfClientOrders = 0;
//    	
//    	List<Order> clientOrderList = getListOfOrdersByClientId(clientId);
//
//    	for(Order order : clientOrderList) {
//    		sumOfClientOrders += order.getPrice();
//    	}
//    	
//        return sumOfClientOrders;
//    }
//
//
//
//    public List<Order> getListOfOrdersByClientId(String clientId) {
//        return genericRepository.getOrders().stream().filter(order -> order.getClientId().equals(clientId)).collect(Collectors.toList());
//    }
//
//
//    public double getAVGPriceOfOrdersByClientId(String clientId){
//        return getSumOfOrdersByClientId(clientId)/getAmountOfOrdersByClientId(clientId);
//    }
//
//}
