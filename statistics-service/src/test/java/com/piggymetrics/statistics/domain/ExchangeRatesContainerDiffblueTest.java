package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExchangeRatesContainerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Currency ExchangeRatesContainer.getBase()",
    "LocalDate ExchangeRatesContainer.getDate()",
    "Map ExchangeRatesContainer.getRates()",
    "void ExchangeRatesContainer.setBase(Currency)",
    "void ExchangeRatesContainer.setDate(LocalDate)",
    "void ExchangeRatesContainer.setRates(Map)",
    "String ExchangeRatesContainer.toString()"
  })
  public void testGettersAndSetters() {
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

    // Assert
    assertEquals("1970-01-01", actualDate.toString());
    assertEquals("RateList{date=1970-01-01, base=USD, rates={}}", actualToStringResult);
    assertEquals(Currency.USD, actualBase);
    assertTrue(actualRates.isEmpty());
    assertSame(rates, actualRates);
    assertSame(date, actualDate);
  }

  /**
   * Test new {@link ExchangeRatesContainer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ExchangeRatesContainer}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeRatesContainer.<init>()"})
  public void testNewExchangeRatesContainer() {
    // Arrange and Act
    ExchangeRatesContainer actualExchangeRatesContainer = new ExchangeRatesContainer();

    // Assert
    assertNull(actualExchangeRatesContainer.getBase());
    assertNull(actualExchangeRatesContainer.getRates());
  }
}
