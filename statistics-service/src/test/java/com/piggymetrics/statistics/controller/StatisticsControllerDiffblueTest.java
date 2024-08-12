package com.piggymetrics.statistics.controller;

import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggymetrics.statistics.domain.Account;
import com.piggymetrics.statistics.domain.Currency;
import com.piggymetrics.statistics.domain.Saving;
import com.piggymetrics.statistics.domain.timeseries.DataPoint;
import com.piggymetrics.statistics.domain.timeseries.DataPointId;
import com.piggymetrics.statistics.service.StatisticsService;
import com.sun.security.auth.UserPrincipal;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StatisticsController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StatisticsControllerDiffblueTest {
  @Autowired
  private StatisticsController statisticsController;

  @MockBean
  private StatisticsService statisticsService;

  /**
   * Method under test:
   * {@link StatisticsController#getCurrentAccountStatistics(Principal)}
   */
  @Test
  public void testGetCurrentAccountStatistics_thenStatusOkAndContentContentTypeApplicationSlashJsonSemicolonCharsetEqualsSignUtfHyphenMinus8AndContentStringLeftSquareBracketRightSquareBracket()
      throws Exception {
    // Arrange
    when(statisticsService.findByAccountName(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/current");
    requestBuilder.principal(new UserPrincipal("principal"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(statisticsController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test:
   * {@link StatisticsController#getStatisticsByAccountName(String)}
   */
  @Test
  public void testGetStatisticsByAccountName_thenStatusOkAndContentContentTypeApplicationSlashJsonSemicolonCharsetEqualsSignUtfHyphenMinus8AndContentStringLeftSquareBracketRightSquareBracket()
      throws Exception {
    // Arrange
    when(statisticsService.findByAccountName(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{accountName}", "Dr Jane Doe");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(statisticsController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test:
   * {@link StatisticsController#getStatisticsByAccountName(String)}
   */
  @Test
  public void testGetStatisticsByAccountName_thenStatusOkAndContentContentTypeApplicationSlashJsonSemicolonCharsetEqualsSignUtfHyphenMinus8AndContentStringLeftSquareBracketRightSquareBracket2()
      throws Exception {
    // Arrange
    when(statisticsService.findByAccountName(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{accountName}", "Dr Jane Doe");
    requestBuilder.characterEncoding("Encoding");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(statisticsController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test:
   * {@link StatisticsController#saveAccountStatistics(String, Account)}
   */
  @Test
  public void testSaveAccountStatistics_thenStatusOk() throws Exception {
    // Arrange
    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    dataPoint.setId(
        new DataPointId("3", Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(statisticsService.save(Mockito.<String>any(), Mockito.<Account>any())).thenReturn(dataPoint);

    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Account account = new Account();
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setSaving(saving);
    String content = (new ObjectMapper()).writeValueAsString(account);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/{accountName}", "Dr Jane Doe")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(statisticsController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
