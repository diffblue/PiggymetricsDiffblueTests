package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class AccountDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Account}
   *   <li>{@link Account#setExpenses(List)}
   *   <li>{@link Account#setIncomes(List)}
   *   <li>{@link Account#setLastSeen(Date)}
   *   <li>{@link Account#setName(String)}
   *   <li>{@link Account#setNote(String)}
   *   <li>{@link Account#setSaving(Saving)}
   *   <li>{@link Account#getExpenses()}
   *   <li>{@link Account#getIncomes()}
   *   <li>{@link Account#getLastSeen()}
   *   <li>{@link Account#getName()}
   *   <li>{@link Account#getNote()}
   *   <li>{@link Account#getSaving()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Account actualAccount = new Account();
    ArrayList<Item> expenses = new ArrayList<>();
    actualAccount.setExpenses(expenses);
    ArrayList<Item> incomes = new ArrayList<>();
    actualAccount.setIncomes(incomes);
    Date lastSeen = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualAccount.setLastSeen(lastSeen);
    actualAccount.setName("Name");
    actualAccount.setNote("Note");
    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));
    actualAccount.setSaving(saving);
    List<Item> actualExpenses = actualAccount.getExpenses();
    List<Item> actualIncomes = actualAccount.getIncomes();
    Date actualLastSeen = actualAccount.getLastSeen();
    String actualName = actualAccount.getName();
    String actualNote = actualAccount.getNote();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Note", actualNote);
    assertSame(saving, actualAccount.getSaving());
    assertSame(expenses, actualExpenses);
    assertSame(incomes, actualIncomes);
    assertSame(lastSeen, actualLastSeen);
  }
}
