package com.coreservices.bootcamp.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.repository.OrderRepository;

public class OrderServiceTest {

	private List<Order> orders = new ArrayList<>();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@InjectMocks
	PrintOrderService orderService;	
	
	@Mock
	OrderRepository orderRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		

		orders.add(new Order("1",1L, "bulka", 22, 20.00));
		orders.add(new Order("1",1L, "bulka2", 322, 40.00));
		orders.add(new Order("2",1L, "bulka3", 122, 60.00));
		
		when(orderRepository.getOrders()).thenReturn(orders);
	}
	
	@Test
	public void getOrdersTest() {		
		Assert.assertTrue(orderService.getOrders().size() == 3);
	}
	
	@Test
	public void getTotalAmountOfOrdersTest() {
		Assert.assertTrue(orderService.getTotalAmountOfOrders() == 3);
	}
	
	@Test
	public void getTotalPriceOfOrdersTest() {
		Assert.assertEquals(120.00, orderService.getTotalPriceOfOrders(), 0);
	}
	
	@Test
	public void getAVGOfOrderPriceTest() {
		Assert.assertTrue(orderService.getAVGOfOrderPrice() == 40.00);
	}
	
	@Test
	public void getUserOrdersTest() {
		Assert.assertTrue(orderService.getUserOrders("2").size() == 1);
		Assert.assertTrue(orderService.getUserOrders("1").size() == 2);
		
		thrown.expect(NotFoundException.class);
		orderService.getUserOrders("111");
	}
	
	@Test
	public void getAVGOfOrderPriceFromClientTest() {
		Assert.assertTrue(orderService.getAVGOfOrderPriceFromClient("1") == 30.00);
		Assert.assertTrue(orderService.getAVGOfOrderPriceFromClient("2") == 60.00);
	}
	
	@Test
	public void getTotalPriceOfOrdersFromClientTest() {
		Assert.assertTrue(orderService.getTotalPriceOfOrdersFromClient("1") == 60.00);
		Assert.assertTrue(orderService.getTotalPriceOfOrdersFromClient("2") == 60.00);
		
		thrown.expect(NotFoundException.class);
		orderService.getTotalPriceOfOrdersFromClient("22");
	}
	
	@Test
	public void getTotalAmountOfOrdersFromClientTest() {
		Assert.assertTrue(orderService.getTotalAmountOfOrdersFromClient("1") == 2);
		Assert.assertTrue(orderService.getTotalAmountOfOrdersFromClient("2") == 1);
		
		thrown.expect(NotFoundException.class);
		orderService.getTotalAmountOfOrdersFromClient("22");	
	}
	
}
