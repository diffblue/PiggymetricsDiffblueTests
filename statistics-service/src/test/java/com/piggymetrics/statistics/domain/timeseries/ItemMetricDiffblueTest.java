package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import org.junit.Test;

public class ItemMetricDiffblueTest {
  /**
  * Method under test: default or parameterless constructor of {@link ItemMetric}
  */
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

  /**
   * Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  public void testEquals() {
    // Arrange, Act and Assert
    assertNotEquals(new ItemMetric("Dr", BigDecimal.valueOf(1L)), null);
    assertNotEquals(new ItemMetric("Dr", BigDecimal.valueOf(1L)), "Different type to ItemMetric");
  }

  /**
   * Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  public void testEquals2() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Dr", BigDecimal.valueOf(1L));

    // Act and Assert
    assertEquals(itemMetric, itemMetric);
    int expectedHashCodeResult = itemMetric.hashCode();
    assertEquals(expectedHashCodeResult, itemMetric.hashCode());
  }

  /**
   * Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  public void testEquals3() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Dr", BigDecimal.valueOf(1L));
    ItemMetric itemMetric1 = new ItemMetric("Dr", BigDecimal.valueOf(1L));

    // Act and Assert
    assertEquals(itemMetric, itemMetric1);
    int expectedHashCodeResult = itemMetric.hashCode();
    assertEquals(expectedHashCodeResult, itemMetric1.hashCode());
  }

  /**
   * Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  public void testEquals4() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Title", BigDecimal.valueOf(1L));

    // Act and Assert
    assertNotEquals(itemMetric, new ItemMetric("Dr", BigDecimal.valueOf(1L)));
  }
}

