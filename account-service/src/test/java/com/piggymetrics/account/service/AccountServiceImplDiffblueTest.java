package com.piggymetrics.account.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Saving;
import com.piggymetrics.account.repository.AccountRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
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
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(BigDecimal.valueOf(1L));

    Account account = new Account();
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    account.setLastSeen(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);
    when(accountRepository.findByName((String) any())).thenReturn(account);

    // Act
    Account actualFindByNameResult = accountServiceImpl.findByName("Dr Jane Doe");

    // Assert
    assertSame(account, actualFindByNameResult);
    assertEquals("1", actualFindByNameResult.getSaving().getAmount().toString());
    verify(accountRepository).findByName((String) any());
  }
}

