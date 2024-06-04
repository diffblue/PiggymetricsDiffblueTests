package com.piggymetrics.account.service;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.account.client.AuthServiceClient;
import com.piggymetrics.account.client.StatisticsServiceClient;
import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Saving;
import com.piggymetrics.account.repository.AccountRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AccountServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceImplDiffblueTest {
  @MockBean
  private AccountRepository accountRepository;

  @Autowired
  private AccountServiceImpl accountServiceImpl;

  @MockBean
  private AuthServiceClient authServiceClient;

  @MockBean
  private StatisticsServiceClient statisticsServiceClient;

  /**
   * Method under test: {@link AccountServiceImpl#findByName(String)}
   */
  @Test
  public void testFindByName() {
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
    account.setLastSeen(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);
    when(accountRepository.findByName(Mockito.<String>any())).thenReturn(account);

    // Act
    Account actualFindByNameResult = accountServiceImpl.findByName("Dr Jane Doe");

    // Assert
    verify(accountRepository).findByName(eq("Dr Jane Doe"));
    assertSame(account, actualFindByNameResult);
  }

  /**
   * Method under test: {@link AccountServiceImpl#saveChanges(String, Account)}
   */
  @Test
  public void testSaveChanges() {
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
    account.setLastSeen(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);

    Saving saving2 = new Saving();
    saving2.setAmount(new BigDecimal("2.3"));
    saving2.setCapitalization(true);
    saving2.setCurrency(Currency.USD);
    saving2.setDeposit(true);
    saving2.setInterest(new BigDecimal("2.3"));

    Account account2 = new Account();
    account2.setExpenses(new ArrayList<>());
    account2.setIncomes(new ArrayList<>());
    account2.setLastSeen(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    account2.setName("Name");
    account2.setNote("Note");
    account2.setSaving(saving2);
    when(accountRepository.save(Mockito.<Account>any())).thenReturn(account2);
    when(accountRepository.findByName(Mockito.<String>any())).thenReturn(account);
    doNothing().when(statisticsServiceClient).updateStatistics(Mockito.<String>any(), Mockito.<Account>any());

    Saving saving3 = new Saving();
    saving3.setAmount(new BigDecimal("2.3"));
    saving3.setCapitalization(true);
    saving3.setCurrency(Currency.USD);
    saving3.setDeposit(true);
    saving3.setInterest(new BigDecimal("2.3"));

    Account update = new Account();
    update.setExpenses(new ArrayList<>());
    update.setIncomes(new ArrayList<>());
    update.setLastSeen(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    update.setName("Name");
    update.setNote("Note");
    update.setSaving(saving3);

    // Act
    accountServiceImpl.saveChanges("Name", update);

    // Assert
    verify(statisticsServiceClient).updateStatistics(eq("Name"), isA(Account.class));
    verify(accountRepository).findByName(eq("Name"));
    verify(accountRepository).save(isA(Account.class));
  }
}
