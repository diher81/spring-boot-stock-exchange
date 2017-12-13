package com.switchfully.springboot.exchange.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.math.BigDecimal;

import static com.switchfully.springboot.exchange.domain.StockCurrency.EUR;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * By defining @RunWith with the SpringRunner, our tests will be able to get hold of the instantiated beans.
 * Which beans will be instantiated, is decided by providing @SpringBootTest with a / multiple classes.
 *      We provide it TestApplication, which is annotated with @SpringBootApplication, meaning it will go and search
 *      classes annotated with @Named (@Component).
 *
 * In other words, we're making sure a Test ApplicationContext is being created which holds the necessary beans that can
 * be accessed by the test(s) itself.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestApplication.class})
public class StockExchangeControllerIntegrationTest {

    /**
     * We don't mock, we actually wire everything up and inject the controller here.
     * The StockService will be instantiated and injected into the controller as well.
     * All required components are up and running. Therefore, this is an integration test.
     * We're testing the integration of multiple components!
     *      If the StockController OR the StockService are broken, these tests will fail
     */
    @Inject
    private StockExchangeController controller;

    @Test
    public void getStock_givenAStockId_thenReturnStock() {
        // GIVEN
        String stockId = "AA";

        // WHEN
        StockDto stockDto = controller.getStock(stockId);

        // THEN
        assertThat(stockDto.getId()).isEqualTo(stockId);
        assertThat(stockDto.getName()).isEqualTo("Ambro AN");
        assertThat(stockDto.getPrice()).isBetween(new BigDecimal(10), new BigDecimal(100));
        assertThat(stockDto.getCurrency()).isEqualTo(EUR.getLabel());
    }

}
