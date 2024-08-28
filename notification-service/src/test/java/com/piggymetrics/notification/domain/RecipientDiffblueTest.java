package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RecipientDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Recipient}
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
  public void testGettersAndSetters_thenReturnsAccountNameIsDrJaneDoeAndReturnsToStringIsAStringAndReturnsEmailIsJaneDotDoeCommercialAtExampleDotOrgAndReturnsScheduledNotificationsEmptyIsTrueAndReturnsScheduledNotificationsIsNewHashMap() {
    // Arrange and Act
    Recipient actualRecipient = new Recipient();
    actualRecipient.setAccountName("Dr Jane Doe");
    actualRecipient.setEmail("jane.doe@example.org");
    HashMap<NotificationType, NotificationSettings> scheduledNotifications = new HashMap<>();
    actualRecipient.setScheduledNotifications(scheduledNotifications);
    String actualToStringResult = actualRecipient.toString();
    String actualAccountName = actualRecipient.getAccountName();
    String actualEmail = actualRecipient.getEmail();
    Map<NotificationType, NotificationSettings> actualScheduledNotifications = actualRecipient
        .getScheduledNotifications();

    // Assert that nothing has changed
    assertEquals("Dr Jane Doe", actualAccountName);
    assertEquals("Recipient{accountName='Dr Jane Doe', email='jane.doe@example.org'}", actualToStringResult);
    assertEquals("jane.doe@example.org", actualEmail);
    assertTrue(actualScheduledNotifications.isEmpty());
    assertSame(scheduledNotifications, actualScheduledNotifications);
  }
}
