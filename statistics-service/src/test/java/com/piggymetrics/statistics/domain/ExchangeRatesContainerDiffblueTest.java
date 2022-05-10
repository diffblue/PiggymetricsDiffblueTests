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
    LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
    actualExchangeRatesContainer.setDate(ofEpochDayResult);
    HashMap<String, BigDecimal> stringBigDecimalMap = new HashMap<>();
    actualExchangeRatesContainer.setRates(stringBigDecimalMap);

    // Assert
    assertEquals(Currency.USD, actualExchangeRatesContainer.getBase());
    assertSame(ofEpochDayResult, actualExchangeRatesContainer.getDate());
    assertSame(stringBigDecimalMap, actualExchangeRatesContainer.getRates());
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

