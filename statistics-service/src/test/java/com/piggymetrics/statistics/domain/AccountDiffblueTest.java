package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AccountDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link Account}
  *   <li>{@link Account#setExpenses(List)}
  *   <li>{@link Account#setIncomes(List)}
  *   <li>{@link Account#setSaving(Saving)}
  *   <li>{@link Account#getExpenses()}
  *   <li>{@link Account#getIncomes()}
  *   <li>{@link Account#getSaving()}
  * </ul>
  */
  @Test
  public void testConstructor() {
    // Arrange and Act
    Account actualAccount = new Account();
    ArrayList<Item> expenses = new ArrayList<>();
    actualAccount.setExpenses(expenses);
    ArrayList<Item> incomes = new ArrayList<>();
    actualAccount.setIncomes(incomes);
    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));
    actualAccount.setSaving(saving);
    List<Item> actualExpenses = actualAccount.getExpenses();
    List<Item> actualIncomes = actualAccount.getIncomes();

    // Assert that nothing has changed
    assertSame(expenses, actualExpenses);
    assertSame(incomes, actualIncomes);
    assertSame(saving, actualAccount.getSaving());
  }
}

