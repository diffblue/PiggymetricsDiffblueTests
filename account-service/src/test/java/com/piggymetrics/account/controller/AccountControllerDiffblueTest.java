package com.piggymetrics.account.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Saving;
import com.piggymetrics.account.domain.User;
import com.piggymetrics.account.service.AccountService;
import com.sun.security.auth.UserPrincipal;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AccountController.class, ErrorHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountControllerDiffblueTest {
  @Autowired private AccountController accountController;

  @MockBean private AccountService accountService;

  @Autowired private ErrorHandler errorHandler;

  /**
   * Test {@link AccountController#getAccountByName(String)}.
   *
   * <p>Method under test: {@link AccountController#getAccountByName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Account AccountController.getAccountByName(String)"})
  public void testGetAccountByName() throws Exception {
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
    account.setLastSeen(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);
    when(accountService.findByName(Mockito.<String>any())).thenReturn(account);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{name}", "Name");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .setControllerAdvice(errorHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(
            content()
                .string(
                    "{\"name\":\"Name\",\"lastSeen\":0,\"incomes\":[],\"expenses\":[],\"saving\":{\"amount\":2.3,\"currency\":\"USD\",\"interest"
                        + "\":2.3,\"deposit\":true,\"capitalization\":true},\"note\":\"Note\"}"));
  }

  /**
   * Test {@link AccountController#getCurrentAccount(Principal)}.
   *
   * <p>Method under test: {@link AccountController#getCurrentAccount(Principal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Account AccountController.getCurrentAccount(Principal)"})
  public void testGetCurrentAccount() throws Exception {
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
    account.setLastSeen(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);
    when(accountService.findByName(Mockito.<String>any())).thenReturn(account);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/current");
    requestBuilder.principal(new UserPrincipal("principal"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .setControllerAdvice(errorHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(
            content()
                .string(
                    "{\"name\":\"Name\",\"lastSeen\":0,\"incomes\":[],\"expenses\":[],\"saving\":{\"amount\":2.3,\"currency\":\"USD\",\"interest"
                        + "\":2.3,\"deposit\":true,\"capitalization\":true},\"note\":\"Note\"}"));
  }

  /**
   * Test {@link AccountController#saveCurrentAccount(Principal, Account)}.
   *
   * <p>Method under test: {@link AccountController#saveCurrentAccount(Principal, Account)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountController.saveCurrentAccount(Principal, Account)"})
  public void testSaveCurrentAccount() throws Exception {
    // Arrange
    doNothing().when(accountService).saveChanges(Mockito.<String>any(), Mockito.<Account>any());

    MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/current");
    putResult.principal(new UserPrincipal("principal"));

    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Account account = new Account();
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setLastSeen(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.findAndRegisterModules();
    String content = objectMapper.writeValueAsString(account);

    MockHttpServletRequestBuilder requestBuilder =
        putResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .setControllerAdvice(errorHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AccountController#createNewAccount(User)}.
   *
   * <p>Method under test: {@link AccountController#createNewAccount(User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Account AccountController.createNewAccount(User)"})
  public void testCreateNewAccount() throws Exception {
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
    account.setLastSeen(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);
    when(accountService.create(Mockito.<User>any())).thenReturn(account);

    User user = new User();
    user.setPassword("iloveyou");
    user.setUsername("janedoe");

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.findAndRegisterModules();
    String content = objectMapper.writeValueAsString(user);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/").contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .setControllerAdvice(errorHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(
            content()
                .string(
                    "{\"name\":\"Name\",\"lastSeen\":0,\"incomes\":[],\"expenses\":[],\"saving\":{\"amount\":2.3,\"currency\":\"USD\",\"interest"
                        + "\":2.3,\"deposit\":true,\"capitalization\":true},\"note\":\"Note\"}"));
  }
}
