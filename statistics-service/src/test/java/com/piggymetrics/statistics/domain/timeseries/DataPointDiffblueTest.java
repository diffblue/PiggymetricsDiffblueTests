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
import org.junit.Test;

public class DataPointDiffblueTest {
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

