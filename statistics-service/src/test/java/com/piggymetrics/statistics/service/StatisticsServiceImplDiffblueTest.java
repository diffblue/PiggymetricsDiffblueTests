package com.piggymetrics.statistics.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
    when(dataPointRepository.findByIdAccount(Mockito.<String>any())).thenReturn(dataPointList);

    // Act
    List<DataPoint> actualFindByAccountNameResult = statisticsServiceImpl.findByAccountName("Dr Jane Doe");

    // Assert
    verify(dataPointRepository).findByIdAccount(Mockito.<String>any());
    assertTrue(actualFindByAccountNameResult.isEmpty());
    assertSame(dataPointList, actualFindByAccountNameResult);
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  public void testSave() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert(Mockito.<Currency>any(), Mockito.<Currency>any(), Mockito.<BigDecimal>any()))
        .thenReturn(new BigDecimal("2.3"));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    dataPoint.setId(
        new DataPointId("3", Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(dataPointRepository.save(Mockito.<DataPoint>any())).thenReturn(dataPoint);

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

    // Act
    DataPoint actualSaveResult = statisticsServiceImpl.save("Dr Jane Doe", account);

    // Assert
    verify(exchangeRatesService).convert(Mockito.<Currency>any(), Mockito.<Currency>any(), Mockito.<BigDecimal>any());
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save(Mockito.<DataPoint>any());
    assertSame(dataPoint, actualSaveResult);
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  public void testSave2() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert(Mockito.<Currency>any(), Mockito.<Currency>any(), Mockito.<BigDecimal>any()))
        .thenReturn(new BigDecimal("2.3"));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    dataPoint.setId(
        new DataPointId("3", Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(dataPointRepository.save(Mockito.<DataPoint>any())).thenReturn(dataPoint);

    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Saving saving2 = new Saving();
    saving2.setAmount(new BigDecimal("2.3"));
    saving2.setCapitalization(true);
    saving2.setCurrency(Currency.USD);
    saving2.setDeposit(true);
    saving2.setInterest(new BigDecimal("2.3"));

    Item item = new Item();
    item.setAmount(new BigDecimal("2.3"));
    item.setCurrency(Currency.USD);
    item.setPeriod(TimePeriod.YEAR);
    item.setTitle("Dr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item);
    Account account = mock(Account.class);
    when(account.getSaving()).thenReturn(saving2);
    when(account.getExpenses()).thenReturn(itemList);
    when(account.getIncomes()).thenReturn(new ArrayList<>());
    doNothing().when(account).setExpenses(Mockito.<List<Item>>any());
    doNothing().when(account).setIncomes(Mockito.<List<Item>>any());
    doNothing().when(account).setSaving(Mockito.<Saving>any());
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setSaving(saving);

    // Act
    DataPoint actualSaveResult = statisticsServiceImpl.save("Dr Jane Doe", account);

    // Assert
    verify(account).getExpenses();
    verify(account).getIncomes();
    verify(account).getSaving();
    verify(account).setExpenses(Mockito.<List<Item>>any());
    verify(account).setIncomes(Mockito.<List<Item>>any());
    verify(account).setSaving(Mockito.<Saving>any());
    verify(exchangeRatesService, atLeast(1)).convert(Mockito.<Currency>any(), Mockito.<Currency>any(),
        Mockito.<BigDecimal>any());
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save(Mockito.<DataPoint>any());
    assertSame(dataPoint, actualSaveResult);
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  public void testSave3() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert(Mockito.<Currency>any(), Mockito.<Currency>any(), Mockito.<BigDecimal>any()))
        .thenReturn(new BigDecimal("2.3"));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    dataPoint.setId(
        new DataPointId("3", Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(dataPointRepository.save(Mockito.<DataPoint>any())).thenReturn(dataPoint);

    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Saving saving2 = new Saving();
    saving2.setAmount(new BigDecimal("2.3"));
    saving2.setCapitalization(true);
    saving2.setCurrency(Currency.USD);
    saving2.setDeposit(true);
    saving2.setInterest(new BigDecimal("2.3"));

    Item item = new Item();
    item.setAmount(new BigDecimal("2.3"));
    item.setCurrency(Currency.USD);
    item.setPeriod(TimePeriod.YEAR);
    item.setTitle("Dr");

    Item item2 = new Item();
    item2.setAmount(new BigDecimal("2.3"));
    item2.setCurrency(Currency.EUR);
    item2.setPeriod(TimePeriod.QUARTER);
    item2.setTitle("Mr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item2);
    itemList.add(item);
    Account account = mock(Account.class);
    when(account.getSaving()).thenReturn(saving2);
    when(account.getExpenses()).thenReturn(itemList);
    when(account.getIncomes()).thenReturn(new ArrayList<>());
    doNothing().when(account).setExpenses(Mockito.<List<Item>>any());
    doNothing().when(account).setIncomes(Mockito.<List<Item>>any());
    doNothing().when(account).setSaving(Mockito.<Saving>any());
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setSaving(saving);

    // Act
    DataPoint actualSaveResult = statisticsServiceImpl.save("Dr Jane Doe", account);

    // Assert
    verify(account).getExpenses();
    verify(account).getIncomes();
    verify(account).getSaving();
    verify(account).setExpenses(Mockito.<List<Item>>any());
    verify(account).setIncomes(Mockito.<List<Item>>any());
    verify(account).setSaving(Mockito.<Saving>any());
    verify(exchangeRatesService, atLeast(1)).convert(Mockito.<Currency>any(), Mockito.<Currency>any(),
        Mockito.<BigDecimal>any());
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save(Mockito.<DataPoint>any());
    assertSame(dataPoint, actualSaveResult);
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  public void testSave4() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert(Mockito.<Currency>any(), Mockito.<Currency>any(), Mockito.<BigDecimal>any()))
        .thenReturn(new BigDecimal("2.3"));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    dataPoint.setId(
        new DataPointId("3", Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(dataPointRepository.save(Mockito.<DataPoint>any())).thenReturn(dataPoint);

    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Saving saving2 = new Saving();
    saving2.setAmount(new BigDecimal("2.3"));
    saving2.setCapitalization(true);
    saving2.setCurrency(Currency.USD);
    saving2.setDeposit(true);
    saving2.setInterest(new BigDecimal("2.3"));

    Item item = new Item();
    item.setAmount(new BigDecimal("2.3"));
    item.setCurrency(Currency.USD);
    item.setPeriod(TimePeriod.YEAR);
    item.setTitle("Dr");

    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(item);
    Account account = mock(Account.class);
    when(account.getSaving()).thenReturn(saving2);
    when(account.getExpenses()).thenReturn(new ArrayList<>());
    when(account.getIncomes()).thenReturn(itemList);
    doNothing().when(account).setExpenses(Mockito.<List<Item>>any());
    doNothing().when(account).setIncomes(Mockito.<List<Item>>any());
    doNothing().when(account).setSaving(Mockito.<Saving>any());
    account.setExpenses(new ArrayList<>());
    account.setIncomes(new ArrayList<>());
    account.setSaving(saving);

    // Act
    DataPoint actualSaveResult = statisticsServiceImpl.save("Dr Jane Doe", account);

    // Assert
    verify(account).getExpenses();
    verify(account).getIncomes();
    verify(account).getSaving();
    verify(account).setExpenses(Mockito.<List<Item>>any());
    verify(account).setIncomes(Mockito.<List<Item>>any());
    verify(account).setSaving(Mockito.<Saving>any());
    verify(exchangeRatesService, atLeast(1)).convert(Mockito.<Currency>any(), Mockito.<Currency>any(),
        Mockito.<BigDecimal>any());
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save(Mockito.<DataPoint>any());
    assertSame(dataPoint, actualSaveResult);
  }
}

