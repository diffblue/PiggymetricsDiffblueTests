package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import org.junit.Test;

public class ItemMetricDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ItemMetric#equals(Object)}
   *   <li>{@link ItemMetric#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Dr", new BigDecimal("2.3"));
    ItemMetric itemMetric2 = new ItemMetric("Dr", new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(itemMetric, itemMetric2);
    int expectedHashCodeResult = itemMetric.hashCode();
    assertEquals(expectedHashCodeResult, itemMetric2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ItemMetric#equals(Object)}
   *   <li>{@link ItemMetric#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Dr", new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(itemMetric, itemMetric);
    int expectedHashCodeResult = itemMetric.hashCode();
    assertEquals(expectedHashCodeResult, itemMetric.hashCode());
  }

  /**
   * Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Mr", new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(itemMetric, new ItemMetric("Dr", new BigDecimal("2.3")));
  }

  /**
   * Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ItemMetric("Dr", new BigDecimal("2.3")), null);
  }

  /**
   * Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ItemMetric("Dr", new BigDecimal("2.3")), "Different type to ItemMetric");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ItemMetric#ItemMetric(String, BigDecimal)}
   *   <li>{@link ItemMetric#getAmount()}
   *   <li>{@link ItemMetric#getTitle()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BigDecimal amount = new BigDecimal("2.3");

    // Act
    ItemMetric actualItemMetric = new ItemMetric("Dr", amount);
    BigDecimal actualAmount = actualItemMetric.getAmount();

    // Assert
    assertEquals("Dr", actualItemMetric.getTitle());
    assertEquals(new BigDecimal("2.3"), actualAmount);
    assertSame(amount, actualAmount);
  }
}
