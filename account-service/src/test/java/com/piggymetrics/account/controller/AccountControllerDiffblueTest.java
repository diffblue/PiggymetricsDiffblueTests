package com.piggymetrics.account.controller;

import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.User;

import java.security.Principal;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountControllerDiffblueTest {
    /**
     * Test {@link AccountController#getAccountByName(String)}.
     * <p>
     * Method under test: {@link AccountController#getAccountByName(String)}
     */
    @Test
    @DisplayName("Test getAccountByName(String)")
    @Disabled("TODO: Complete this test")
    void testGetAccountByName() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Unable to load class.
        //   Class: jakarta.servlet.ServletContext
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        AccountController accountController = null;
        String name = "";

        // Act
        Account actualAccountByName = accountController.getAccountByName(name);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link AccountController#getCurrentAccount(Principal)}.
     * <p>
     * Method under test: {@link AccountController#getCurrentAccount(Principal)}
     */
    @Test
    @DisplayName("Test getCurrentAccount(Principal)")
    @Disabled("TODO: Complete this test")
    void testGetCurrentAccount() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Unable to load class.
        //   Class: jakarta.servlet.ServletContext
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        AccountController accountController = null;
        Principal principal = null;

        // Act
        Account actualCurrentAccount = accountController.getCurrentAccount(principal);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link AccountController#saveCurrentAccount(Principal, Account)}.
     * <p>
     * Method under test:
     * {@link AccountController#saveCurrentAccount(Principal, Account)}
     */
    @Test
    @DisplayName("Test saveCurrentAccount(Principal, Account)")
    @Disabled("TODO: Complete this test")
    void testSaveCurrentAccount() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Unable to load class.
        //   Class: jakarta.servlet.ServletContext
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        AccountController accountController = null;
        Principal principal = null;
        Account account = null;

        // Act
        accountController.saveCurrentAccount(principal, account);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link AccountController#createNewAccount(User)}.
     * <p>
     * Method under test: {@link AccountController#createNewAccount(User)}
     */
    @Test
    @DisplayName("Test createNewAccount(User)")
    @Disabled("TODO: Complete this test")
    void testCreateNewAccount() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Unable to load class.
        //   Class: jakarta.servlet.ServletContext
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        AccountController accountController = null;
        User user = null;

        // Act
        Account actualCreateNewAccountResult = accountController.createNewAccount(user);

        // Assert
        // TODO: Add assertions on result
    }
}
