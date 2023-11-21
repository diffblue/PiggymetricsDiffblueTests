package com.piggymetrics.account.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Saving;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {StatisticsServiceClientFallback.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StatisticsServiceClientFallbackDiffblueTest {
  @Autowired
  private StatisticsServiceClientFallback statisticsServiceClientFallback;
  /**
   * Method under test:
   * {@link StatisticsServiceClientFallback#updateStatistics(String, Account)}
   */
  @Test
  public void testUpdateStatistics() {
    // Arrange
    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Account account = new Account();
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    Date lastSeen = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    account.setLastSeen(lastSeen);
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);

    // Act
    statisticsServiceClientFallback.updateStatistics("Dr Jane Doe", account);

    // Assert that nothing has changed
    assertEquals("Name", account.getName());
    assertEquals("Note", account.getNote());
    assertTrue(account.getExpenses().isEmpty());
    assertTrue(account.getIncomes().isEmpty());
    assertSame(saving, account.getSaving());
    assertSame(lastSeen, account.getLastSeen());
  }

  /**
   * Method under test:
   * {@link StatisticsServiceClientFallback#updateStatistics(String, Account)}
   */
  @Test
  public void testUpdateStatistics2() {
    // Arrange
    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Account account = new Account();
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setLastSeen(mock(java.sql.Date.class));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);

    // Act
    statisticsServiceClientFallback.updateStatistics("Dr Jane Doe", account);

    // Assert that nothing has changed
    assertEquals("Name", account.getName());
    assertEquals("Note", account.getNote());
    assertTrue(account.getExpenses().isEmpty());
    assertTrue(account.getIncomes().isEmpty());
    assertSame(saving, account.getSaving());
  }
}
