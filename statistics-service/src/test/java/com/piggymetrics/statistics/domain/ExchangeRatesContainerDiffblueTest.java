package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ExchangeRatesContainerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
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
  public void testGettersAndSetters_thenReturnsToStringIs1970HyphenMinus01HyphenMinus01AndReturnsRateListLeftCurlyBracketDateEqualsSign1970HyphenMinus01HyphenMinus01CommaBaseEqualsSignUSDCommaRatesEqualsSignLeftCurlyBracketRightCurlyBracketRightCurlyBracketAndReturnsUSDAndReturnsEmptyIsTrueAndReturnsSameAsNewHashMap() {
    // Arrange
    ExchangeRatesContainer exchangeRatesContainer = new ExchangeRatesContainer();

    // Act
    exchangeRatesContainer.setBase(Currency.USD);
    LocalDate date = LocalDate.of(1970, 1, 1);
    exchangeRatesContainer.setDate(date);
    HashMap<String, BigDecimal> rates = new HashMap<>();
    exchangeRatesContainer.setRates(rates);
    String actualToStringResult = exchangeRatesContainer.toString();
    Currency actualBase = exchangeRatesContainer.getBase();
    LocalDate actualDate = exchangeRatesContainer.getDate();
    Map<String, BigDecimal> actualRates = exchangeRatesContainer.getRates();

    // Assert that nothing has changed
    assertEquals("1970-01-01", actualDate.toString());
    assertEquals("RateList{date=1970-01-01, base=USD, rates={}}", actualToStringResult);
    assertEquals(Currency.USD, actualBase);
    assertTrue(actualRates.isEmpty());
    assertSame(rates, actualRates);
    assertSame(date, actualDate);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ExchangeRatesContainer}
   */
  @Test
  public void testNewExchangeRatesContainer_thenReturnsBaseIsNullAndReturnsRatesIsNull() {
    // Arrange and Act
    ExchangeRatesContainer actualExchangeRatesContainer = new ExchangeRatesContainer();

    // Assert
    assertNull(actualExchangeRatesContainer.getBase());
    assertNull(actualExchangeRatesContainer.getRates());
  }
}
