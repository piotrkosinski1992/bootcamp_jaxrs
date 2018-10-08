package com.coreservices.bootcamp.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representation of orders. Class is used during marshalling/unmarshalling xml files
 *
 */
@XmlRootElement(name = "requests")
public class Orders {

	List<Order> listOfOrders;

	@XmlElement(name = "request")
	public List<Order> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}	
	
	
}
