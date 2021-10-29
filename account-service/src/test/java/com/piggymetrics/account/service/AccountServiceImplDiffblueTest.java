package com.piggymetrics.account.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.account.client.AuthServiceClient;
import com.piggymetrics.account.client.StatisticsServiceClient;
import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Item;
import com.piggymetrics.account.domain.Saving;
import com.piggymetrics.account.repository.AccountRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {AccountServiceImpl.class})
@RunWith(SpringRunner.class)
public class AccountServiceImplDiffblueTest {
  @MockBean
  private AccountRepository accountRepository;

  @Autowired
  private AccountServiceImpl accountServiceImpl;

  @MockBean
  private AuthServiceClient authServiceClient;

  @MockBean(name = "com.piggymetrics.account.client.StatisticsServiceClient")
  private StatisticsServiceClient statisticsServiceClient;
  @Test
  public void testFindByName() {
    // Arrange
    Saving saving = new Saving();
    saving.setInterest(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);

    Account account = new Account();
    account.setName("Name");
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    account.setLastSeen(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
    account.setIncomes(new ArrayList<Item>());
    account.setExpenses(new ArrayList<Item>());
    account.setSaving(saving);
    account.setNote("Note");
    when(this.accountRepository.findByName((String) any())).thenReturn(account);

    // Act
    Account actualFindByNameResult = this.accountServiceImpl.findByName("Dr Jane Doe");

    // Assert
    assertSame(account, actualFindByNameResult);
    assertEquals("1", actualFindByNameResult.getSaving().getAmount().toString());
    verify(this.accountRepository).findByName((String) any());
  }

  @Test
  public void testSaveChanges() {
    // Arrange
    doNothing().when(this.statisticsServiceClient).updateStatistics((String) any(), (Account) any());

    Saving saving = new Saving();
    saving.setInterest(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);

    Account account = new Account();
    account.setName("Name");
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    account.setLastSeen(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
    account.setIncomes(new ArrayList<Item>());
    account.setExpenses(new ArrayList<Item>());
    account.setSaving(saving);
    account.setNote("Note");

    Saving saving1 = new Saving();
    saving1.setInterest(BigDecimal.valueOf(1L));
    saving1.setCapitalization(true);
    saving1.setAmount(BigDecimal.valueOf(1L));
    saving1.setCurrency(Currency.USD);
    saving1.setDeposit(true);

    Account account1 = new Account();
    account1.setName("Name");
    LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
    account1.setLastSeen(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
    account1.setIncomes(new ArrayList<Item>());
    account1.setExpenses(new ArrayList<Item>());
    account1.setSaving(saving1);
    account1.setNote("Note");
    when(this.accountRepository.save((Account) any())).thenReturn(account1);
    when(this.accountRepository.findByName((String) any())).thenReturn(account);

    Saving saving2 = new Saving();
    saving2.setInterest(BigDecimal.valueOf(1L));
    saving2.setCapitalization(true);
    saving2.setAmount(BigDecimal.valueOf(1L));
    saving2.setCurrency(Currency.USD);
    saving2.setDeposit(true);

    Account account2 = new Account();
    account2.setName("Name");
    LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
    account2.setLastSeen(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
    account2.setIncomes(new ArrayList<Item>());
    account2.setExpenses(new ArrayList<Item>());
    account2.setSaving(saving2);
    account2.setNote("Note");

    // Act
    this.accountServiceImpl.saveChanges("Name", account2);

    // Assert
    verify(this.statisticsServiceClient).updateStatistics((String) any(), (Account) any());
    verify(this.accountRepository).findByName((String) any());
    verify(this.accountRepository).save((Account) any());
  }
}
