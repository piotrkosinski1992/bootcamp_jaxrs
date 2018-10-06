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
 * 
 * @author Lenovo
 *	
 */
public class OrderRepository {

	private static OrderRepository orderRepository;
    private final String ORDERS_DIRECTORY = "orders";
    private BasicOrderFileReader fileReader;

    private List<Order> orders;

    private OrderRepository(){
        orders = new ArrayList<>();
        getOrderObjectList();
    };

    /**
     * Converts order files to java objects
     * 
     * @return
     */
    private List<Order> getOrderObjectList(){

        for(File file : getOrderFiles()) {
            String fileName = file.getName();
            String extension = fileName.substring(fileName.lastIndexOf("."));
            if(extension.equals(".csv")) {
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
     * @return
     */
	public File[] getOrderFiles() {
    	File folder = new File(getClass().getClassLoader().getResource(ORDERS_DIRECTORY).getPath());

        return folder.listFiles();
    }

	/**
	 * Gets singleton instance of a class
	 * 
	 * @return
	 */
    public static OrderRepository getDatabaseInstance(){
    	if(orderRepository == null) {
    		orderRepository = new OrderRepository();
    		return orderRepository;
    	}
    	return orderRepository;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
