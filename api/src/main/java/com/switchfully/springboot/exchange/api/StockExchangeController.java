package com.switchfully.springboot.exchange.api;


import com.switchfully.springboot.exchange.domain.Stock;
import com.switchfully.springboot.exchange.service.StockService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@ResponseBody
@RequestMapping("/stocks")
public class StockExchangeController {

    private StockService stockService;

    @Inject
    public StockExchangeController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{stockId}")
    public StockDto getStock(@PathVariable String stockId) {
        Stock foundStock = stockService.getStock(stockId);
        return StockDto.toStockDto(foundStock);
    }

}
