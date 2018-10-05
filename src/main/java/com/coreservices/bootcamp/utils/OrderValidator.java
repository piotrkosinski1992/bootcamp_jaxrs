package com.coreservices.bootcamp.utils;

import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

public class OrderValidator {

	
	public static boolean isOrderValid(String[] order) {
		
		if(order.length < 5) {
			System.err.println("Current order will be removed from order list - not enough data: " + Arrays.toString(order));
			return false;
		}
		
		return isClientIdValid(order[0]) && isRequestIdValid(order[1]) && isNameValid(order[2]) && isQuantityValid(order[3]) && isPriceValid(order[4]);
	}
	
	
	private static boolean isClientIdValid(String clientId) {

		if(clientId.contains(" ")) {
			System.err.println("clientId " + clientId + " contains whitespaces. Order will be deleted from order list");
			return false;
		} else if(clientId.length() > 6) {
			System.err.println("clientId " + clientId + " contains more than 6 signs. Order will be deleted from order list");
			return false;
		}
		return  true;
	}
	
	private static boolean isRequestIdValid(String requestId) {
		
		try {
			Long.parseLong(requestId);
		} catch(NumberFormatException ex) {
			System.err.println("requestId: " + requestId + " is not type long. Order will be deleted from order list");
			return false;
		}
		
		return true;
	}
	
	private static boolean isNameValid(String name) {
		if(name.length() > 255) {
			System.err.println("name: " + name + " is longer than 255 signs. Order will be deleted from order list");
			return false;
		}
		return true;
	}
	
	private static boolean isQuantityValid(String quantity) {
		try {
			Integer.parseInt(quantity);
		} catch(NumberFormatException ex) {
			System.err.println("requestId: " + quantity + " is not type integer. Order will be deleted from order list");
			return false;
		}
		
		return true;
	}
	
	private static boolean isPriceValid(String price) {
//		String a = price;
//
//		TODO count numbers of bigdecimal Locale or substring. Consider not integer in other methods too
//		
//		if(priceBigDecimal.scale() > 2) {
//			System.err.println("price: " + price + " has to many numbers after decimal. Order will be deleted from order list");
//			return false;
//		}

		return true;
	}

}
