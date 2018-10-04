package com.coreservices.bootcamp.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.utils.BasicOrderFileReader;
import com.coreservices.bootcamp.utils.CSVFileReader;
import com.coreservices.bootcamp.utils.XMLFileReader;


/**
 * 
 * @author Lenovo
 *	
 */
public class GenericRepository {


	private static GenericRepository genericRepository;
    private final String ORDERS_DIRECTORY = "orders";
    private BasicOrderFileReader fileReader;

    private List<Order> orders;

    /**
     *  gdzie inicjalizować arraylistę? W konstruktorze a może od razu przy zmniennej. Czemu w konstrukturze :D?
     *  odpalam tu podczas inicjalizacji getOrderObjectList() zeby zainicjalizować pozyskanie danych z plików
     */
    private GenericRepository(){
        orders = new ArrayList<>();
        getOrderObjectList();
    };

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

    private File[] getOrderFiles() {
    	File folder = new File(getClass().getClassLoader().getResource(ORDERS_DIRECTORY).getPath());

        return folder.listFiles();
    }

    public static GenericRepository initializeDatabaseConnection(){
    	if(genericRepository == null) {
    		return new GenericRepository();
    	}
    	return genericRepository;
    }

    public List<Order> getOrders() {
        return orders;
    }


}
