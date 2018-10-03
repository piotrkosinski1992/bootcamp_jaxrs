package com.coreservices.bootcamp.bootcamp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.coreservices.bootcamp.bootcamp.service.OrderService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("orders")
public class OrdersResource {

	private OrderService orderService = new OrderService();
	

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
        return orderService.printAllOrdersNowy();
    }
}
