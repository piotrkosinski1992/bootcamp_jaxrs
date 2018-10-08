package com.coreservices.bootcamp.utils;

import java.io.File;
import java.util.List;

import com.coreservices.bootcamp.model.Order;

/*
 * 
 * FileReader intefrace
 */
public interface BasicOrderFileReader {

    public  List<Order> getOrderListFromFile(File file);  
}
