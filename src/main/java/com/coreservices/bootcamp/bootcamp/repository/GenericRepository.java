package com.coreservices.bootcamp.bootcamp.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.coreservices.bootcamp.bootcamp.entity.Order;
import com.coreservices.bootcamp.bootcamp.tools.BasicOrderFileReader;
import com.coreservices.bootcamp.bootcamp.tools.CSVFileReader;


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
        orders = new ArrayList<Order>();
        getOrderObjectList();
    };

    private List<Order> getOrderObjectList(){

        File[] listOfOrderFiles = getOrderFiles();

        for(File file : listOfOrderFiles) {
            String fileName = file.getName();
            String extension = fileName.substring(fileName.lastIndexOf("."));
            if(extension.equals(".csv")) {
                fileReader = new CSVFileReader();
                orders.addAll(fileReader.getOrdersFromFile(file));
            } else if(extension.equals(".xml")) {
//                getOrdersFromXMLFile(file);
            }
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
