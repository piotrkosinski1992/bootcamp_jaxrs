package com.coreservices.bootcamp.utils;


/**
 * Here are stored warnings, that are displayed, when there is incorrect order inside order file
 *
 */
public class WarningsCenter {
	
	public static final String ORDER_INFO_NOT_COMPLETE_WARN = "Current order will be removed from order list - not enough data: ";
	
	public static final String CLIENTID_WHITESPACES_WARN = "clientId {0} contains whitespaces. Order will be deleted from order list";
	
	public static final String CLIENTID_TO_MANY_SIGNS_WARN = "clientId {0} contains more than 6 signs. Order will be deleted from order list";
	
	public static final String REQUESTID_WRONG_FORMAT_WARN = "requestId: {0} is not type long. Order will be deleted from order list";
	
	public static final String NAME_TOO_LONG_WARN = "name: {0} is longer than 255 signs. Order will be deleted from order list";
	
	public static final String QUANTITY_WRONG_FORMAT_WARN = "quantity: {0} is not type integer. Order will be deleted from order list";
	
	public static final String PRICE_TO_MANY_DECIMAL_NUMBERS = "Price: {0} has more than 2 numbers after decimal point. Order will be deleted from order list";
			
	public static final String PRICE_WRONG_FORMAT_WARN =  "Price: {0} is not type double. Order will be deleted from order list";
	
	public static final String FILE_WITHOUT_ORDERS_WARN = "file: {0} contains no orders";

}
