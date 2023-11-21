package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NotificationTypeDiffblueTest {
  /**
   * Methods under test:
   * 
   * <ul>
   *   <li>{@link NotificationType#getAttachment()}
   *   <li>{@link NotificationType#getSubject()}
   *   <li>{@link NotificationType#getText()}
   * </ul>
   */
  @Test
  public void testGetAttachment() {
    // Arrange
    NotificationType valueOfResult = NotificationType.valueOf("BACKUP");

    // Act
    String actualAttachment = valueOfResult.getAttachment();
    String actualSubject = valueOfResult.getSubject();

    // Assert
    assertEquals("backup.email.attachment", actualAttachment);
    assertEquals("backup.email.subject", actualSubject);
    assertEquals("backup.email.text", valueOfResult.getText());
  }
}
