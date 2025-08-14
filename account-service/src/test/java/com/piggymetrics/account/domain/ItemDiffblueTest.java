package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ItemDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Item.<init>()",
    "BigDecimal Item.getAmount()",
    "Currency Item.getCurrency()",
    "String Item.getIcon()",
    "TimePeriod Item.getPeriod()",
    "String Item.getTitle()",
    "void Item.setAmount(BigDecimal)",
    "void Item.setCurrency(Currency)",
    "void Item.setIcon(String)",
    "void Item.setPeriod(TimePeriod)",
    "void Item.setTitle(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Item actualItem = new Item();
    BigDecimal amount = new BigDecimal("2.3");
    actualItem.setAmount(amount);
    actualItem.setCurrency(Currency.USD);
    actualItem.setIcon("Icon");
    actualItem.setPeriod(TimePeriod.YEAR);
    actualItem.setTitle("Dr");
    BigDecimal actualAmount = actualItem.getAmount();
    Currency actualCurrency = actualItem.getCurrency();
    String actualIcon = actualItem.getIcon();
    TimePeriod actualPeriod = actualItem.getPeriod();

    // Assert
    assertEquals("Dr", actualItem.getTitle());
    assertEquals("Icon", actualIcon);
    assertEquals(Currency.USD, actualCurrency);
    assertEquals(TimePeriod.YEAR, actualPeriod);
    assertEquals(new BigDecimal("2.3"), actualAmount);
    assertSame(amount, actualAmount);
  }
}
