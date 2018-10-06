package com.coreservices.bootcamp.utils;

import static com.coreservices.bootcamp.utils.WarningsCenter.*;

import java.text.MessageFormat;
import java.util.Arrays;

import com.coreservices.bootcamp.model.Order;

public class OrderValidator {

	
	public static boolean isOrderValid(String[] order) {
		
		if(order.length < 5) {
			System.err.println(ORDER_INFO_NOT_COMPLETE_WARN + Arrays.toString(order));
			return false;
		}
		
		return isClientIdValid(order[0]) && isRequestIdValid(order[1]) && isNameValid(order[2]) && isQuantityValid(order[3]) && isPriceValid(order[4]);
	}
	
	
	public static boolean isOrderValid(Order order) {
		
		if(hasNullParameters(order)) {
			System.err.println(ORDER_INFO_NOT_COMPLETE_WARN + order.toString());
			return false;
		}
		
		return true;
	}
	
	private static boolean isClientIdValid(String clientId) {

		if(clientId.contains(" ")) {
			System.err.println(MessageFormat.format(CLIENTID_WHITESPACES_WARN, clientId));
			return false;
		} else if(clientId.length() > 6) {
			System.err.println(MessageFormat.format(CLIENTID_TO_MANY_SIGNS_WARN, clientId));
			return false;
		}
		return  true;
	}
	
	private static boolean isRequestIdValid(String requestId) {
		
		try {
			Long.parseLong(requestId);
		} catch(NumberFormatException ex) {
			System.err.println(MessageFormat.format(REQUESTID_WRONG_FORMAT_WARN, requestId));
			return false;
		}
		
		return true;
	}
		
	private static boolean isNameValid(String name) {
		if(name.length() > 255) {
			System.err.println(MessageFormat.format(NAME_TOO_LONG_WARN, name));
			return false;
		}
		return true;
	}
	
	private static boolean isQuantityValid(String quantity) {
		try {
			Integer.parseInt(quantity);
		} catch(NumberFormatException ex) {
			System.err.println(MessageFormat.format(QUANTITY_WRONG_FORMAT_WARN, quantity));
			return false;
		}
		
		return true;
	}
	
	private static boolean isPriceValid(String price) {	
		try {
			Double.parseDouble(price);
			
			int amountOfNumbersAfterDecimal = price.substring(price.indexOf(".") + 1).trim().length();
			
			if(amountOfNumbersAfterDecimal > 2) {
				System.err.println(MessageFormat.format(PRICE_TO_MANY_DECIMAL_NUMBERS, price));
				return false;
			}
			
			
		} catch(NumberFormatException ex) {
			System.err.println(MessageFormat.format(PRICE_WRONG_FORMAT_WARN, price));
			return false;
		}

		return true;
	}
	
	private static boolean isPriceValid(double price) {
		
		int amountOfNumbersAfterDecimal = String.valueOf(price).substring(String.valueOf(price).indexOf(".") + 1).trim().length();
		
		if(amountOfNumbersAfterDecimal > 2) {
			System.err.println(MessageFormat.format(PRICE_TO_MANY_DECIMAL_NUMBERS, price));
			return true;
		}
		return false;
	}
	
	
    private static boolean hasNullParameters(Order order) {
    	return order.getClientId() == null || order.getName() == null || order.getPrice() == 0 || order.getQuantity() == 0 || order.getRequestId() == null;
    }

}
