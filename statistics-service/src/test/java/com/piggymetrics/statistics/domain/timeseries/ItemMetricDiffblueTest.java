package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Rule;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ItemMetricDiffblueTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
        ItemMetric itemMetric = new ItemMetric("Mr", new BigDecimal("2.6"));

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
        ItemMetric itemMetric = new ItemMetric("Dr", new BigDecimal("2.6"));

        // Act and Assert
        assertNotEquals(itemMetric, new ItemMetric("Mr", new BigDecimal("2.6")));
    }

    /**
     * Test {@link ItemMetric#equals(Object)}.
     * <ul>
     *   <li>When other is different.</li>
     *   <li>Then throw exception.</li>
     * </ul>
     * <p>
     * Method under test: {@link ItemMetric#equals(Object)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testEquals_whenOtherIsDifferent_thenThrowException() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equalsIgnoreCase(String)" because "this.title" is null
        //       at com.piggymetrics.statistics.domain.timeseries.ItemMetric.equals(ItemMetric.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        ItemMetric itemMetric = new ItemMetric(null, new BigDecimal("2.6"));

        // Act and Assert
        thrown.expect(NullPointerException.class);
        itemMetric.equals(new ItemMetric("Mr", new BigDecimal("2.6")));
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
        assertNotEquals(new ItemMetric("Mr", new BigDecimal("2.6")), null);
    }

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
        ItemMetric itemMetric = new ItemMetric("Mr", new BigDecimal("2.6"));
        ItemMetric itemMetric2 = new ItemMetric("Mr", new BigDecimal("2.6"));

        // Act and Assert
        assertEquals(itemMetric, itemMetric2);
        int expectedHashCodeResult = itemMetric.hashCode();
        assertEquals(expectedHashCodeResult, itemMetric2.hashCode());
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
        assertNotEquals(new ItemMetric("Mr", new BigDecimal("2.6")), "Different type to ItemMetric");
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
        BigDecimal amount = new BigDecimal("2.6");

        // Act
        ItemMetric actualItemMetric = new ItemMetric("Mr", amount);
        BigDecimal actualAmount = actualItemMetric.getAmount();

        // Assert
        assertEquals("Mr", actualItemMetric.getTitle());
        assertEquals(new BigDecimal("2.6"), actualAmount);
        assertSame(amount, actualAmount);
    }
}
