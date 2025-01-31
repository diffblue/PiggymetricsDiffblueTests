package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AccountDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Account#setExpenses(List)}
     *   <li>{@link Account#setIncomes(List)}
     *   <li>{@link Account#setSaving(Saving)}
     *   <li>{@link Account#getExpenses()}
     *   <li>{@link Account#getIncomes()}
     *   <li>{@link Account#getSaving()}
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        // Arrange
        Account account = new Account();
        ArrayList<Item> expenses = new ArrayList<>();

        // Act
        account.setExpenses(expenses);
        ArrayList<Item> incomes = new ArrayList<>();
        account.setIncomes(incomes);
        Saving saving = new Saving();
        saving.setAmount(new BigDecimal("2.3"));
        saving.setCapitalization(true);
        saving.setCurrency(Currency.USD);
        saving.setDeposit(true);
        saving.setInterest(new BigDecimal("2.3"));
        account.setSaving(saving);
        List<Item> actualExpenses = account.getExpenses();
        List<Item> actualIncomes = account.getIncomes();
        Saving actualSaving = account.getSaving();

        // Assert
        assertTrue(actualExpenses.isEmpty());
        assertTrue(actualIncomes.isEmpty());
        assertSame(saving, actualSaving);
        assertSame(expenses, actualExpenses);
        assertSame(incomes, actualIncomes);
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Account#setExpenses(List)}
     *   <li>{@link Account#setIncomes(List)}
     *   <li>{@link Account#setSaving(Saving)}
     *   <li>{@link Account#getExpenses()}
     *   <li>{@link Account#getIncomes()}
     *   <li>{@link Account#getSaving()}
     * </ul>
     */
    @Test
    public void testGettersAndSetters2() {
        // Arrange
        Account account = new Account();
        ArrayList<Item> expenses = new ArrayList<>();

        // Act
        account.setExpenses(expenses);
        ArrayList<Item> incomes = new ArrayList<>();
        account.setIncomes(incomes);
        Saving saving = new Saving();
        saving.setAmount(new BigDecimal("2.6"));
        saving.setCapitalization(true);
        saving.setCurrency(Currency.USD);
        saving.setDeposit(true);
        saving.setInterest(new BigDecimal("2.6"));
        account.setSaving(saving);
        List<Item> actualExpenses = account.getExpenses();
        List<Item> actualIncomes = account.getIncomes();
        Saving actualSaving = account.getSaving();

        // Assert
        assertTrue(actualExpenses.isEmpty());
        assertTrue(actualIncomes.isEmpty());
        assertSame(saving, actualSaving);
        assertSame(expenses, actualExpenses);
        assertSame(incomes, actualIncomes);
    }
}
