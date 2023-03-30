package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import org.junit.Test;

public class ItemDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link Item}
  *   <li>{@link Item#setAmount(BigDecimal)}
  *   <li>{@link Item#setCurrency(Currency)}
  *   <li>{@link Item#setIcon(String)}
  *   <li>{@link Item#setPeriod(TimePeriod)}
  *   <li>{@link Item#setTitle(String)}
  *   <li>{@link Item#getAmount()}
  *   <li>{@link Item#getCurrency()}
  *   <li>{@link Item#getIcon()}
  *   <li>{@link Item#getPeriod()}
  *   <li>{@link Item#getTitle()}
  * </ul>
  */
  @Test
  public void testConstructor() {
    // Arrange and Act
    Item actualItem = new Item();
    BigDecimal amount = BigDecimal.valueOf(1L);
    actualItem.setAmount(amount);
    actualItem.setCurrency(Currency.USD);
    actualItem.setIcon("Icon");
    actualItem.setPeriod(TimePeriod.YEAR);
    actualItem.setTitle("Dr");

    // Assert
    BigDecimal expectedAmount = amount.ONE;
    assertSame(expectedAmount, actualItem.getAmount());
    assertEquals(Currency.USD, actualItem.getCurrency());
    assertEquals("Icon", actualItem.getIcon());
    assertEquals(TimePeriod.YEAR, actualItem.getPeriod());
    assertEquals("Dr", actualItem.getTitle());
  }
}

