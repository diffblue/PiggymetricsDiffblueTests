package com.piggymetrics.account.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Saving;
import com.piggymetrics.account.domain.User;
import com.piggymetrics.account.service.AccountServiceImpl;
import com.sun.security.auth.UserPrincipal;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AccountController.class})
@RunWith(SpringRunner.class)
public class AccountControllerDiffblueTest {
  @Autowired
  private AccountController accountController;

  @MockBean
  private AccountServiceImpl accountServiceImpl;
  @Test
  public void testCreateNewAccount() throws Exception {
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
    when(this.accountServiceImpl.create((User) any())).thenReturn(account);

    User user = new User();
    user.setPassword("iloveyou");
    user.setUsername("janedoe");
    String content = (new ObjectMapper()).writeValueAsString(user);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(this.accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"name\":\"Name\",\"lastSeen\":0,\"incomes\":[],\"expenses\":[],\"saving\":{\"amount\":1,\"currency\":\"USD\",\"interest"
                    + "\":1,\"deposit\":true,\"capitalization\":true},\"note\":\"Note\"}"));
  }

  @Test
  public void testGetAccountByName() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{name}", "", "Uri Vars");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.accountController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }

  @Test
  public void testGetCurrentAccount() throws Exception {
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
    when(this.accountServiceImpl.findByName((String) any())).thenReturn(account);
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/current");
    getResult.principal(new UserPrincipal("principal"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(this.accountController)
        .build()
        .perform(getResult)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"name\":\"Name\",\"lastSeen\":0,\"incomes\":[],\"expenses\":[],\"saving\":{\"amount\":1,\"currency\":\"USD\",\"interest"
                    + "\":1,\"deposit\":true,\"capitalization\":true},\"note\":\"Note\"}"));
  }

  @Test
  public void testSaveCurrentAccount() throws Exception {
    // Arrange
    Saving saving = new Saving();
    saving.setAmount(null);
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
    String content = (new ObjectMapper()).writeValueAsString(account);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/current")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.accountController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
  }
}

