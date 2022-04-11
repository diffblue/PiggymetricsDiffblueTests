package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NotificationTypeDiffblueTest {
  /**
  * Method under test: {@link NotificationType#valueOf(String)}
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

