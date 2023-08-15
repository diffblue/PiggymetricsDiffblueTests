package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CurrencyDiffblueTest {
  /**
  * Method under test: {@link Currency#getDefault()}
  */
  @Test
  public void testGetDefault() {
    // Arrange, Act and Assert
    assertEquals(Currency.USD, Currency.valueOf("USD").getDefault());
  }
}

