package com.piggymetrics.statistics.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggymetrics.statistics.domain.Account;
import com.piggymetrics.statistics.domain.Currency;
import com.piggymetrics.statistics.domain.Saving;
import com.piggymetrics.statistics.service.StatisticsServiceImpl;
import com.sun.security.auth.UserPrincipal;
import java.math.BigDecimal;
import java.util.ArrayList;
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

@ContextConfiguration(classes = {StatisticsController.class})
@RunWith(SpringRunner.class)
public class StatisticsControllerDiffblueTest {
  @Autowired
  private StatisticsController statisticsController;

  @MockBean
  private StatisticsServiceImpl statisticsServiceImpl;
  @Test
  public void testGetCurrentAccountStatistics() throws Exception {
    // Arrange
    when(this.statisticsServiceImpl.findByAccountName((String) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/current");
    getResult.principal(new UserPrincipal("principal"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(this.statisticsController)
        .build()
        .perform(getResult)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  @Test
  public void testGetStatisticsByAccountName() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{accountName}", "", "Uri Vars");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.statisticsController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  public void testSaveAccountStatistics() throws Exception {
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
    account.setSaving(saving);
    String content = (new ObjectMapper()).writeValueAsString(account);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/{accountName}", "Dr Jane Doe")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.statisticsController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
  }
}

