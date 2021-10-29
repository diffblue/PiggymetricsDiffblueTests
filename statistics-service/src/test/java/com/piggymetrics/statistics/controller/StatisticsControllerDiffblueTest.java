package com.piggymetrics.statistics.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import com.piggymetrics.statistics.domain.timeseries.DataPoint;
import com.piggymetrics.statistics.service.StatisticsServiceImpl;
import com.sun.security.auth.UserPrincipal;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
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
    when(this.statisticsServiceImpl.findByAccountName((String) any())).thenReturn(new ArrayList<DataPoint>());
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
}

