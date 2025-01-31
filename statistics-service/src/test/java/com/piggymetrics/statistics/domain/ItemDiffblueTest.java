package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.math.BigDecimal;

import org.junit.Test;

public class ItemDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Item#setAmount(BigDecimal)}
     *   <li>{@link Item#setCurrency(Currency)}
     *   <li>{@link Item#setPeriod(TimePeriod)}
     *   <li>{@link Item#setTitle(String)}
     *   <li>{@link Item#getAmount()}
     *   <li>{@link Item#getCurrency()}
     *   <li>{@link Item#getPeriod()}
     *   <li>{@link Item#getTitle()}
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        // Arrange
        Item item = new Item();
        BigDecimal amount = new BigDecimal("2.3");

        // Act
        item.setAmount(amount);
        item.setCurrency(Currency.USD);
        item.setPeriod(TimePeriod.YEAR);
        item.setTitle("Dr");
        BigDecimal actualAmount = item.getAmount();
        Currency actualCurrency = item.getCurrency();
        TimePeriod actualPeriod = item.getPeriod();

        // Assert
        assertEquals("Dr", item.getTitle());
        assertEquals(Currency.USD, actualCurrency);
        assertEquals(TimePeriod.YEAR, actualPeriod);
        assertEquals(new BigDecimal("2.3"), actualAmount);
        assertSame(amount, actualAmount);
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Item#setAmount(BigDecimal)}
     *   <li>{@link Item#setCurrency(Currency)}
     *   <li>{@link Item#setPeriod(TimePeriod)}
     *   <li>{@link Item#setTitle(String)}
     *   <li>{@link Item#getAmount()}
     *   <li>{@link Item#getCurrency()}
     *   <li>{@link Item#getPeriod()}
     *   <li>{@link Item#getTitle()}
     * </ul>
     */
    @Test
    public void testGettersAndSetters2() {
        // Arrange
        Item item = new Item();
        BigDecimal amount = new BigDecimal("2.6");

        // Act
        item.setAmount(amount);
        item.setCurrency(Currency.USD);
        item.setPeriod(TimePeriod.YEAR);
        item.setTitle("Mr");
        BigDecimal actualAmount = item.getAmount();
        Currency actualCurrency = item.getCurrency();
        TimePeriod actualPeriod = item.getPeriod();

        // Assert
        assertEquals("Mr", item.getTitle());
        assertEquals(Currency.USD, actualCurrency);
        assertEquals(TimePeriod.YEAR, actualPeriod);
        assertEquals(new BigDecimal("2.6"), actualAmount);
        assertSame(amount, actualAmount);
    }
}
