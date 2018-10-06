package com.coreservices.bootcamp.utils;

import static com.coreservices.bootcamp.utils.WarningsCenter.*;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    	List<Order> filteredOrders = new ArrayList<>();
		try {
			jaxbContext = JAXBContext.newInstance(Orders.class);
	    	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    	Orders orders = (Orders) jaxbUnmarshaller.unmarshal(file);
	    	
	    	if(!(orders.getListOfOrders() == null)) {
	    		filteredOrders = orders.getListOfOrders().stream()
						 .filter(order -> OrderValidator.isOrderValid(order))
						 .collect(Collectors.toList());
	    	} else {
	    		System.err.println(MessageFormat.format(FILE_WITHOUT_ORDERS_WARN, file.getName()));
	    	}

	    	return filteredOrders;
		} catch (JAXBException e) {
			e.printStackTrace();
		}

        return new ArrayList<>();
    }
}
