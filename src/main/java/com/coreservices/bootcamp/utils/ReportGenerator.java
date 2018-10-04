package com.coreservices.bootcamp.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.model.Orders;


public class ReportGenerator {

	private static File orderFile;
	
	public static String generateReport(String message, Object value) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(createBlankReport());
			writer.println(message + value);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return orderFile.getAbsolutePath();
	}
	
	public static String generateReport(List<Order> orders) {
		
		//prepare ordersObject to marshall
    	Orders ordersObject = new Orders();
    	ordersObject.setListOfOrders(orders);
    	
		try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);        
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
  
	        //Marshal the Orders list in file
	        jaxbMarshaller.marshal(ordersObject, createBlankReport());
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    	return orderFile.getAbsolutePath();
	}
	
	
	private static File createBlankReport() throws IOException {
		File directory = new File("reports");
		
		if(!directory.exists()) {
			directory.mkdirs();
		}
		
		orderFile = new File(directory.getAbsolutePath() +"/report_" + System.currentTimeMillis() + ".txt");
		orderFile.createNewFile();
		
		return orderFile;
	}
}
