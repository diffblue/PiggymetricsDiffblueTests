package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertSame;
import com.piggymetrics.statistics.domain.Currency;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;

public class DataPointDiffblueTest {
  @Test
  public void testConstructor() {
    // Arrange and Act
    DataPoint actualDataPoint = new DataPoint();
    HashSet<ItemMetric> itemMetricSet = new HashSet<ItemMetric>();
    actualDataPoint.setExpenses(itemMetricSet);
    DataPointId dataPointId = new DataPointId("3", new Date(1L));

    actualDataPoint.setId(dataPointId);
    HashSet<ItemMetric> itemMetricSet1 = new HashSet<ItemMetric>();
    actualDataPoint.setIncomes(itemMetricSet1);
    HashMap<Currency, BigDecimal> currencyBigDecimalMap = new HashMap<Currency, BigDecimal>(1);
    actualDataPoint.setRates(currencyBigDecimalMap);
    HashMap<StatisticMetric, BigDecimal> statisticMetricBigDecimalMap = new HashMap<StatisticMetric, BigDecimal>(1);
    actualDataPoint.setStatistics(statisticMetricBigDecimalMap);

    // Assert
    assertSame(itemMetricSet, actualDataPoint.getExpenses());
    assertSame(dataPointId, actualDataPoint.getId());
    assertSame(itemMetricSet1, actualDataPoint.getIncomes());
    assertSame(currencyBigDecimalMap, actualDataPoint.getRates());
    assertSame(statisticMetricBigDecimalMap, actualDataPoint.getStatistics());
  }
}

