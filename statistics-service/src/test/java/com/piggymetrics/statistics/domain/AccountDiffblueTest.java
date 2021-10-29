package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Test;

public class AccountDiffblueTest {
  @Test
  public void testConstructor() {
    // Arrange and Act
    Account actualAccount = new Account();
    ArrayList<Item> itemList = new ArrayList<Item>();
    actualAccount.setExpenses(itemList);
    ArrayList<Item> itemList1 = new ArrayList<Item>();
    actualAccount.setIncomes(itemList1);
    Saving saving = new Saving();
    saving.setInterest(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    actualAccount.setSaving(saving);

    // Assert
    assertSame(itemList, actualAccount.getExpenses());
    assertSame(itemList1, actualAccount.getIncomes());
    assertSame(saving, actualAccount.getSaving());
  }
}
