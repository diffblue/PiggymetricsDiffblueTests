package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AccountDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Account.<init>()",
    "List Account.getExpenses()",
    "List Account.getIncomes()",
    "Date Account.getLastSeen()",
    "String Account.getName()",
    "String Account.getNote()",
    "Saving Account.getSaving()",
    "void Account.setExpenses(List)",
    "void Account.setIncomes(List)",
    "void Account.setLastSeen(Date)",
    "void Account.setName(String)",
    "void Account.setNote(String)",
    "void Account.setSaving(Saving)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Account actualAccount = new Account();
    ArrayList<Item> expenses = new ArrayList<>();
    actualAccount.setExpenses(expenses);
    ArrayList<Item> incomes = new ArrayList<>();
    actualAccount.setIncomes(incomes);
    Date lastSeen =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
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
    Saving actualSaving = actualAccount.getSaving();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Note", actualNote);
    assertTrue(actualExpenses.isEmpty());
    assertTrue(actualIncomes.isEmpty());
    assertSame(saving, actualSaving);
    assertSame(expenses, actualExpenses);
    assertSame(incomes, actualIncomes);
    assertSame(lastSeen, actualLastSeen);
  }
}
