package com.coreservices.bootcamp.bootcamp.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.coreservices.bootcamp.bootcamp.entity.Order;
import com.coreservices.bootcamp.bootcamp.service.OrderService;

@Path("/orders")
public class PrintOrderResource {

	private OrderService orderService = new OrderService();
	

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
    
    @GET
    @Path("/client/{clientId}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> getUserOrders(@PathParam("clientId") String clientId ) {
        return orderService.getUserOrders(clientId);
    }
          
    @GET
    @Path("/amount")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTotalAmountOfOrders() {
    	
        return "Total amount of orders: " + orderService.getTotalAmountOfOrders();
    }
   
    @GET
    @Path("/client/amount/{clientId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAmountOfOrdersFromClient(@PathParam("clientId") String clientId) {
    	
        return "Total amount of orders: " + orderService.getTotalAmountOfOrdersFromClient(clientId);
    }
    
    @GET
    @Path("/sum")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTotalPriceOfOrders() {
    	
        return "Total price of orders: " + orderService.getTotalPriceOfOrders();
    }
    
    @GET
    @Path("client/sum/{clientId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTotalPriceOfOrdersFromClient(@PathParam("clientId") String clientId) {
    	
        return "Total price of orders from client: " + orderService.getTotalPriceOfOrdersFromClient(clientId);
    }
    
    @GET
    @Path("/avgPrice")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAVGOfOrderPrice() {
    	
        return "Total AVG of orders: " + orderService.getAVGOfOrderPrice();
    }
    
    @GET
    @Path("client/avg/{clientId}")
    @Produces(MediaType.TEXT_XML)
    public String getAVGOfOrderPriceFromClient(@PathParam("clientId") String clientId ) {
        return "Average order price for client: " + clientId + " equals: " + orderService.getAVGOfOrderPriceFromClient(clientId);
    }
    
    
}


