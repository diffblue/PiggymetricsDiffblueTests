package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import org.junit.Test;

public class SavingDiffblueTest {
  /**
   * Methods under test:
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
  public void testGettersAndSetters_thenReturnsCurrencyIsUsdAndReturnsCapitalizationAndReturnsDepositAndReturnsAmountIsNewBigDecimalWith2Dot3AndReturnsInterestIsNewBigDecimalWith2Dot3() {
    // Arrange and Act
    Saving actualSaving = new Saving();
    BigDecimal amount = new BigDecimal("2.3");
    actualSaving.setAmount(amount);
    actualSaving.setCapitalization(true);
    actualSaving.setCurrency(Currency.USD);
    actualSaving.setDeposit(true);
    BigDecimal interest = new BigDecimal("2.3");
    actualSaving.setInterest(interest);
    BigDecimal actualAmount = actualSaving.getAmount();
    Boolean actualCapitalization = actualSaving.getCapitalization();
    Currency actualCurrency = actualSaving.getCurrency();
    Boolean actualDeposit = actualSaving.getDeposit();
    BigDecimal actualInterest = actualSaving.getInterest();

    // Assert that nothing has changed
    assertEquals(Currency.USD, actualCurrency);
    assertTrue(actualCapitalization);
    assertTrue(actualDeposit);
    assertEquals(new BigDecimal("2.3"), actualAmount);
    assertEquals(new BigDecimal("2.3"), actualInterest);
    assertSame(amount, actualAmount);
    assertSame(interest, actualInterest);
  }
}
