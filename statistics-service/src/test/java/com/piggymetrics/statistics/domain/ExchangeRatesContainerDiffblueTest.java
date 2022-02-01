package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import org.junit.Test;

public class ExchangeRatesContainerDiffblueTest {
  @Test
  public void testConstructor() {
    // Arrange and Act
    ExchangeRatesContainer actualExchangeRatesContainer = new ExchangeRatesContainer();
    actualExchangeRatesContainer.setBase(Currency.USD);
    LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
    actualExchangeRatesContainer.setDate(ofEpochDayResult);
    HashMap<String, BigDecimal> stringBigDecimalMap = new HashMap<>();
    actualExchangeRatesContainer.setRates(stringBigDecimalMap);

    // Assert
    assertEquals(Currency.USD, actualExchangeRatesContainer.getBase());
    assertSame(ofEpochDayResult, actualExchangeRatesContainer.getDate());
    assertSame(stringBigDecimalMap, actualExchangeRatesContainer.getRates());
    assertEquals("RateList{date=1970-01-02, base=USD, rates={}}", actualExchangeRatesContainer.toString());
  }

  @Test
  public void testConstructor2() {
    // Arrange and Act
    ExchangeRatesContainer actualExchangeRatesContainer = new ExchangeRatesContainer();

    // Assert
    assertNull(actualExchangeRatesContainer.getBase());
    assertNull(actualExchangeRatesContainer.getRates());
  }
}

