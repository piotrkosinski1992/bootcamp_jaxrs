package com.coreservices.bootcamp.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.coreservices.bootcamp.model.Order;

/**
 * 
 * @author Lenovo
 *	
 */
public class CSVFileReader implements BasicOrderFileReader {

    private BufferedReader br = null;
    private String orderLine = "";
    private List<Order> orderList = new ArrayList<>();

    public List<Order> getOrderListFromFile(File csvFile){
        int lineNumber = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((orderLine = br.readLine()) != null) {

                String[] order = orderLine.split(",");

                if(lineNumber != 0) {
                    orderList.add(mapOrderLineToObject(order));
                }
                lineNumber++;
            }

        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return orderList;

    }
    
    private Order mapOrderLineToObject(String[] orderLine) {
        return new Order(orderLine[0], Long.parseLong(orderLine[1]), orderLine[2], Integer.parseInt(orderLine[3]), Double.parseDouble(orderLine[4]));
    }
}
