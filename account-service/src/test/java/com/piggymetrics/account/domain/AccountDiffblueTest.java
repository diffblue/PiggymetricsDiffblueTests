package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
    actualAccount.setLastSeen(fromResult);
    actualAccount.setName("Name");
    actualAccount.setNote("Note");
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
    assertSame(fromResult, actualAccount.getLastSeen());
    assertEquals("Name", actualAccount.getName());
    assertEquals("Note", actualAccount.getNote());
    assertSame(saving, actualAccount.getSaving());
  }
}

