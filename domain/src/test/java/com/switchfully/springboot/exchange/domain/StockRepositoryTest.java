package com.switchfully.springboot.exchange.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class StockRepositoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getStockInformation_givenAExistingStockId_thenReturnStock() {
        // GIVEN & WHEN
        Stock actualStock = StockRepository.getStockInformation("AA");

        // THEN
        assertThat(actualStock.getId()).isEqualTo("AA");
        assertThat(actualStock.getName()).isEqualTo("Ambro AN");
        assertThat(actualStock.getPrice()).isNull();
    }

    @Test
    public void getStockInformation_givenAUnknownStockId_thenThrowException() {
        // THEN (expected exceptions need to be at the top of the test-method)
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No stock found for id:XXX");

        // GIVEN & WHEN
        StockRepository.getStockInformation("XXX");
    }

}