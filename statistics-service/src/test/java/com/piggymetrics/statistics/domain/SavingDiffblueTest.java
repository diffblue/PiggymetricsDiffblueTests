package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import org.junit.Test;

public class SavingDiffblueTest {
  @Test
  public void testConstructor() {
    // Arrange and Act
    Saving actualSaving = new Saving();
    actualSaving.setAmount(BigDecimal.valueOf(1L));
    actualSaving.setCapitalization(true);
    actualSaving.setCurrency(Currency.USD);
    actualSaving.setDeposit(true);
    BigDecimal valueOfResult = BigDecimal.valueOf(1L);
    actualSaving.setInterest(valueOfResult);

    // Assert
    BigDecimal expectedAmount = valueOfResult.ONE;
    BigDecimal amount = actualSaving.getAmount();
    assertSame(expectedAmount, amount);
    assertTrue(actualSaving.getCapitalization());
    assertEquals(Currency.USD, actualSaving.getCurrency());
    assertTrue(actualSaving.getDeposit());
    assertSame(amount, actualSaving.getInterest());
  }
}

