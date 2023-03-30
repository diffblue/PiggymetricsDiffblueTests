package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CurrencyDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link Currency#valueOf(String)}
  *   <li>{@link Currency#getDefault()}
  * </ul>
  */
  @Test
  public void testValueOf() {
    // Arrange, Act and Assert
    assertEquals(Currency.USD, Currency.valueOf("USD").getDefault());
  }
}

