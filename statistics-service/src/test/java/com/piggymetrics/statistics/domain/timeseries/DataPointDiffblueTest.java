package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertSame;
import com.piggymetrics.statistics.domain.Currency;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
  public void testConstructor() {
    // Arrange and Act
    DataPoint actualDataPoint = new DataPoint();
    HashSet<ItemMetric> itemMetricSet = new HashSet<>();
    actualDataPoint.setExpenses(itemMetricSet);
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    DataPointId dataPointId = new DataPointId("3", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));

    actualDataPoint.setId(dataPointId);
    HashSet<ItemMetric> itemMetricSet1 = new HashSet<>();
    actualDataPoint.setIncomes(itemMetricSet1);
    HashMap<Currency, BigDecimal> currencyBigDecimalMap = new HashMap<>();
    actualDataPoint.setRates(currencyBigDecimalMap);
    HashMap<StatisticMetric, BigDecimal> statisticMetricBigDecimalMap = new HashMap<>();
    actualDataPoint.setStatistics(statisticMetricBigDecimalMap);

    // Assert
    assertSame(itemMetricSet, actualDataPoint.getExpenses());
    assertSame(dataPointId, actualDataPoint.getId());
    assertSame(itemMetricSet1, actualDataPoint.getIncomes());
    assertSame(currencyBigDecimalMap, actualDataPoint.getRates());
    assertSame(statisticMetricBigDecimalMap, actualDataPoint.getStatistics());
  }
}

