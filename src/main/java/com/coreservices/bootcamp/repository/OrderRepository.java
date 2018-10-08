package com.coreservices.bootcamp.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.utils.BasicOrderFileReader;
import com.coreservices.bootcamp.utils.CSVFileReader;
import com.coreservices.bootcamp.utils.XMLFileReader;


/**
 * Representation of InMemory database. Singleton class gets and stores all orders from files
 */
public class OrderRepository {

	/**
	 * Place to store singleton instance
	 */
	private static OrderRepository orderRepository;
	
	/**
	 * Directory where orders are stored
	 */
    private static String ordersDirectory = "orders";
    
    /**
     * Helper class to read files
     */
    private BasicOrderFileReader fileReader;
    
    /**
     * List of orders from order files
     */
    private List<Order> orders;

    private OrderRepository() {
        orders = new ArrayList<>();
        getOrderObjectList();
    };

    /**
     * Converts order files to java objects
     * 
     * @return List of orders
     */
    private List<Order> getOrderObjectList() {

        for(File file : getOrderFiles(ordersDirectory)) {
            String fileName = file.getName();
            String extension = fileName.substring(fileName.lastIndexOf("."));
            if (extension.equals(".csv")) {
                fileReader = new CSVFileReader();
                orders.addAll(fileReader.getOrderListFromFile(file));
            } else if(extension.equals(".xml")) {
            	fileReader = new XMLFileReader();
            	orders.addAll(fileReader.getOrderListFromFile(file));
            }
        }
        
        if(orders.isEmpty()) {
        	throw new NotFoundException("There is no orders in Inmemory Database");
        }
             
        return orders;
    }

    /**
     * Gets order files from orders directory
     * 
     * @return List of order files
     */
	private File[] getOrderFiles(String orderDirectory) {
    	File folder = new File(getClass().getClassLoader().getResource(orderDirectory).getPath());

        return folder.listFiles();
    }

	/**
	 * 
	 * @return Singleton instance of class
	 */
    public static OrderRepository getDatabaseInstance() {
    	if(orderRepository == null) {
    		orderRepository = new OrderRepository();
    		return orderRepository;
    	}
    	return orderRepository;
    }

    /**
     * 
     * @return List of orders
     */
    public List<Order> getOrders() {
        return orders;
    }

	public static void setOrdersDirectory(String ordersDirectory) {
		OrderRepository.ordersDirectory = ordersDirectory;
	}
        
}
