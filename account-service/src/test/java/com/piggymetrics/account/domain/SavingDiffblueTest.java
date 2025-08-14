package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SavingDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Saving.<init>()",
    "BigDecimal Saving.getAmount()",
    "Boolean Saving.getCapitalization()",
    "Currency Saving.getCurrency()",
    "Boolean Saving.getDeposit()",
    "BigDecimal Saving.getInterest()",
    "void Saving.setAmount(BigDecimal)",
    "void Saving.setCapitalization(Boolean)",
    "void Saving.setCurrency(Currency)",
    "void Saving.setDeposit(Boolean)",
    "void Saving.setInterest(BigDecimal)"
  })
  public void testGettersAndSetters() {
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

    // Assert
    assertEquals(Currency.USD, actualCurrency);
    assertTrue(actualCapitalization);
    assertTrue(actualDeposit);
    assertEquals(new BigDecimal("2.3"), actualAmount);
    assertEquals(new BigDecimal("2.3"), actualInterest);
    assertSame(amount, actualAmount);
    assertSame(interest, actualInterest);
  }
}
