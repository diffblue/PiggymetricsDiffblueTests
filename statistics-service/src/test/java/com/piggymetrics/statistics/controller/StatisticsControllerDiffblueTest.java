package com.piggymetrics.statistics.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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

@ContextConfiguration(classes = {StatisticsController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StatisticsControllerDiffblueTest {
  @Autowired private StatisticsController statisticsController;

  @MockBean private StatisticsService statisticsService;

  /**
   * Test {@link StatisticsController#getCurrentAccountStatistics(Principal)}.
   *
   * <p>Method under test: {@link StatisticsController#getCurrentAccountStatistics(Principal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List StatisticsController.getCurrentAccountStatistics(Principal)"})
  public void testGetCurrentAccountStatistics() throws Exception {
    // Arrange
    when(statisticsService.findByAccountName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/current");
    requestBuilder.principal(new UserPrincipal("principal"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(statisticsController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link StatisticsController#getStatisticsByAccountName(String)}.
   *
   * <p>Method under test: {@link StatisticsController#getStatisticsByAccountName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List StatisticsController.getStatisticsByAccountName(String)"})
  public void testGetStatisticsByAccountName() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/{accountName}", "Dr Jane Doe");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(statisticsController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link StatisticsController#saveAccountStatistics(String, Account)}.
   *
   * <p>Method under test: {@link StatisticsController#saveAccountStatistics(String, Account)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatisticsController.saveAccountStatistics(String, Account)"})
  public void testSaveAccountStatistics() throws Exception {
    // Arrange
    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    Date date =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    DataPointId id = new DataPointId("3", date);
    dataPoint.setId(id);
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(statisticsService.save(Mockito.<String>any(), Mockito.<Account>any()))
        .thenReturn(dataPoint);

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

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.findAndRegisterModules();
    String content = objectMapper.writeValueAsString(account);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/{accountName}", "Dr Jane Doe")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(statisticsController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
