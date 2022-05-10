package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import org.junit.Test;

public class SavingDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link Saving}
  *   <li>{@link Saving#setAmount(BigDecimal)}
  *   <li>{@link Saving#setCapitalization(Boolean)}
  *   <li>{@link Saving#setCurrency(Currency)}
  *   <li>{@link Saving#setDeposit(Boolean)}
  *   <li>{@link Saving#setInterest(BigDecimal)}
  *   <li>{@link Saving#getAmount()}
  *   <li>{@link Saving#getCapitalization()}
  *   <li>{@link Saving#getCurrency()}
  *   <li>{@link Saving#getDeposit()}
  *   <li>{@link Saving#getInterest()}
  * </ul>
  */
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

