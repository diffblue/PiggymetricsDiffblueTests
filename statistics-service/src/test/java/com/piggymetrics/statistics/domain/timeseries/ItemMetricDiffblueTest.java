package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import org.junit.Test;

public class ItemMetricDiffblueTest {
  /**
   * Test {@link ItemMetric#equals(Object)}, and {@link ItemMetric#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link ItemMetric#equals(Object)}, and {@link ItemMetric#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link ItemMetric#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link ItemMetric#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ItemMetric("Dr", new BigDecimal("2.3")), null);
  }

  /**
   * Test {@link ItemMetric#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ItemMetric("Dr", new BigDecimal("2.3")), "Different type to ItemMetric");
  }

  /**
   * Test getters and setters.
   * <p>
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
