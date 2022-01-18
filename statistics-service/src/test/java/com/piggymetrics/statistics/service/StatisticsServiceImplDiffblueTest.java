package com.piggymetrics.statistics.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import de.flapdoodle.embed.mongo.MongodExecutable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

  @MockBean
  private MongodExecutable mongodExecutable;

  @Autowired
  private StatisticsServiceImpl statisticsServiceImpl;
  @Test
  public void testFindByAccountName() {
    // Arrange
    ArrayList<DataPoint> dataPointList = new ArrayList<>();
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
    when(this.exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(this.exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    dataPoint.setId(new DataPointId("3", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(this.dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Saving saving = new Saving();
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(BigDecimal.valueOf(1L));

    Account account = new Account();
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
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
    when(this.exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(this.exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    dataPoint.setId(new DataPointId("3", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(this.dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Item item = new Item();
    item.setAmount(BigDecimal.valueOf(0L));
    item.setCurrency(Currency.USD);
    item.setPeriod(TimePeriod.YEAR);
    item.setTitle("Dr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item);

    Saving saving = new Saving();
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(BigDecimal.valueOf(1L));

    Account account = new Account();
    account.setExpenses(itemList);
    account.setIncomes(new ArrayList<>());
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
    when(this.exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(this.exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    dataPoint.setId(new DataPointId("3", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(this.dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Item item = new Item();
    item.setAmount(BigDecimal.valueOf(0L));
    item.setCurrency(Currency.USD);
    item.setPeriod(TimePeriod.YEAR);
    item.setTitle("Dr");

    Item item1 = new Item();
    item1.setAmount(BigDecimal.valueOf(0L));
    item1.setCurrency(Currency.USD);
    item1.setPeriod(TimePeriod.YEAR);
    item1.setTitle("Dr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item1);
    itemList.add(item);

    Saving saving = new Saving();
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(BigDecimal.valueOf(1L));

    Account account = new Account();
    account.setExpenses(itemList);
    account.setIncomes(new ArrayList<>());
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
    when(this.exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(this.exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    dataPoint.setId(new DataPointId("3", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(this.dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Item item = new Item();
    item.setAmount(BigDecimal.valueOf(0L));
    item.setCurrency(Currency.USD);
    item.setPeriod(TimePeriod.YEAR);
    item.setTitle("Dr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item);

    Saving saving = new Saving();
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(BigDecimal.valueOf(1L));

    Account account = new Account();
    account.setExpenses(new ArrayList<>());
    account.setIncomes(itemList);
    account.setSaving(saving);

    // Act and Assert
    assertSame(dataPoint, this.statisticsServiceImpl.save("Dr Jane Doe", account));
    verify(this.exchangeRatesService, atLeast(1)).convert((Currency) any(), (Currency) any(), (BigDecimal) any());
    verify(this.exchangeRatesService).getCurrentRates();
    verify(this.dataPointRepository).save((DataPoint) any());
  }
}

