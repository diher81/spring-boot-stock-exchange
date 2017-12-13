package com.switchfully.springboot.exchange.api;

import com.switchfully.springboot.exchange.domain.Stock;
import com.switchfully.springboot.exchange.domain.StockPrice;
import com.switchfully.springboot.exchange.service.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static com.switchfully.springboot.exchange.domain.StockCurrency.EUR;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StockExchangeControllerTest {

    /**
     * We mock the StockService.
     * The StockService can be broken,
     * it will not affect these test due to mocking.
     *
     * We can mock the StockService because we
     * applied Inversion of Control - Constructor Dependency Injection
     * on the StockExchangeController
     */
    @Mock
    private StockService stockService;

    @Test
    public void getStock_givenAStockId_thenReturnStock() {
        // GIVEN
        StockExchangeController controller = new StockExchangeController(stockService);
        Mockito.when(stockService.getStock("ABC"))
                .thenReturn(createEnrichedStock("ABC", "AyBeCe", new StockPrice(new BigDecimal(10), EUR)));

        // WHEN
        StockDto stockDto = controller.getStock("ABC");

        // THEN
        assertThat(stockDto.getId()).isEqualTo("ABC");
        assertThat(stockDto.getName()).isEqualTo("AyBeCe");
        assertThat(stockDto.getPrice()).isEqualTo(new BigDecimal(10));
        assertThat(stockDto.getCurrency()).isEqualTo(EUR.getLabel());
    }

    private Stock createEnrichedStock(String id, String name, StockPrice stockPrice) {
        Stock stock = new Stock(id, name);
        stock.setPrice(stockPrice);
        return stock;
    }

}
