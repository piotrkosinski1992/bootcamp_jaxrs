package com.coreservices.bootcamp.bootcamp.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.coreservices.bootcamp.bootcamp.entity.Order;




/**
 * 
 * @author Lenovo
 *	
 */
public class CSVFileReader extends BasicOrderFileReader {

    private BufferedReader br = null;
    private String orderLine = "";
    private List<Order> orderList = new ArrayList<Order>();

    public List<Order> getOrdersFromFile(File csvFile){
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
}
