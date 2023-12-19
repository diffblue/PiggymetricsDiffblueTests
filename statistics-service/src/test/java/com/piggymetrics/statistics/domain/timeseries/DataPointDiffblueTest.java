package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertSame;
import com.piggymetrics.statistics.domain.Currency;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class DataPointDiffblueTest {
  /**
   * Methods under test:
   * 
   * <ul>
   *   <li>default or parameterless constructor of {@link DataPoint}
   *   <li>{@link DataPoint#setExpenses(Set)}
   *   <li>{@link DataPoint#setId(DataPointId)}
   *   <li>{@link DataPoint#setIncomes(Set)}
   *   <li>{@link DataPoint#setRates(Map)}
   *   <li>{@link DataPoint#setStatistics(Map)}
   *   <li>{@link DataPoint#getExpenses()}
   *   <li>{@link DataPoint#getId()}
   *   <li>{@link DataPoint#getIncomes()}
   *   <li>{@link DataPoint#getRates()}
   *   <li>{@link DataPoint#getStatistics()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DataPoint actualDataPoint = new DataPoint();
    HashSet<ItemMetric> expenses = new HashSet<>();
    actualDataPoint.setExpenses(expenses);
    DataPointId id = new DataPointId("3",
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    actualDataPoint.setId(id);
    HashSet<ItemMetric> incomes = new HashSet<>();
    actualDataPoint.setIncomes(incomes);
    HashMap<Currency, BigDecimal> rates = new HashMap<>();
    actualDataPoint.setRates(rates);
    HashMap<StatisticMetric, BigDecimal> statistics = new HashMap<>();
    actualDataPoint.setStatistics(statistics);
    Set<ItemMetric> actualExpenses = actualDataPoint.getExpenses();
    DataPointId actualId = actualDataPoint.getId();
    Set<ItemMetric> actualIncomes = actualDataPoint.getIncomes();
    Map<Currency, BigDecimal> actualRates = actualDataPoint.getRates();

    // Assert that nothing has changed
    assertSame(id, actualId);
    assertSame(rates, actualRates);
    assertSame(statistics, actualDataPoint.getStatistics());
    assertSame(expenses, actualExpenses);
    assertSame(incomes, actualIncomes);
  }
}
