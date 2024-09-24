package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CurrencyDiffblueTest {
  /**
   * Test {@link com.piggymetrics.account.domain.Currency#getDefault()}.
   */
  @Test
  public void testGetDefault() {
    // Arrange, Act and Assert
    assertEquals(Currency.USD, Currency.valueOf("USD").getDefault());
  }
}
