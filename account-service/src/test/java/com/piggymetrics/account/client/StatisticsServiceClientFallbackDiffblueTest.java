package com.piggymetrics.account.client;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Item;
import com.piggymetrics.account.domain.Saving;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {StatisticsServiceClientFallback.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StatisticsServiceClientFallbackDiffblueTest {
  @Autowired
  private StatisticsServiceClientFallback statisticsServiceClientFallback;

  /**
   * Test
   * {@link com.piggymetrics.account.client.StatisticsServiceClientFallback#updateStatistics(String, Account)}.
   * <ul>
   *   <li>When {@link com.piggymetrics.account.domain.Account}
   * {@link com.piggymetrics.account.domain.Account#setExpenses(List)} does
   * nothing.</li>
   *   <li>Then calls
   * {@link com.piggymetrics.account.domain.Account#setExpenses(List)}.</li>
   * <ul>
   */
  @Test
  public void testUpdateStatistics_whenAccountSetExpensesDoesNothing_thenCallsSetExpenses() {
    // Arrange
    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));
    Account account = mock(Account.class);
    doNothing().when(account).setExpenses(Mockito.<List<Item>>any());
    doNothing().when(account).setIncomes(Mockito.<List<Item>>any());
    doNothing().when(account).setLastSeen(Mockito.<Date>any());
    doNothing().when(account).setName(Mockito.<String>any());
    doNothing().when(account).setNote(Mockito.<String>any());
    doNothing().when(account).setSaving(Mockito.<Saving>any());
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setLastSeen(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);

    // Act
    statisticsServiceClientFallback.updateStatistics("Dr Jane Doe", account);

    // Assert that nothing has changed
    verify(account).setExpenses(isA(List.class));
    verify(account).setIncomes(isA(List.class));
    verify(account).setLastSeen(isA(Date.class));
    verify(account).setName(eq("Name"));
    verify(account).setNote(eq("Note"));
    verify(account).setSaving(isA(Saving.class));
  }
}
