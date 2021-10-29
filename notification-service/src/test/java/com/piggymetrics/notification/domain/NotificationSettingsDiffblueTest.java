package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Test;

public class NotificationSettingsDiffblueTest {
  @Test
  public void testConstructor() {
    // Arrange and Act
    NotificationSettings actualNotificationSettings = new NotificationSettings();
    actualNotificationSettings.setActive(true);
    actualNotificationSettings.setFrequency(Frequency.WEEKLY);
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
    actualNotificationSettings.setLastNotified(fromResult);

    // Assert
    assertTrue(actualNotificationSettings.getActive());
    assertEquals(Frequency.WEEKLY, actualNotificationSettings.getFrequency());
    assertSame(fromResult, actualNotificationSettings.getLastNotified());
  }
}

