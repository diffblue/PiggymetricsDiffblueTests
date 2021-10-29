package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.util.HashMap;
import org.junit.Test;

public class RecipientDiffblueTest {
  @Test
  public void testConstructor() {
    // Arrange and Act
    Recipient actualRecipient = new Recipient();
    actualRecipient.setAccountName("Dr Jane Doe");
    actualRecipient.setEmail("jane.doe@example.org");
    HashMap<NotificationType, NotificationSettings> notificationTypeNotificationSettingsMap = new HashMap<NotificationType, NotificationSettings>(
        1);
    actualRecipient.setScheduledNotifications(notificationTypeNotificationSettingsMap);

    // Assert
    assertEquals("Dr Jane Doe", actualRecipient.getAccountName());
    assertEquals("jane.doe@example.org", actualRecipient.getEmail());
    assertSame(notificationTypeNotificationSettingsMap, actualRecipient.getScheduledNotifications());
    assertEquals("Recipient{accountName='Dr Jane Doe', email='jane.doe@example.org'}", actualRecipient.toString());
  }
}

