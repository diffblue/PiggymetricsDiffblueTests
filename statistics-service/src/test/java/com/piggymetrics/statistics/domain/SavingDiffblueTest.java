package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class SavingDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Saving#setAmount(BigDecimal)}
     *   <li>{@link Saving#setCapitalization(Boolean)}
     *   <li>{@link Saving#setCurrency(Currency)}
     *   <li>{@link Saving#setDeposit(Boolean)}
     *   <li>{@link Saving#setInterest(BigDecimal)}
     *   <li>{@link Saving#getAmount()}
     *   <li>{@link Saving#getCapitalization()}
     *   <li>{@link Saving#getCurrency()}
     *   <li>{@link Saving#getDeposit()}
     *   <li>{@link Saving#getInterest()}
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        // Arrange
        Saving saving = new Saving();
        BigDecimal amount = new BigDecimal("2.3");

        // Act
        saving.setAmount(amount);
        saving.setCapitalization(true);
        saving.setCurrency(Currency.USD);
        saving.setDeposit(true);
        BigDecimal interest = new BigDecimal("2.3");
        saving.setInterest(interest);
        BigDecimal actualAmount = saving.getAmount();
        Boolean actualCapitalization = saving.getCapitalization();
        Currency actualCurrency = saving.getCurrency();
        Boolean actualDeposit = saving.getDeposit();
        BigDecimal actualInterest = saving.getInterest();

        // Assert
        assertEquals(Currency.USD, actualCurrency);
        assertTrue(actualCapitalization);
        assertTrue(actualDeposit);
        assertEquals(new BigDecimal("2.3"), actualAmount);
        assertEquals(new BigDecimal("2.3"), actualInterest);
        assertSame(amount, actualAmount);
        assertSame(interest, actualInterest);
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Saving#setAmount(BigDecimal)}
     *   <li>{@link Saving#setCapitalization(Boolean)}
     *   <li>{@link Saving#setCurrency(Currency)}
     *   <li>{@link Saving#setDeposit(Boolean)}
     *   <li>{@link Saving#setInterest(BigDecimal)}
     *   <li>{@link Saving#getAmount()}
     *   <li>{@link Saving#getCapitalization()}
     *   <li>{@link Saving#getCurrency()}
     *   <li>{@link Saving#getDeposit()}
     *   <li>{@link Saving#getInterest()}
     * </ul>
     */
    @Test
    public void testGettersAndSetters2() {
        // Arrange
        Saving saving = new Saving();
        BigDecimal amount = new BigDecimal("2.6");

        // Act
        saving.setAmount(amount);
        saving.setCapitalization(true);
        saving.setCurrency(Currency.USD);
        saving.setDeposit(true);
        BigDecimal interest = new BigDecimal("2.6");
        saving.setInterest(interest);
        BigDecimal actualAmount = saving.getAmount();
        Boolean actualCapitalization = saving.getCapitalization();
        Currency actualCurrency = saving.getCurrency();
        Boolean actualDeposit = saving.getDeposit();
        BigDecimal actualInterest = saving.getInterest();

        // Assert
        assertEquals(Currency.USD, actualCurrency);
        assertTrue(actualCapitalization);
        assertTrue(actualDeposit);
        assertEquals(new BigDecimal("2.6"), actualAmount);
        assertEquals(new BigDecimal("2.6"), actualInterest);
        assertSame(amount, actualAmount);
        assertSame(interest, actualInterest);
    }
}
