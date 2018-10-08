package com.coreservices.bootcamp.resources;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class OrderResourceIT {

	private int responseInteger;
	private char responseCharacter;
	private StringBuilder responseMessage = new StringBuilder();

	private final String ORDERS_URL = "http://localhost:8080/bootcamp/webapi/orders";
	private final String SUM_OF_ALL_ORDERS_URL = "http://localhost:8080/bootcamp/webapi/orders/sum";
	private final String AMOUNT_OF_ORDERS_URL = "http://localhost:8080/bootcamp/webapi/orders/amount";
	private final String AVG_PRICE_OF_ORDERS_URL = "http://localhost:8080/bootcamp/webapi/orders/avgPrice";

	@Test
	public void getOrdersTest() {
		RestAssured.given().when().get(ORDERS_URL).then().statusCode(200);
		RestAssured.given().when().get(ORDERS_URL).then().body(containsString("clientId")).body(containsString("name"))
				.body(containsString("price")).body(containsString("quantity")).body(containsString("requestId"));
	}

	@Test
	public void getTotalPriceOfOrdersTest() throws IOException {

		Response response = RestAssured.given().accept(ContentType.TEXT).get(SUM_OF_ALL_ORDERS_URL);

		InputStream responseInputStream = response.asInputStream();

		while ((responseInteger = responseInputStream.read()) != -1) {

			responseCharacter = (char) responseInteger;

			responseMessage.append(responseCharacter);
		}

		Assert.assertTrue(response.getStatusCode() == 200);
		Assert.assertTrue(responseMessage.toString().contains("Total price of all orders from database equals:"));
	}

	@Test
	public void getAmountOfOrdersTest() throws IOException {

		Response response = RestAssured.given().accept(ContentType.TEXT).get(AMOUNT_OF_ORDERS_URL);

		InputStream responseInputStream = response.asInputStream();

		while ((responseInteger = responseInputStream.read()) != -1) {

			responseCharacter = (char) responseInteger;

			responseMessage.append(responseCharacter);
		}

		Assert.assertTrue(response.getStatusCode() == 200);
		Assert.assertTrue(responseMessage.toString().contains("Total amount of all orders equals:"));
	}

	@Test
	public void getAVGPriceOfOrdersTest() throws IOException {

		Response response = RestAssured.given().accept(ContentType.TEXT).get(AVG_PRICE_OF_ORDERS_URL);

		InputStream responseInputStream = response.asInputStream();

		while ((responseInteger = responseInputStream.read()) != -1) {

			responseCharacter = (char) responseInteger;

			responseMessage.append(responseCharacter);
		}

		Assert.assertTrue(response.getStatusCode() == 200);
		Assert.assertTrue(responseMessage.toString()
				.contains("Average price of order based of all orders stored into database equals:"));
	}
}
