package com.piggymetrics.statistics.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StatisticsServiceImplDiffblueTest {
  @MockBean
  private ExchangeRatesService exchangeRatesService;

  @MockBean
  private DataPointRepository dataPointRepository;

  @MockBean
  private MongodExecutable mongodExecutable;

  @Autowired
  private StatisticsServiceImpl statisticsServiceImpl;
  /**
  * Method under test: {@link StatisticsServiceImpl#findByAccountName(String)}
  */
  @Test
  public void testFindByAccountName() {
    // Arrange
    ArrayList<DataPoint> dataPointList = new ArrayList<>();
    when(dataPointRepository.findByIdAccount((String) any())).thenReturn(dataPointList);

    // Act
    List<DataPoint> actualFindByAccountNameResult = statisticsServiceImpl.findByAccountName("Dr Jane Doe");

    // Assert
    assertSame(dataPointList, actualFindByAccountNameResult);
    assertTrue(actualFindByAccountNameResult.isEmpty());
    verify(dataPointRepository).findByIdAccount((String) any());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  public void testSave() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    dataPoint.setId(new DataPointId("3", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

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
    assertSame(dataPoint, statisticsServiceImpl.save("Dr Jane Doe", account));
    verify(exchangeRatesService).convert((Currency) any(), (Currency) any(), (BigDecimal) any());
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save((DataPoint) any());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  public void testSave2() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    dataPoint.setId(new DataPointId("3", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Saving saving = new Saving();
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(BigDecimal.valueOf(1L));

    Saving saving1 = new Saving();
    saving1.setAmount(BigDecimal.valueOf(1L));
    saving1.setCapitalization(true);
    saving1.setCurrency(Currency.USD);
    saving1.setDeposit(true);
    saving1.setInterest(BigDecimal.valueOf(1L));

    Item item = new Item();
    item.setAmount(BigDecimal.valueOf(1L));
    item.setCurrency(Currency.USD);
    item.setPeriod(TimePeriod.YEAR);
    item.setTitle("Dr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item);
    Account account = mock(Account.class);
    when(account.getSaving()).thenReturn(saving1);
    when(account.getExpenses()).thenReturn(itemList);
    when(account.getIncomes()).thenReturn(new ArrayList<>());
    doNothing().when(account).setExpenses((List<Item>) any());
    doNothing().when(account).setIncomes((List<Item>) any());
    doNothing().when(account).setSaving((Saving) any());
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setSaving(saving);

    // Act and Assert
    assertSame(dataPoint, statisticsServiceImpl.save("Dr Jane Doe", account));
    verify(exchangeRatesService, atLeast(1)).convert((Currency) any(), (Currency) any(), (BigDecimal) any());
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save((DataPoint) any());
    verify(account).getSaving();
    verify(account).getExpenses();
    verify(account).getIncomes();
    verify(account).setExpenses((List<Item>) any());
    verify(account).setIncomes((List<Item>) any());
    verify(account).setSaving((Saving) any());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  public void testSave3() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    dataPoint.setId(new DataPointId("3", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Saving saving = new Saving();
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(BigDecimal.valueOf(1L));

    Saving saving1 = new Saving();
    saving1.setAmount(BigDecimal.valueOf(1L));
    saving1.setCapitalization(true);
    saving1.setCurrency(Currency.USD);
    saving1.setDeposit(true);
    saving1.setInterest(BigDecimal.valueOf(1L));

    Item item = new Item();
    item.setAmount(BigDecimal.valueOf(1L));
    item.setCurrency(Currency.USD);
    item.setPeriod(TimePeriod.YEAR);
    item.setTitle("Dr");

    Item item1 = new Item();
    item1.setAmount(BigDecimal.valueOf(4L));
    item1.setCurrency(Currency.USD);
    item1.setPeriod(TimePeriod.YEAR);
    item1.setTitle("Dr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item1);
    itemList.add(item);
    Account account = mock(Account.class);
    when(account.getSaving()).thenReturn(saving1);
    when(account.getExpenses()).thenReturn(itemList);
    when(account.getIncomes()).thenReturn(new ArrayList<>());
    doNothing().when(account).setExpenses((List<Item>) any());
    doNothing().when(account).setIncomes((List<Item>) any());
    doNothing().when(account).setSaving((Saving) any());
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setSaving(saving);

    // Act and Assert
    assertSame(dataPoint, statisticsServiceImpl.save("Dr Jane Doe", account));
    verify(exchangeRatesService, atLeast(1)).convert((Currency) any(), (Currency) any(), (BigDecimal) any());
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save((DataPoint) any());
    verify(account).getSaving();
    verify(account).getExpenses();
    verify(account).getIncomes();
    verify(account).setExpenses((List<Item>) any());
    verify(account).setIncomes((List<Item>) any());
    verify(account).setSaving((Saving) any());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  public void testSave4() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert((Currency) any(), (Currency) any(), (BigDecimal) any()))
        .thenReturn(BigDecimal.valueOf(1L));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    dataPoint.setId(new DataPointId("3", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(dataPointRepository.save((DataPoint) any())).thenReturn(dataPoint);

    Saving saving = new Saving();
    saving.setAmount(BigDecimal.valueOf(1L));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(BigDecimal.valueOf(1L));

    Saving saving1 = new Saving();
    saving1.setAmount(BigDecimal.valueOf(1L));
    saving1.setCapitalization(true);
    saving1.setCurrency(Currency.USD);
    saving1.setDeposit(true);
    saving1.setInterest(BigDecimal.valueOf(1L));

    Item item = new Item();
    item.setAmount(BigDecimal.valueOf(1L));
    item.setCurrency(Currency.USD);
    item.setPeriod(TimePeriod.YEAR);
    item.setTitle("Dr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item);
    Account account = mock(Account.class);
    when(account.getSaving()).thenReturn(saving1);
    when(account.getExpenses()).thenReturn(new ArrayList<>());
    when(account.getIncomes()).thenReturn(itemList);
    doNothing().when(account).setExpenses((List<Item>) any());
    doNothing().when(account).setIncomes((List<Item>) any());
    doNothing().when(account).setSaving((Saving) any());
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setSaving(saving);

    // Act and Assert
    assertSame(dataPoint, statisticsServiceImpl.save("Dr Jane Doe", account));
    verify(exchangeRatesService, atLeast(1)).convert((Currency) any(), (Currency) any(), (BigDecimal) any());
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save((DataPoint) any());
    verify(account).getSaving();
    verify(account).getExpenses();
    verify(account).getIncomes();
    verify(account).setExpenses((List<Item>) any());
    verify(account).setIncomes((List<Item>) any());
    verify(account).setSaving((Saving) any());
  }
}

