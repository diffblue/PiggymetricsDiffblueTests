package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ExchangeRatesContainerDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link ExchangeRatesContainer}
  *   <li>{@link ExchangeRatesContainer#setBase(Currency)}
  *   <li>{@link ExchangeRatesContainer#setDate(LocalDate)}
  *   <li>{@link ExchangeRatesContainer#setRates(Map)}
  *   <li>{@link ExchangeRatesContainer#toString()}
  *   <li>{@link ExchangeRatesContainer#getBase()}
  *   <li>{@link ExchangeRatesContainer#getDate()}
  *   <li>{@link ExchangeRatesContainer#getRates()}
  * </ul>
  */
  @Test
  public void testConstructor() {
    // Arrange and Act
    ExchangeRatesContainer actualExchangeRatesContainer = new ExchangeRatesContainer();
    actualExchangeRatesContainer.setBase(Currency.USD);
    LocalDate date = LocalDate.of(1970, 1, 1);
    actualExchangeRatesContainer.setDate(date);
    HashMap<String, BigDecimal> rates = new HashMap<>();
    actualExchangeRatesContainer.setRates(rates);
    String actualToStringResult = actualExchangeRatesContainer.toString();

    // Assert
    assertEquals(Currency.USD, actualExchangeRatesContainer.getBase());
    assertSame(date, actualExchangeRatesContainer.getDate());
    assertSame(rates, actualExchangeRatesContainer.getRates());
    assertEquals("RateList{date=1970-01-01, base=USD, rates={}}", actualToStringResult);
  }

  /**
   * Method under test: default or parameterless constructor of {@link ExchangeRatesContainer}
   */
  @Test
  public void testConstructor2() {
    // Arrange and Act
    ExchangeRatesContainer actualExchangeRatesContainer = new ExchangeRatesContainer();

    // Assert
    assertNull(actualExchangeRatesContainer.getBase());
    assertNull(actualExchangeRatesContainer.getRates());
  }
}

