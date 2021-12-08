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
    ArrayList<Item> itemList = new ArrayList<>();
    actualAccount.setExpenses(itemList);
    ArrayList<Item> itemList1 = new ArrayList<>();
    actualAccount.setIncomes(itemList1);
    Saving saving = new Saving();
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(BigDecimal.valueOf(1L));
    actualAccount.setSaving(saving);

    // Assert
    assertSame(itemList, actualAccount.getExpenses());
    assertSame(itemList1, actualAccount.getIncomes());
    assertSame(saving, actualAccount.getSaving());
  }
}

