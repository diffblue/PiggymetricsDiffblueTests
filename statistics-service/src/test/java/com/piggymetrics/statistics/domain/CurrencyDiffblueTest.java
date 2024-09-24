package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CurrencyDiffblueTest {
  /**
   * Test {@link com.piggymetrics.statistics.domain.Currency#getBase()}.
   */
  @Test
  public void testGetBase() {
    // Arrange, Act and Assert
    assertEquals(Currency.USD, Currency.valueOf("USD").getBase());
  }
}
