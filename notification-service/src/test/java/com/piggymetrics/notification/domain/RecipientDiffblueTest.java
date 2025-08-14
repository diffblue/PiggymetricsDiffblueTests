package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RecipientDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Recipient.<init>()",
    "String Recipient.getAccountName()",
    "String Recipient.getEmail()",
    "Map Recipient.getScheduledNotifications()",
    "void Recipient.setAccountName(String)",
    "void Recipient.setEmail(String)",
    "void Recipient.setScheduledNotifications(Map)",
    "String Recipient.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Recipient actualRecipient = new Recipient();
    actualRecipient.setAccountName("Dr Jane Doe");
    actualRecipient.setEmail("jane.doe@example.org");
    HashMap<NotificationType, NotificationSettings> scheduledNotifications = new HashMap<>();
    actualRecipient.setScheduledNotifications(scheduledNotifications);
    String actualToStringResult = actualRecipient.toString();
    String actualAccountName = actualRecipient.getAccountName();
    String actualEmail = actualRecipient.getEmail();
    Map<NotificationType, NotificationSettings> actualScheduledNotifications =
        actualRecipient.getScheduledNotifications();

    // Assert
    assertEquals("Dr Jane Doe", actualAccountName);
    assertEquals(
        "Recipient{accountName='Dr Jane Doe', email='jane.doe@example.org'}", actualToStringResult);
    assertEquals("jane.doe@example.org", actualEmail);
    assertTrue(actualScheduledNotifications.isEmpty());
    assertSame(scheduledNotifications, actualScheduledNotifications);
  }
}
