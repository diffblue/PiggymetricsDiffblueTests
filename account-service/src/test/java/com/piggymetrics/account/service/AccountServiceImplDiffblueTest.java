package com.piggymetrics.account.service;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Saving;
import com.piggymetrics.account.repository.AccountRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceImplDiffblueTest {
  @MockBean
  private AccountRepository accountRepository;

  @Autowired
  private AccountServiceImpl accountServiceImpl;

  @MockBean
  private MongodExecutable mongodExecutable;
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
    verify(accountRepository).findByName(Mockito.<String>any());
    assertSame(account, actualFindByNameResult);
  }
}

