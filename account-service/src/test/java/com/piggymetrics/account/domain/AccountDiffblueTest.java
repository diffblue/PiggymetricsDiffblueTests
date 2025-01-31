package com.piggymetrics.account.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Account#setExpenses(List)}
     *   <li>{@link Account#setIncomes(List)}
     *   <li>{@link Account#setLastSeen(Date)}
     *   <li>{@link Account#setName(String)}
     *   <li>{@link Account#setNote(String)}
     *   <li>{@link Account#setSaving(Saving)}
     *   <li>{@link Account#getExpenses()}
     *   <li>{@link Account#getIncomes()}
     *   <li>{@link Account#getLastSeen()}
     *   <li>{@link Account#getName()}
     *   <li>{@link Account#getNote()}
     *   <li>{@link Account#getSaving()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters() {
        // Arrange
        Account account = new Account();
        ArrayList<Item> expenses = new ArrayList<>();

        // Act
        account.setExpenses(expenses);
        ArrayList<Item> incomes = new ArrayList<>();
        account.setIncomes(incomes);
        Date lastSeen = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        account.setLastSeen(lastSeen);
        account.setName("Name");
        account.setNote("Note");
        Saving saving = new Saving();
        saving.setAmount(new BigDecimal("2.4"));
        saving.setCapitalization(true);
        saving.setCurrency(Currency.USD);
        saving.setDeposit(true);
        saving.setInterest(new BigDecimal("2.4"));
        account.setSaving(saving);
        List<Item> actualExpenses = account.getExpenses();
        List<Item> actualIncomes = account.getIncomes();
        Date actualLastSeen = account.getLastSeen();
        String actualName = account.getName();
        String actualNote = account.getNote();
        Saving actualSaving = account.getSaving();

        // Assert
        assertEquals("Name", actualName);
        assertEquals("Note", actualNote);
        assertTrue(actualExpenses.isEmpty());
        assertTrue(actualIncomes.isEmpty());
        assertSame(saving, actualSaving);
        assertSame(expenses, actualExpenses);
        assertSame(incomes, actualIncomes);
        assertSame(lastSeen, actualLastSeen);
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Account#setExpenses(List)}
     *   <li>{@link Account#setIncomes(List)}
     *   <li>{@link Account#setLastSeen(Date)}
     *   <li>{@link Account#setName(String)}
     *   <li>{@link Account#setNote(String)}
     *   <li>{@link Account#setSaving(Saving)}
     *   <li>{@link Account#getExpenses()}
     *   <li>{@link Account#getIncomes()}
     *   <li>{@link Account#getLastSeen()}
     *   <li>{@link Account#getName()}
     *   <li>{@link Account#getNote()}
     *   <li>{@link Account#getSaving()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters2() {
        // Arrange
        Account account = new Account();
        ArrayList<Item> expenses = new ArrayList<>();

        // Act
        account.setExpenses(expenses);
        ArrayList<Item> incomes = new ArrayList<>();
        account.setIncomes(incomes);
        Date lastSeen = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        account.setLastSeen(lastSeen);
        account.setName("Smith");
        account.setNote("Note");
        Saving saving = new Saving();
        saving.setAmount(new BigDecimal("2.6"));
        saving.setCapitalization(true);
        saving.setCurrency(Currency.USD);
        saving.setDeposit(true);
        saving.setInterest(new BigDecimal("2.6"));
        account.setSaving(saving);
        List<Item> actualExpenses = account.getExpenses();
        List<Item> actualIncomes = account.getIncomes();
        Date actualLastSeen = account.getLastSeen();
        String actualName = account.getName();
        String actualNote = account.getNote();
        Saving actualSaving = account.getSaving();

        // Assert
        assertEquals("Note", actualNote);
        assertEquals("Smith", actualName);
        assertTrue(actualExpenses.isEmpty());
        assertTrue(actualIncomes.isEmpty());
        assertSame(saving, actualSaving);
        assertSame(expenses, actualExpenses);
        assertSame(incomes, actualIncomes);
        assertSame(lastSeen, actualLastSeen);
    }
}
