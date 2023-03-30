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
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link NotificationSettings}
  *   <li>{@link NotificationSettings#setActive(Boolean)}
  *   <li>{@link NotificationSettings#setFrequency(Frequency)}
  *   <li>{@link NotificationSettings#setLastNotified(Date)}
  *   <li>{@link NotificationSettings#getActive()}
  *   <li>{@link NotificationSettings#getFrequency()}
  *   <li>{@link NotificationSettings#getLastNotified()}
  * </ul>
  */
  @Test
  public void testConstructor() {
    // Arrange and Act
    NotificationSettings actualNotificationSettings = new NotificationSettings();
    actualNotificationSettings.setActive(true);
    actualNotificationSettings.setFrequency(Frequency.WEEKLY);
    Date lastNotified = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualNotificationSettings.setLastNotified(lastNotified);

    // Assert
    assertTrue(actualNotificationSettings.getActive());
    assertEquals(Frequency.WEEKLY, actualNotificationSettings.getFrequency());
    assertSame(lastNotified, actualNotificationSettings.getLastNotified());
  }
}

