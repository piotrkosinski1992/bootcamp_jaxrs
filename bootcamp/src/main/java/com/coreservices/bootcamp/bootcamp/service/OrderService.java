package com.coreservices.bootcamp.bootcamp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.coreservices.bootcamp.bootcamp.dao.OrderDAO;
import com.coreservices.bootcamp.bootcamp.entity.Order;



/**
 * 
 * @author Lenovo
 *  
 */
public class OrderService {

	
    private OrderDAO orderDAO;
    private Scanner sc;

    public OrderService() {
        orderDAO = new OrderDAO();
    }


//    public static OrderService initializeOrderService() {
//    	if(orderService == null) {
//    		return new OrderService();
//    	}
//        return orderService;
//    }

    
    
    public void printAllOrders() {
        for(Order order : orderDAO.getListOfAllOrders()) {
            System.out.println(order.toString());
        }
    }
    
    
    public String printAllOrdersNowy() {
    	List<Order> listOfOrders = new ArrayList<>();
        for(Order order : orderDAO.getListOfAllOrders()) {
        	listOfOrders.add(order);
        }
        return listOfOrders.toString();
    }
    
    
    
    public void printSumOfClientOrders() {
        sc = new Scanner(System.in);
        System.out.println("Pick user id: ");
        
        System.out.println("sum of user orders: " + orderDAO.getSumOfOrdersByClientId(sc.nextLine()));
    }

    public void printTotalSumOfAllOrders() {
        System.out.println("Sum (Cena) of All orders equals: " + orderDAO.getTotalSumOfAllOrders());
    }

    public void printAVGPriceOfAllOrders() {
        System.out.println("AVG of All orders equals: " + orderDAO.getAVGPriceOfAllOrders());
    }

    public void printTotalAmountOfOrders() {
        System.out.println("Ammount (Ilosc) of All orders equals: " + orderDAO.getTotalAmountOfOrders());
    }

    public void  printListOfOrdersByClientId() {

        sc = new Scanner(System.in);
        System.out.println("Pick user id: ");


        for(Order order : orderDAO.getListOfOrdersByClientId(sc.nextLine())) {
            System.out.println(order.toString());
        }
    }

    public void printAmountOfOrdersByClientId() {
        sc = new Scanner(System.in);
        System.out.println("Pick user id: ");
        
        System.out.println("amount (ilosc) of user orders: " + orderDAO.getAmountOfOrdersByClientId(sc.nextLine()));
    }
    
    public void getAVGPriceOfOrdersByClientId() {
        sc = new Scanner(System.in);
        System.out.println("Pick user id: ");
        
        System.out.println("AVG price of user orders: " + orderDAO.getAVGPriceOfOrdersByClientId(sc.nextLine()));
    }



}
