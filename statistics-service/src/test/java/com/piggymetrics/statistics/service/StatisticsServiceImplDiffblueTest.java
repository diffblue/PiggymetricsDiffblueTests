package com.piggymetrics.statistics.service;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.statistics.domain.Account;
import com.piggymetrics.statistics.domain.Currency;
import com.piggymetrics.statistics.domain.Item;
import com.piggymetrics.statistics.domain.Saving;
import com.piggymetrics.statistics.domain.TimePeriod;
import com.piggymetrics.statistics.domain.timeseries.DataPoint;
import com.piggymetrics.statistics.domain.timeseries.DataPointId;
import com.piggymetrics.statistics.repository.DataPointRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {StatisticsServiceImpl.class})
@RunWith(SpringRunner.class)
public class StatisticsServiceImplDiffblueTest {
  @MockBean
  private DataPointRepository dataPointRepository;

  @MockBean
  private ExchangeRatesService exchangeRatesService;

  @Autowired
  private StatisticsServiceImpl statisticsServiceImpl;
  @Test
  public void testSave() {
    // Arrange
    when(this.exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>(1));
    when(this.exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    dataPoint.setRates(new HashMap<>(1));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setId(new DataPointId("3", new Date(1L)));
    dataPoint.setStatistics(new HashMap<>(1));
    when(this.dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Saving saving = new Saving();
    saving.setInterest(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);

    Account account = new Account();
    account.setIncomes(new ArrayList<>());
    account.setExpenses(new ArrayList<>());
    account.setSaving(saving);

    // Act and Assert
    assertSame(dataPoint, this.statisticsServiceImpl.save("Dr Jane Doe", account));
    verify(this.exchangeRatesService).convert((Currency) any(), (Currency) any(), (BigDecimal) any());
    verify(this.exchangeRatesService).getCurrentRates();
    verify(this.dataPointRepository).save((DataPoint) any());
  }

  @Test
  public void testSave2() {
    // Arrange
    when(this.exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>(1));
    when(this.exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    dataPoint.setRates(new HashMap<>(1));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setId(new DataPointId("3", new Date(1L)));
    dataPoint.setStatistics(new HashMap<>(1));
    when(this.dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Item item = new Item();
    item.setPeriod(TimePeriod.YEAR);
    item.setAmount(BigDecimal.valueOf(1L));
    item.setCurrency(Currency.USD);
    item.setTitle("Dr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item);

    Saving saving = new Saving();
    saving.setInterest(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);

    Account account = new Account();
    account.setIncomes(itemList);
    account.setExpenses(new ArrayList<>());
    account.setSaving(saving);

    // Act and Assert
    assertSame(dataPoint, this.statisticsServiceImpl.save("Dr Jane Doe", account));
    verify(this.exchangeRatesService, atLeast(1)).convert((Currency) any(), (Currency) any(), (BigDecimal) any());
    verify(this.exchangeRatesService).getCurrentRates();
    verify(this.dataPointRepository).save((DataPoint) any());
  }

  @Test
  public void testSave3() {
    // Arrange
    when(this.exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>(1));
    when(this.exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    dataPoint.setRates(new HashMap<>(1));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setId(new DataPointId("3", new Date(1L)));
    dataPoint.setStatistics(new HashMap<>(1));
    when(this.dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Item item = new Item();
    item.setPeriod(TimePeriod.YEAR);
    item.setAmount(BigDecimal.valueOf(1L));
    item.setCurrency(Currency.USD);
    item.setTitle("Dr");

    Item item1 = new Item();
    item1.setPeriod(TimePeriod.YEAR);
    item1.setAmount(BigDecimal.valueOf(1L));
    item1.setCurrency(Currency.USD);
    item1.setTitle("Dr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item1);
    itemList.add(item);

    Saving saving = new Saving();
    saving.setInterest(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);

    Account account = new Account();
    account.setIncomes(itemList);
    account.setExpenses(new ArrayList<>());
    account.setSaving(saving);

    // Act and Assert
    assertSame(dataPoint, this.statisticsServiceImpl.save("Dr Jane Doe", account));
    verify(this.exchangeRatesService, atLeast(1)).convert((Currency) any(), (Currency) any(), (BigDecimal) any());
    verify(this.exchangeRatesService).getCurrentRates();
    verify(this.dataPointRepository).save((DataPoint) any());
  }

  @Test
  public void testSave4() {
    // Arrange
    when(this.exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>(1));
    when(this.exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    dataPoint.setRates(new HashMap<>(1));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setId(new DataPointId("3", new Date(1L)));
    dataPoint.setStatistics(new HashMap<>(1));
    when(this.dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Item item = new Item();
    item.setPeriod(TimePeriod.YEAR);
    item.setAmount(BigDecimal.valueOf(1L));
    item.setCurrency(Currency.USD);
    item.setTitle("Dr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item);

    Saving saving = new Saving();
    saving.setInterest(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);

    Account account = new Account();
    account.setIncomes(new ArrayList<>());
    account.setExpenses(itemList);
    account.setSaving(saving);

    // Act and Assert
    assertSame(dataPoint, this.statisticsServiceImpl.save("Dr Jane Doe", account));
    verify(this.exchangeRatesService, atLeast(1)).convert((Currency) any(), (Currency) any(), (BigDecimal) any());
    verify(this.exchangeRatesService).getCurrentRates();
    verify(this.dataPointRepository).save((DataPoint) any());
  }
}

