package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NotificationTypeDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link NotificationType#valueOf(String)}
  *   <li>{@link NotificationType#getAttachment()}
  *   <li>{@link NotificationType#getSubject()}
  *   <li>{@link NotificationType#getText()}
  * </ul>
  */
  @Test
  public void testValueOf() {
    // Arrange and Act
    NotificationType actualValueOfResult = NotificationType.valueOf("BACKUP");

    // Assert
    assertEquals("backup.email.attachment", actualValueOfResult.getAttachment());
    assertEquals("backup.email.subject", actualValueOfResult.getSubject());
    assertEquals("backup.email.text", actualValueOfResult.getText());
  }
}

