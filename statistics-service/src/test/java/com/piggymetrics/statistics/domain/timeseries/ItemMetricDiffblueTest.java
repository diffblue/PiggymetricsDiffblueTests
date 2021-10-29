package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import org.junit.Test;

public class ItemMetricDiffblueTest {
  @Test
  public void testConstructor() {
    // Arrange
    BigDecimal valueOfResult = BigDecimal.valueOf(1L);

    // Act
    ItemMetric actualItemMetric = new ItemMetric("Dr", valueOfResult);

    // Assert
    BigDecimal expectedAmount = valueOfResult.ONE;
    assertSame(expectedAmount, actualItemMetric.getAmount());
    assertEquals("Dr", actualItemMetric.getTitle());
  }

  @Test
  public void testEquals() {
    // Arrange, Act and Assert
    assertFalse((new ItemMetric("Dr", BigDecimal.valueOf(1L))).equals(null));
    assertFalse((new ItemMetric("Dr", BigDecimal.valueOf(1L))).equals("Different type to ItemMetric"));
    assertFalse((new ItemMetric(null, BigDecimal.valueOf(1L))).equals(null));
  }

  @Test
  public void testEquals2() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Dr", BigDecimal.valueOf(1L));

    // Act and Assert
    assertTrue(itemMetric.equals(itemMetric));
    int expectedHashCodeResult = itemMetric.hashCode();
    assertEquals(expectedHashCodeResult, itemMetric.hashCode());
  }

  @Test
  public void testEquals3() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Dr", BigDecimal.valueOf(1L));
    ItemMetric itemMetric1 = new ItemMetric("Dr", BigDecimal.valueOf(1L));

    // Act and Assert
    assertTrue(itemMetric.equals(itemMetric1));
    int expectedHashCodeResult = itemMetric.hashCode();
    assertEquals(expectedHashCodeResult, itemMetric1.hashCode());
  }
}

