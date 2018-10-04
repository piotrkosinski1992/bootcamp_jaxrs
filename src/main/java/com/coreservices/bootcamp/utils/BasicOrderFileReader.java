package com.coreservices.bootcamp.utils;

import java.io.File;
import java.util.List;

import com.coreservices.bootcamp.entity.Order;
//import com.coreservices.bootcamp.entity.Request;




/**
 * 
 * @author Lenovo
 *	Rodzic roznych reader�w z roznych rodzaj�w plik�w
 */
public interface BasicOrderFileReader {

    public  List<Order> getOrderListFromFile(File file);  
}
