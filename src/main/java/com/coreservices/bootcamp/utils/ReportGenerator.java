package com.coreservices.bootcamp.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.model.Orders;

/**
 * Class responsible for generating reports
 *
 */
public class ReportGenerator {

	private static Logger LOGGER = Logger.getLogger(ReportGenerator.class.getName());
	
	private static File orderFile;
	
	/**
	 * Generates report based on operation output value 
	 * 
	 * @param message Additional message for user
	 * @param operationOutputValue Result value after operations on orders
	 * @return Path to the report file
	 */
	public static String generateReport(String message, Object operationOutputValue) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(createBlankReport());
			writer.println(message + operationOutputValue);
			writer.close();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

		return orderFile.getAbsolutePath();
	}
	
	/**
	 * Generates report as xml format based on list of orders
	 * 
	 * @param orders
	 * @return
	 */
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
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		
    	return orderFile.getAbsolutePath();
	}
	
	
	/**
	 * 
	 * @return Order directory file
	 * @throws IOException
	 */
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
