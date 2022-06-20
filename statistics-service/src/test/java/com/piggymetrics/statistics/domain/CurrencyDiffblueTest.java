package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertSame;
import org.junit.Test;

public class CurrencyDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link Currency#valueOf(String)}
  *   <li>{@link Currency#getBase()}
  * </ul>
  */
  @Test
  public void testValueOf() {
    // Arrange and Act
    Currency actualValueOfResult = Currency.valueOf("USD");

    // Assert
    assertSame(actualValueOfResult, actualValueOfResult.getBase());
  }
}

