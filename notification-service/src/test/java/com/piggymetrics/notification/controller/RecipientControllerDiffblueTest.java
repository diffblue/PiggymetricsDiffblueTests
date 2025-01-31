package com.piggymetrics.notification.controller;

import com.piggymetrics.notification.domain.Recipient;

import java.security.Principal;

import org.junit.Ignore;
import org.junit.Test;

public class RecipientControllerDiffblueTest {
    /**
     * Test {@link RecipientController#getCurrentNotificationsSettings(Principal)}.
     * <p>
     * Method under test:
     * {@link RecipientController#getCurrentNotificationsSettings(Principal)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetCurrentNotificationsSettings() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Unable to load class.
        //   Class: jakarta.servlet.ServletContext
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        RecipientController recipientController = null;
        Principal principal = null;

        // Act
        Object actualCurrentNotificationsSettings = recipientController.getCurrentNotificationsSettings(principal);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test
     * {@link RecipientController#saveCurrentNotificationsSettings(Principal, Recipient)}.
     * <p>
     * Method under test:
     * {@link RecipientController#saveCurrentNotificationsSettings(Principal, Recipient)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSaveCurrentNotificationsSettings() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Unable to load class.
        //   Class: jakarta.servlet.ServletContext
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        RecipientController recipientController = null;
        Principal principal = null;
        Recipient recipient = null;

        // Act
        Object actualSaveCurrentNotificationsSettingsResult = recipientController
                .saveCurrentNotificationsSettings(principal, recipient);

        // Assert
        // TODO: Add assertions on result
    }
}
