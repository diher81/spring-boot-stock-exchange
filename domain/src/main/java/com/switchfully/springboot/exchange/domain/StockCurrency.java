package com.switchfully.springboot.exchange.domain;

public enum StockCurrency {

    EUR("Euro", "€"),
    USD("U.S. Dollar", "$"),
    GBP("British Pond", "£");

    private final String label;
    private final String symbol;

    StockCurrency(String label, String symbol) {
        this.label = label;
        this.symbol = symbol;
    }

    public String getLabel() {
        return label;
    }

    public String getSymbol() {
        return symbol;
    }
}
