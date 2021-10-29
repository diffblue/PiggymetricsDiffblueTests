package com.piggymetrics.statistics.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.statistics.domain.Account;
import com.piggymetrics.statistics.domain.Currency;
import com.piggymetrics.statistics.domain.Item;
import com.piggymetrics.statistics.domain.Saving;
import com.piggymetrics.statistics.domain.timeseries.DataPoint;
import com.piggymetrics.statistics.domain.timeseries.DataPointId;
import com.piggymetrics.statistics.domain.timeseries.ItemMetric;
import com.piggymetrics.statistics.domain.timeseries.StatisticMetric;
import com.piggymetrics.statistics.repository.DataPointRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StatisticsServiceImplDiffblueTest {
  @MockBean
  private ExchangeRatesService exchangeRatesService;

  @MockBean
  private DataPointRepository dataPointRepository;

  @Autowired
  private StatisticsServiceImpl statisticsServiceImpl;
  @Test
  public void testFindByAccountName() {
    // Arrange
    ArrayList<DataPoint> dataPointList = new ArrayList<DataPoint>();
    when(this.dataPointRepository.findByIdAccount((String) any())).thenReturn(dataPointList);

    // Act
    List<DataPoint> actualFindByAccountNameResult = this.statisticsServiceImpl.findByAccountName("Dr Jane Doe");

    // Assert
    assertSame(dataPointList, actualFindByAccountNameResult);
    assertTrue(actualFindByAccountNameResult.isEmpty());
    verify(this.dataPointRepository).findByIdAccount((String) any());
  }

  @Test
  public void testSave() {
    // Arrange
    when(this.exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<Currency, BigDecimal>(1));
    when(this.exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<ItemMetric>());
    dataPoint.setRates(new HashMap<Currency, BigDecimal>(1));
    dataPoint.setIncomes(new HashSet<ItemMetric>());
    dataPoint.setId(new DataPointId("3", new Date(1L)));
    dataPoint.setStatistics(new HashMap<StatisticMetric, BigDecimal>(1));
    when(this.dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Saving saving = new Saving();
    saving.setInterest(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);

    Account account = new Account();
    account.setIncomes(new ArrayList<Item>());
    account.setExpenses(new ArrayList<Item>());
    account.setSaving(saving);

    // Act and Assert
    assertSame(dataPoint, this.statisticsServiceImpl.save("Dr Jane Doe", account));
    verify(this.exchangeRatesService).convert((Currency) any(), (Currency) any(), (BigDecimal) any());
    verify(this.exchangeRatesService).getCurrentRates();
    verify(this.dataPointRepository).save((DataPoint) any());
  }
}

