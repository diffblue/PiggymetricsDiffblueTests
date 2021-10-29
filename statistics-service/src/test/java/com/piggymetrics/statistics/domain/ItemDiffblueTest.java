package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import org.junit.Test;

public class ItemDiffblueTest {
  @Test
  public void testConstructor() {
    // Arrange and Act
    Item actualItem = new Item();
    BigDecimal valueOfResult = BigDecimal.valueOf(1L);
    actualItem.setAmount(valueOfResult);
    actualItem.setCurrency(Currency.USD);
    actualItem.setPeriod(TimePeriod.YEAR);
    actualItem.setTitle("Dr");

    // Assert
    BigDecimal expectedAmount = valueOfResult.ONE;
    assertSame(expectedAmount, actualItem.getAmount());
    assertEquals(Currency.USD, actualItem.getCurrency());
    assertEquals(TimePeriod.YEAR, actualItem.getPeriod());
    assertEquals("Dr", actualItem.getTitle());
  }
}

