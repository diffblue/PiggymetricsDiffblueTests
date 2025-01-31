package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class RecipientDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Recipient#setAccountName(String)}
     *   <li>{@link Recipient#setEmail(String)}
     *   <li>{@link Recipient#setScheduledNotifications(Map)}
     *   <li>{@link Recipient#toString()}
     *   <li>{@link Recipient#getAccountName()}
     *   <li>{@link Recipient#getEmail()}
     *   <li>{@link Recipient#getScheduledNotifications()}
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        // Arrange
        Recipient recipient = new Recipient();

        // Act
        recipient.setAccountName("Dr Jane Doe");
        recipient.setEmail("jane.doe@example.org");
        HashMap<NotificationType, NotificationSettings> scheduledNotifications = new HashMap<>();
        recipient.setScheduledNotifications(scheduledNotifications);
        String actualToStringResult = recipient.toString();
        String actualAccountName = recipient.getAccountName();
        String actualEmail = recipient.getEmail();
        Map<NotificationType, NotificationSettings> actualScheduledNotifications = recipient.getScheduledNotifications();

        // Assert
        assertEquals("Dr Jane Doe", actualAccountName);
        assertEquals("Recipient{accountName='Dr Jane Doe', email='jane.doe@example.org'}", actualToStringResult);
        assertEquals("jane.doe@example.org", actualEmail);
        assertTrue(actualScheduledNotifications.isEmpty());
        assertSame(scheduledNotifications, actualScheduledNotifications);
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Recipient#setAccountName(String)}
     *   <li>{@link Recipient#setEmail(String)}
     *   <li>{@link Recipient#setScheduledNotifications(Map)}
     *   <li>{@link Recipient#toString()}
     *   <li>{@link Recipient#getAccountName()}
     *   <li>{@link Recipient#getEmail()}
     *   <li>{@link Recipient#getScheduledNotifications()}
     * </ul>
     */
    @Test
    public void testGettersAndSetters2() {
        // Arrange
        Recipient recipient = new Recipient();

        // Act
        recipient.setAccountName("Smith");
        recipient.setEmail("jane.doe@example.org");
        HashMap<NotificationType, NotificationSettings> scheduledNotifications = new HashMap<>();
        recipient.setScheduledNotifications(scheduledNotifications);
        String actualToStringResult = recipient.toString();
        String actualAccountName = recipient.getAccountName();
        String actualEmail = recipient.getEmail();
        Map<NotificationType, NotificationSettings> actualScheduledNotifications = recipient.getScheduledNotifications();

        // Assert
        assertEquals("Recipient{accountName='Smith', email='jane.doe@example.org'}", actualToStringResult);
        assertEquals("Smith", actualAccountName);
        assertEquals("jane.doe@example.org", actualEmail);
        assertTrue(actualScheduledNotifications.isEmpty());
        assertSame(scheduledNotifications, actualScheduledNotifications);
    }
}
