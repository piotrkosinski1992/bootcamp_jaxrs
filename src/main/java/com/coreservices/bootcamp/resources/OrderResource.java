package com.coreservices.bootcamp.resources;

import static com.coreservices.bootcamp.utils.MessageCentrer.AMOUNT_ORDERS_FROM_CLIENT_MESSAGE;
import static com.coreservices.bootcamp.utils.MessageCentrer.AMOUNT_ORDERS_MESSAGE;
import static com.coreservices.bootcamp.utils.MessageCentrer.AVG_PRICE_ORDERS_FROM_CLIENT_MESSAGE;
import static com.coreservices.bootcamp.utils.MessageCentrer.AVG_PRICE_ORDERS_MESSAGE;
import static com.coreservices.bootcamp.utils.MessageCentrer.GENERATED_REPORT_MESSAGE;
import static com.coreservices.bootcamp.utils.MessageCentrer.PRICE_CLIENT_ORDERS_MESSAGE;
import static com.coreservices.bootcamp.utils.MessageCentrer.PRICE_OF_ORDERS_MESSAGE;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.coreservices.bootcamp.model.Order;
import com.coreservices.bootcamp.service.PrintOrderService;
import com.coreservices.bootcamp.service.ReportOrderService;

/**
 * Class receives http requests and based of request proceeds appropriate
 * methods
 */
@Path("/orders")
public class OrderResource {

	private PrintOrderService printOrderService = new PrintOrderService();
	private ReportOrderService reportOrderService = new ReportOrderService();

	/**
	 * 
	 * @return Order list as xml format
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Order> getOrders() {
		return printOrderService.getOrders();
	}

	/**
	 * 
	 * @param clientId 
	 * @return Orders from particular user as xml format
	 */
	@GET
	@Path("/client/{clientId}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Order> getUserOrders(@PathParam("clientId") String clientId) {
		return printOrderService.getUserOrders(clientId);
	}

	/**
	 * 
	 * @param generateReport Boolean that decides if report will be generated
	 * @return Total amount of orders
	 */
	@GET
	@Path("/amount")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTotalAmountOfOrders(@QueryParam("generateReport") boolean generateReport) {

		if (generateReport) {
			String orderReportDir = reportOrderService.generateReport(AMOUNT_ORDERS_MESSAGE,
					printOrderService.getTotalAmountOfOrders());
			return GENERATED_REPORT_MESSAGE + orderReportDir;
		}

		return AMOUNT_ORDERS_MESSAGE + printOrderService.getTotalAmountOfOrders();
	}

	/**
	 * 
	 * @param generateReport Boolean that decides if report will be generated
	 * @param clientId
	 * @return Amount of orders from particular client
	 */
	@GET
	@Path("/client/amount/{clientId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAmountOfOrdersFromClient(@QueryParam("generateReport") boolean generateReport,
			@PathParam("clientId") String clientId) {

		if (generateReport) {
			String orderReportDir = reportOrderService.generateReport(AMOUNT_ORDERS_FROM_CLIENT_MESSAGE,
					printOrderService.getTotalAmountOfOrdersFromClient(clientId));
			return GENERATED_REPORT_MESSAGE + orderReportDir;
		}

		return AMOUNT_ORDERS_FROM_CLIENT_MESSAGE + printOrderService.getTotalAmountOfOrdersFromClient(clientId);
	}

	/**
	 * 
	 * @param generateReport Boolean that decides if report will be generated
	 * @return Total price of all orders
	 */
	@GET
	@Path("/sum")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTotalPriceOfOrders(@QueryParam("generateReport") boolean generateReport) {

		if (generateReport) {
			String orderReportDir = reportOrderService.generateReport(PRICE_OF_ORDERS_MESSAGE,
					printOrderService.getTotalPriceOfOrders());
			return GENERATED_REPORT_MESSAGE + orderReportDir;
		}

		return PRICE_OF_ORDERS_MESSAGE + printOrderService.getTotalPriceOfOrders();
	}

	/**
	 * 
	 * @param generateReport Boolean that decides if report will be generated
	 * @param clientId
	 * @return Total price of orders from particular user
	 */
	@GET
	@Path("client/sum/{clientId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTotalPriceOfOrdersFromClient(@QueryParam("generateReport") boolean generateReport,
			@PathParam("clientId") String clientId) {

		if (generateReport) {
			String orderReportDir = reportOrderService.generateReport(PRICE_CLIENT_ORDERS_MESSAGE,
					printOrderService.getTotalPriceOfOrdersFromClient(clientId));
			return GENERATED_REPORT_MESSAGE + orderReportDir;
		}

		return PRICE_CLIENT_ORDERS_MESSAGE + printOrderService.getTotalPriceOfOrdersFromClient(clientId);
	}

	/** 
	 * 
	 * @param generateReport Boolean that decides if report will be generated
	 * @return Average price from all orders
	 */
	@GET
	@Path("/avgPrice")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAVGOfOrderPrice(@QueryParam("generateReport") boolean generateReport) {

		if (generateReport) {
			String orderReportDir = reportOrderService.generateReport(AVG_PRICE_ORDERS_MESSAGE,
					printOrderService.getAVGOfOrderPrice());
			return GENERATED_REPORT_MESSAGE + orderReportDir;
		}

		return AVG_PRICE_ORDERS_MESSAGE + printOrderService.getAVGOfOrderPrice();
	}

	/**
	 * 
	 * @param generateReport Boolean that decides if report will be generated
	 * @param clientId
	 * @return Average price of orders from particular client
	 */
	@GET
	@Path("client/avg/{clientId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAVGOfOrderPriceFromClient(@QueryParam("generateReport") boolean generateReport,
			@PathParam("clientId") String clientId) {

		if (generateReport) {
			String orderReportDir = reportOrderService.generateReport(AVG_PRICE_ORDERS_FROM_CLIENT_MESSAGE,
					printOrderService.getAVGOfOrderPriceFromClient(clientId));
			return GENERATED_REPORT_MESSAGE + orderReportDir;
		}

		return AVG_PRICE_ORDERS_FROM_CLIENT_MESSAGE + printOrderService.getAVGOfOrderPriceFromClient(clientId);
	}

	/**
	 * Generates report with all orders
	 * 
	 * @return Info about path where report is stored
	 */
	@GET
	@Path("/report")
	@Produces(MediaType.TEXT_PLAIN)
	public String generateUsersOrdersReport() {

		String orderReportDir = reportOrderService.generateReport(printOrderService.getOrders());
		return GENERATED_REPORT_MESSAGE + orderReportDir;
	}

	/**
	 * Generates report with orders from particular user
	 * 
	 * @param clientId
	 * @return Info about path where report is stored
	 */
	@GET
	@Path("/client/{clientId}/report")
	@Produces(MediaType.TEXT_PLAIN)
	public String generateUserOrdersReport(@PathParam("clientId") String clientId) {

		String orderReportDir = reportOrderService.generateReport(printOrderService.getUserOrders(clientId));
		return GENERATED_REPORT_MESSAGE + orderReportDir;
	}

}
