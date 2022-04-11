package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RecipientDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link Recipient}
  *   <li>{@link Recipient#setAccountName(String)}
  *   <li>{@link Recipient#setEmail(String)}
  *   <li>{@link Recipient#setScheduledNotifications(Map)}
  * </ul>
  */
  @Test
  public void testConstructor() {
    // Arrange and Act
    Recipient actualRecipient = new Recipient();
    actualRecipient.setAccountName("Dr Jane Doe");
    actualRecipient.setEmail("jane.doe@example.org");
    HashMap<NotificationType, NotificationSettings> notificationTypeNotificationSettingsMap = new HashMap<>();
    actualRecipient.setScheduledNotifications(notificationTypeNotificationSettingsMap);

    // Assert
    assertEquals("Dr Jane Doe", actualRecipient.getAccountName());
    assertEquals("jane.doe@example.org", actualRecipient.getEmail());
    assertSame(notificationTypeNotificationSettingsMap, actualRecipient.getScheduledNotifications());
  }
}

