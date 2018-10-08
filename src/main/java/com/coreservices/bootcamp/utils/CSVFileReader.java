package com.coreservices.bootcamp.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.coreservices.bootcamp.model.Order;

/**
 * Class generates list of orders based on csv files
 */
public class CSVFileReader implements BasicOrderFileReader {

	private static Logger LOGGER = Logger.getLogger(CSVFileReader.class.getName());
	
    private BufferedReader br = null;
    private String orderLine = "";
    
    /**
     * Converts csv files to order classes 
     * 
     * @return list of orders
     */
    public List<Order> getOrderListFromFile(File csvFile) {
    	List<Order> orderList = new ArrayList<>();
        int lineNumber = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((orderLine = br.readLine()) != null) {

                String[] order = orderLine.split(",");

                if(lineNumber != 0 && OrderValidator.isOrderValid(order)) {
                    orderList.add(mapOrderLineToObject(order));
                }
                lineNumber++;
            }

        } catch (FileNotFoundException e) {
        	LOGGER.warning(e.getMessage());
        } catch (IOException e) {
        	LOGGER.warning(e.getMessage());
        }
        return orderList;
    }
    
    
    /**
     * Mapps order table into order class
     * 
     * @param orderLine
     * @return mapped order
     */
    private Order mapOrderLineToObject(String[] orderLine) {
        return new Order(orderLine[0], Long.parseLong(orderLine[1]), orderLine[2], Integer.parseInt(orderLine[3]), Double.parseDouble(orderLine[4]));
    }
}
