package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

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
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
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
        // Arrange
        DataPoint dataPoint = new DataPoint();
        HashSet<ItemMetric> expenses = new HashSet<>();

        // Act
        dataPoint.setExpenses(expenses);
        DataPointId id = new DataPointId("3",
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        dataPoint.setId(id);
        HashSet<ItemMetric> incomes = new HashSet<>();
        dataPoint.setIncomes(incomes);
        HashMap<Currency, BigDecimal> rates = new HashMap<>();
        dataPoint.setRates(rates);
        HashMap<StatisticMetric, BigDecimal> statistics = new HashMap<>();
        dataPoint.setStatistics(statistics);
        Set<ItemMetric> actualExpenses = dataPoint.getExpenses();
        DataPointId actualId = dataPoint.getId();
        Set<ItemMetric> actualIncomes = dataPoint.getIncomes();
        Map<Currency, BigDecimal> actualRates = dataPoint.getRates();
        Map<StatisticMetric, BigDecimal> actualStatistics = dataPoint.getStatistics();

        // Assert
        assertTrue(actualRates.isEmpty());
        assertTrue(actualStatistics.isEmpty());
        assertTrue(actualExpenses.isEmpty());
        assertTrue(actualIncomes.isEmpty());
        assertSame(id, actualId);
        assertSame(rates, actualRates);
        assertSame(statistics, actualStatistics);
        assertSame(expenses, actualExpenses);
        assertSame(incomes, actualIncomes);
    }
}
