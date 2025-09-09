package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ItemMetricDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ItemMetric#ItemMetric(String, BigDecimal)}
   *   <li>{@link ItemMetric#getAmount()}
   *   <li>{@link ItemMetric#getTitle()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ItemMetric.<init>(String, BigDecimal)",
    "BigDecimal ItemMetric.getAmount()",
    "String ItemMetric.getTitle()"
  })
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

  /**
   * Test {@link ItemMetric#equals(Object)}, and {@link ItemMetric#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ItemMetric#equals(Object)}
   *   <li>{@link ItemMetric#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ItemMetric.equals(Object)", "int ItemMetric.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Dr", new BigDecimal("2.3"));
    ItemMetric itemMetric2 = new ItemMetric("Dr", new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(itemMetric, itemMetric2);
    assertEquals(itemMetric.hashCode(), itemMetric2.hashCode());
  }

  /**
   * Test {@link ItemMetric#equals(Object)}, and {@link ItemMetric#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ItemMetric#equals(Object)}
   *   <li>{@link ItemMetric#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ItemMetric.equals(Object)", "int ItemMetric.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ItemMetric.equals(Object)", "int ItemMetric.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Mr", new BigDecimal("2.3"));
    ItemMetric itemMetric2 = new ItemMetric("Dr", new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(itemMetric, itemMetric2);
  }

  /**
   * Test {@link ItemMetric#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ItemMetric.equals(Object)", "int ItemMetric.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Dr", new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(itemMetric, null);
  }

  /**
   * Test {@link ItemMetric#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ItemMetric#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ItemMetric.equals(Object)", "int ItemMetric.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ItemMetric itemMetric = new ItemMetric("Dr", new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(itemMetric, "Different type to ItemMetric");
  }
}
