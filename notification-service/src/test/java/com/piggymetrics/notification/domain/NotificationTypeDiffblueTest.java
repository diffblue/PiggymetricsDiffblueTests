package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NotificationTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationType#getAttachment()}
   *   <li>{@link NotificationType#getSubject()}
   *   <li>{@link NotificationType#getText()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String NotificationType.getAttachment()",
    "String NotificationType.getSubject()",
    "String NotificationType.getText()"
  })
  public void testGettersAndSetters() {
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
