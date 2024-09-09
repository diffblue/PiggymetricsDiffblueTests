package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CurrencyDiffblueTest {
  /**
   * Method under test: {@link Currency#getBase()}
   */
  @Test
  public void testGetBase_givenValueOfUsd_thenReturnsUsd() {
    // Arrange, Act and Assert
    assertEquals(Currency.USD, Currency.valueOf("USD").getBase());
  }
}
