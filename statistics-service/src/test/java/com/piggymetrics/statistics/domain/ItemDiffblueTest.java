package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import org.junit.Test;

public class ItemDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Item}
   *   <li>{@link Item#setAmount(BigDecimal)}
   *   <li>{@link Item#setCurrency(Currency)}
   *   <li>{@link Item#setPeriod(TimePeriod)}
   *   <li>{@link Item#setTitle(String)}
   *   <li>{@link Item#getAmount()}
   *   <li>{@link Item#getCurrency()}
   *   <li>{@link Item#getPeriod()}
   *   <li>{@link Item#getTitle()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Item actualItem = new Item();
    BigDecimal amount = new BigDecimal("2.3");
    actualItem.setAmount(amount);
    actualItem.setCurrency(Currency.USD);
    actualItem.setPeriod(TimePeriod.YEAR);
    actualItem.setTitle("Dr");
    BigDecimal actualAmount = actualItem.getAmount();
    Currency actualCurrency = actualItem.getCurrency();
    TimePeriod actualPeriod = actualItem.getPeriod();

    // Assert
    assertEquals("Dr", actualItem.getTitle());
    assertEquals(Currency.USD, actualCurrency);
    assertEquals(TimePeriod.YEAR, actualPeriod);
    assertEquals(new BigDecimal("2.3"), actualAmount);
    assertSame(amount, actualAmount);
  }
}
