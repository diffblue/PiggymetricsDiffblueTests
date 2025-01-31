package com.piggymetrics.statistics.controller;

import com.piggymetrics.statistics.domain.Account;
import com.piggymetrics.statistics.domain.timeseries.DataPoint;

import java.security.Principal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class StatisticsControllerDiffblueTest {
    /**
     * Test {@link StatisticsController#getCurrentAccountStatistics(Principal)}.
     * <p>
     * Method under test:
     * {@link StatisticsController#getCurrentAccountStatistics(Principal)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetCurrentAccountStatistics() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Unable to load class.
        //   Class: jakarta.servlet.ServletContext
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        StatisticsController statisticsController = null;
        Principal principal = null;

        // Act
        List<DataPoint> actualCurrentAccountStatistics = statisticsController.getCurrentAccountStatistics(principal);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link StatisticsController#getStatisticsByAccountName(String)}.
     * <p>
     * Method under test:
     * {@link StatisticsController#getStatisticsByAccountName(String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetStatisticsByAccountName() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Unable to load class.
        //   Class: jakarta.servlet.ServletContext
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        StatisticsController statisticsController = null;
        String accountName = "";

        // Act
        List<DataPoint> actualStatisticsByAccountName = statisticsController.getStatisticsByAccountName(accountName);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link StatisticsController#saveAccountStatistics(String, Account)}.
     * <p>
     * Method under test:
     * {@link StatisticsController#saveAccountStatistics(String, Account)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSaveAccountStatistics() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Unable to load class.
        //   Class: jakarta.servlet.ServletContext
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        StatisticsController statisticsController = null;
        String accountName = "";
        Account account = null;

        // Act
        statisticsController.saveAccountStatistics(accountName, account);

        // Assert
        // TODO: Add assertions on result
    }
}
