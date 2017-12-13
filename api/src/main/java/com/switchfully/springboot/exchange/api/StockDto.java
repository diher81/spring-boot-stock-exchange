package com.switchfully.springboot.exchange.api;

import com.switchfully.springboot.exchange.domain.Stock;

import java.math.BigDecimal;

public class StockDto {

    private String id;
    private String name;
    private BigDecimal price;
    private String currency;

    private StockDto(String id, String name, BigDecimal price, String currency) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    static StockDto toStockDto(Stock stock) {
        return new StockDto(
                stock.getId(),
                stock.getName(),
                stock.getPrice() != null ? stock.getPrice().getPrice() : new BigDecimal(0),
                stock.getPrice() != null ? stock.getPrice().getCurrency().getLabel() : "Unknown");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
