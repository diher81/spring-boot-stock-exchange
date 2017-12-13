package com.switchfully.springboot.exchange.domain;

public class Stock {

    private String id;
    private String name;
    private StockPrice price;

    public Stock(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setPrice(StockPrice price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StockPrice getPrice() {
        return price;
    }
}
