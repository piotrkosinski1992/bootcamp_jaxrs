package com.coreservices.bootcamp.bootcamp.tools;

import java.io.File;
import java.util.List;

import com.coreservices.bootcamp.bootcamp.entity.Order;




/**
 * 
 * @author Lenovo
 *	Rodzic roznych reader�w z roznych rodzaj�w plik�w
 */
public abstract class BasicOrderFileReader {


    public abstract List<Order> getOrdersFromFile(File file);
    
    public Order mapOrderLineToObject(String[] orderLine) {
        return new Order(orderLine[0], Long.parseLong(orderLine[1]), orderLine[2], Integer.parseInt(orderLine[3]), Double.parseDouble(orderLine[4]));

    }

}
