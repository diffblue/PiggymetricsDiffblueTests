package com.piggymetrics.account.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Item#setAmount(BigDecimal)}
     *   <li>{@link Item#setCurrency(Currency)}
     *   <li>{@link Item#setIcon(String)}
     *   <li>{@link Item#setPeriod(TimePeriod)}
     *   <li>{@link Item#setTitle(String)}
     *   <li>{@link Item#getAmount()}
     *   <li>{@link Item#getCurrency()}
     *   <li>{@link Item#getIcon()}
     *   <li>{@link Item#getPeriod()}
     *   <li>{@link Item#getTitle()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters() {
        // Arrange
        Item item = new Item();
        BigDecimal amount = new BigDecimal("2.6");

        // Act
        item.setAmount(amount);
        item.setCurrency(Currency.USD);
        item.setIcon("Icon");
        item.setPeriod(TimePeriod.YEAR);
        item.setTitle("Dr");
        BigDecimal actualAmount = item.getAmount();
        Currency actualCurrency = item.getCurrency();
        String actualIcon = item.getIcon();
        TimePeriod actualPeriod = item.getPeriod();

        // Assert
        assertEquals("Dr", item.getTitle());
        assertEquals("Icon", actualIcon);
        assertEquals(Currency.USD, actualCurrency);
        assertEquals(TimePeriod.YEAR, actualPeriod);
        assertEquals(new BigDecimal("2.6"), actualAmount);
        assertSame(amount, actualAmount);
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Item#setAmount(BigDecimal)}
     *   <li>{@link Item#setCurrency(Currency)}
     *   <li>{@link Item#setIcon(String)}
     *   <li>{@link Item#setPeriod(TimePeriod)}
     *   <li>{@link Item#setTitle(String)}
     *   <li>{@link Item#getAmount()}
     *   <li>{@link Item#getCurrency()}
     *   <li>{@link Item#getIcon()}
     *   <li>{@link Item#getPeriod()}
     *   <li>{@link Item#getTitle()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters2() {
        // Arrange
        Item item = new Item();
        BigDecimal amount = new BigDecimal("2.6");

        // Act
        item.setAmount(amount);
        item.setCurrency(Currency.USD);
        item.setIcon("Icon");
        item.setPeriod(TimePeriod.YEAR);
        item.setTitle("Mr");
        BigDecimal actualAmount = item.getAmount();
        Currency actualCurrency = item.getCurrency();
        String actualIcon = item.getIcon();
        TimePeriod actualPeriod = item.getPeriod();

        // Assert
        assertEquals("Icon", actualIcon);
        assertEquals("Mr", item.getTitle());
        assertEquals(Currency.USD, actualCurrency);
        assertEquals(TimePeriod.YEAR, actualPeriod);
        assertEquals(new BigDecimal("2.6"), actualAmount);
        assertSame(amount, actualAmount);
    }
}
