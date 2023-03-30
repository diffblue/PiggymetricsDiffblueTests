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
  * 
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
  public void testConstructor() {
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
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(BigDecimal.valueOf(1L));
    actualAccount.setSaving(saving);

    // Assert
    assertSame(expenses, actualAccount.getExpenses());
    assertSame(incomes, actualAccount.getIncomes());
    assertSame(lastSeen, actualAccount.getLastSeen());
    assertEquals("Name", actualAccount.getName());
    assertEquals("Note", actualAccount.getNote());
    assertSame(saving, actualAccount.getSaving());
  }
}

