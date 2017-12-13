package com.switchfully.springboot.exchange.interfaces;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;

public class ExternalStockInformationService {

    /**
     * This method calls an external service that has live data on the price of a stock
     * It's the interface to that external service / system.
     * (not really, but just imagine it is)
     */
    public static BigDecimal getPriceInEuroForStock(String stockId) {
        return new BigDecimal(RandomUtils.nextDouble(10, 100));
    }

}
