package com.coreservices.bootcamp.bootcamp.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {


    //Dodac wielkosc kontenerow
    private String clientId;
    private Long requestId;
    private String name;
    private int quantity;
    private double price;


    public Order(String clientId, Long requestId, String name, int quantity, double price) {
        super();
        this.clientId = clientId;
        this.requestId = requestId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    // JaxB required
    public Order() {
    	
    }

    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public Long getRequestId() {
        return requestId;
    }
    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order [clientId=" + clientId + ", requestId=" + requestId + ", name=" + name + ", quantity=" + quantity
                + ", price=" + price + "]";
    }


}
