package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.Test;

public class NotificationSettingsDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link NotificationSettings#setActive(Boolean)}
     *   <li>{@link NotificationSettings#setFrequency(Frequency)}
     *   <li>{@link NotificationSettings#setLastNotified(Date)}
     *   <li>{@link NotificationSettings#getActive()}
     *   <li>{@link NotificationSettings#getFrequency()}
     *   <li>{@link NotificationSettings#getLastNotified()}
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        // Arrange
        NotificationSettings notificationSettings = new NotificationSettings();

        // Act
        notificationSettings.setActive(true);
        notificationSettings.setFrequency(Frequency.WEEKLY);
        Date lastNotified = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        notificationSettings.setLastNotified(lastNotified);
        Boolean actualActive = notificationSettings.getActive();
        Frequency actualFrequency = notificationSettings.getFrequency();

        // Assert
        assertEquals(Frequency.WEEKLY, actualFrequency);
        assertTrue(actualActive);
        assertSame(lastNotified, notificationSettings.getLastNotified());
    }
}
