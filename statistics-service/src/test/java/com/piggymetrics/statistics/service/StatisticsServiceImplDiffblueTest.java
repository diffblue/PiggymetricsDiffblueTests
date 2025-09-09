package com.piggymetrics.statistics.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.piggymetrics.statistics.domain.Account;
import com.piggymetrics.statistics.domain.Currency;
import com.piggymetrics.statistics.domain.Item;
import com.piggymetrics.statistics.domain.Saving;
import com.piggymetrics.statistics.domain.TimePeriod;
import com.piggymetrics.statistics.domain.timeseries.DataPoint;
import com.piggymetrics.statistics.domain.timeseries.DataPointId;
import com.piggymetrics.statistics.repository.DataPointRepository;
import java.math.BigDecimal;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {StatisticsServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StatisticsServiceImplDiffblueTest {
  @MockBean private DataPointRepository dataPointRepository;

  @MockBean private ExchangeRatesService exchangeRatesService;

  @Autowired private StatisticsServiceImpl statisticsServiceImpl;

  /**
   * Test {@link StatisticsServiceImpl#findByAccountName(String)}.
   *
   * <ul>
   *   <li>When {@code Dr Jane Doe}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsServiceImpl#findByAccountName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List StatisticsServiceImpl.findByAccountName(String)"})
  public void testFindByAccountName_whenDrJaneDoe_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(statisticsServiceImpl.findByAccountName("Dr Jane Doe").isEmpty());
  }

  /**
   * Test {@link StatisticsServiceImpl#save(String, Account)}.
   *
   * <ul>
   *   <li>Given {@link Item} (default constructor) Currency is {@code USD}.
   *   <li>Then return {@link DataPoint} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPoint StatisticsServiceImpl.save(String, Account)"})
  public void testSave_givenItemCurrencyIsUsd_thenReturnDataPoint() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert(
            Mockito.<Currency>any(), Mockito.<Currency>any(), Mockito.<BigDecimal>any()))
        .thenReturn(new BigDecimal("2.3"));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    Date date =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    DataPointId id = new DataPointId("3", date);
    dataPoint.setId(id);
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(dataPointRepository.save(Mockito.<DataPoint>any())).thenReturn(dataPoint);

    Item item = new Item();
    item.setAmount(new BigDecimal("2.3"));
    item.setCurrency(Currency.USD);
    item.setPeriod(TimePeriod.YEAR);
    item.setTitle("Dr");

    ArrayList<Item> expenses = new ArrayList<>();
    expenses.add(item);

    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Account account = new Account();
    account.setExpenses(expenses);
    account.setIncomes(new ArrayList<>());
    account.setSaving(saving);

    // Act
    DataPoint actualSaveResult = statisticsServiceImpl.save("Dr Jane Doe", account);

    // Assert
    verify(exchangeRatesService, atLeast(1))
        .convert(eq(Currency.USD), eq(Currency.USD), isA(BigDecimal.class));
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save(isA(DataPoint.class));
    assertSame(dataPoint, actualSaveResult);
  }

  /**
   * Test {@link StatisticsServiceImpl#save(String, Account)}.
   *
   * <ul>
   *   <li>Given {@link Item} (default constructor) Currency is {@code USD}.
   *   <li>Then return {@link DataPoint} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPoint StatisticsServiceImpl.save(String, Account)"})
  public void testSave_givenItemCurrencyIsUsd_thenReturnDataPoint2() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert(
            Mockito.<Currency>any(), Mockito.<Currency>any(), Mockito.<BigDecimal>any()))
        .thenReturn(new BigDecimal("2.3"));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    Date date =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    DataPointId id = new DataPointId("3", date);
    dataPoint.setId(id);
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(dataPointRepository.save(Mockito.<DataPoint>any())).thenReturn(dataPoint);

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

    ArrayList<Item> expenses = new ArrayList<>();
    expenses.add(item2);
    expenses.add(item);

    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Account account = new Account();
    account.setExpenses(expenses);
    account.setIncomes(new ArrayList<>());
    account.setSaving(saving);

    // Act
    DataPoint actualSaveResult = statisticsServiceImpl.save("Dr Jane Doe", account);

    // Assert
    verify(exchangeRatesService, atLeast(1))
        .convert(Mockito.<Currency>any(), eq(Currency.USD), isA(BigDecimal.class));
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save(isA(DataPoint.class));
    assertSame(dataPoint, actualSaveResult);
  }

  /**
   * Test {@link StatisticsServiceImpl#save(String, Account)}.
   *
   * <ul>
   *   <li>Given {@link Item} (default constructor) Currency is {@code USD}.
   *   <li>Then return {@link DataPoint} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPoint StatisticsServiceImpl.save(String, Account)"})
  public void testSave_givenItemCurrencyIsUsd_thenReturnDataPoint3() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert(
            Mockito.<Currency>any(), Mockito.<Currency>any(), Mockito.<BigDecimal>any()))
        .thenReturn(new BigDecimal("2.3"));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    Date date =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    DataPointId id = new DataPointId("3", date);
    dataPoint.setId(id);
    dataPoint.setIncomes(new HashSet<>());
    dataPoint.setRates(new HashMap<>());
    dataPoint.setStatistics(new HashMap<>());
    when(dataPointRepository.save(Mockito.<DataPoint>any())).thenReturn(dataPoint);

    Item item = new Item();
    item.setAmount(new BigDecimal("2.3"));
    item.setCurrency(Currency.USD);
    item.setPeriod(TimePeriod.YEAR);
    item.setTitle("Dr");

    ArrayList<Item> incomes = new ArrayList<>();
    incomes.add(item);

    Saving saving = new Saving();
    saving.setAmount(new BigDecimal("2.3"));
    saving.setCapitalization(true);
    saving.setCurrency(Currency.USD);
    saving.setDeposit(true);
    saving.setInterest(new BigDecimal("2.3"));

    Account account = new Account();
    account.setExpenses(new ArrayList<>());
    account.setIncomes(incomes);
    account.setSaving(saving);

    // Act
    DataPoint actualSaveResult = statisticsServiceImpl.save("Dr Jane Doe", account);

    // Assert
    verify(exchangeRatesService, atLeast(1))
        .convert(eq(Currency.USD), eq(Currency.USD), isA(BigDecimal.class));
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save(isA(DataPoint.class));
    assertSame(dataPoint, actualSaveResult);
  }

  /**
   * Test {@link StatisticsServiceImpl#save(String, Account)}.
   *
   * <ul>
   *   <li>Then return {@link DataPoint} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StatisticsServiceImpl#save(String, Account)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPoint StatisticsServiceImpl.save(String, Account)"})
  public void testSave_thenReturnDataPoint() {
    // Arrange
    when(exchangeRatesService.getCurrentRates()).thenReturn(new HashMap<>());
    when(exchangeRatesService.convert(
            Mockito.<Currency>any(), Mockito.<Currency>any(), Mockito.<BigDecimal>any()))
        .thenReturn(new BigDecimal("2.3"));

    DataPoint dataPoint = new DataPoint();
    dataPoint.setExpenses(new HashSet<>());
    Date date =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    DataPointId id = new DataPointId("3", date);
    dataPoint.setId(id);
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
    verify(exchangeRatesService).convert(eq(Currency.USD), eq(Currency.USD), isA(BigDecimal.class));
    verify(exchangeRatesService).getCurrentRates();
    verify(dataPointRepository).save(isA(DataPoint.class));
    assertSame(dataPoint, actualSaveResult);
  }
}
