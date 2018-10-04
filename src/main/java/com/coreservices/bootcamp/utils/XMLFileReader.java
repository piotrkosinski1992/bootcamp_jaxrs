package com.coreservices.bootcamp.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.model.Orders;


/**
 * 
 * @author Lenovo
 *	Klasa do odczytywania zam�wie� z plik�w xml
 */
public class XMLFileReader implements BasicOrderFileReader{

    public List<Order> getOrderListFromFile(File file) {
    	
    	JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Orders.class);
	    	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    	Orders orders = (Orders) jaxbUnmarshaller.unmarshal(file);
	    	return orders.getListOfOrders();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

        return new ArrayList<>();
    }
}
