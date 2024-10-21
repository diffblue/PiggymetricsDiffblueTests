package com.piggymetrics.account.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AccountController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountControllerDiffblueTest {
  @Autowired
  private AccountController accountController;

  @MockBean
  private AccountService accountService;

  /**
   * Test {@link AccountController#getAccountByName(String)}.
   * <p>
   * Method under test: {@link AccountController#getAccountByName(String)}
   */
  @Test
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
    account.setLastSeen(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);
    when(accountService.findByName(Mockito.<String>any())).thenReturn(account);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{name}", "Name");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"name\":\"Name\",\"lastSeen\":0,\"incomes\":[],\"expenses\":[],\"saving\":{\"amount\":2.3,\"currency\":\"USD\",\"interest"
                    + "\":2.3,\"deposit\":true,\"capitalization\":true},\"note\":\"Note\"}"));
  }

  /**
   * Test {@link AccountController#getCurrentAccount(Principal)}.
   * <p>
   * Method under test: {@link AccountController#getCurrentAccount(Principal)}
   */
  @Test
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
    account.setLastSeen(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);
    when(accountService.findByName(Mockito.<String>any())).thenReturn(account);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/current");
    requestBuilder.principal(new UserPrincipal("principal"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"name\":\"Name\",\"lastSeen\":0,\"incomes\":[],\"expenses\":[],\"saving\":{\"amount\":2.3,\"currency\":\"USD\",\"interest"
                    + "\":2.3,\"deposit\":true,\"capitalization\":true},\"note\":\"Note\"}"));
  }

  /**
   * Test {@link AccountController#saveCurrentAccount(Principal, Account)}.
   * <ul>
   *   <li>Given {@link AccountService}
   * {@link AccountService#saveChanges(String, Account)} does nothing.</li>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccountController#saveCurrentAccount(Principal, Account)}
   */
  @Test
  public void testSaveCurrentAccount_givenAccountServiceSaveChangesDoesNothing_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing().when(accountService).saveChanges(Mockito.<String>any(), Mockito.<Account>any());
    MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/current");
    putResult.principal(new UserPrincipal("principal"));
    java.sql.Date lastSeen = mock(java.sql.Date.class);
    when(lastSeen.getTime()).thenReturn(10L);

    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Account account = new Account();
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setLastSeen(lastSeen);
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);
    String content = (new ObjectMapper()).writeValueAsString(account);
    MockHttpServletRequestBuilder requestBuilder = putResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AccountController#saveCurrentAccount(Principal, Account)}.
   * <ul>
   *   <li>Given {@link AccountService}.</li>
   *   <li>Then status four hundred.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AccountController#saveCurrentAccount(Principal, Account)}
   */
  @Test
  public void testSaveCurrentAccount_givenAccountService_thenStatusFourHundred() throws Exception {
    // Arrange
    java.sql.Date lastSeen = mock(java.sql.Date.class);
    when(lastSeen.getTime()).thenReturn(10L);

    Saving saving = new Saving();
    saving.setAmount(null);
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Account account = new Account();
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setLastSeen(lastSeen);
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);
    String content = (new ObjectMapper()).writeValueAsString(account);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/current")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link AccountController#createNewAccount(User)}.
   * <p>
   * Method under test: {@link AccountController#createNewAccount(User)}
   */
  @Test
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
    account.setLastSeen(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    account.setName("Name");
    account.setNote("Note");
    account.setSaving(saving);
    when(accountService.create(Mockito.<User>any())).thenReturn(account);

    User user = new User();
    user.setPassword("iloveyou");
    user.setUsername("janedoe");
    String content = (new ObjectMapper()).writeValueAsString(user);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"name\":\"Name\",\"lastSeen\":0,\"incomes\":[],\"expenses\":[],\"saving\":{\"amount\":2.3,\"currency\":\"USD\",\"interest"
                    + "\":2.3,\"deposit\":true,\"capitalization\":true},\"note\":\"Note\"}"));
  }
}
