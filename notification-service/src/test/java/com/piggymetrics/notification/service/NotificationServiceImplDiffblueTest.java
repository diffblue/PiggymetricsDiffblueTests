package com.piggymetrics.notification.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.notification.domain.Frequency;
import com.piggymetrics.notification.domain.NotificationSettings;
import com.piggymetrics.notification.domain.NotificationType;
import com.piggymetrics.notification.domain.Recipient;
import com.piggymetrics.notification.repository.RecipientRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationServiceImplDiffblueTest {
  @MockBean
  private MongodExecutable mongodExecutable;

  @Autowired
  private NotificationServiceImpl notificationServiceImpl;

  @MockBean
  private RecipientRepository recipientRepository;

  /**
   * Method under test: {@link NotificationServiceImpl#sendBackupNotifications()}
   */
  @Test
  public void testSendBackupNotifications() {
    // Arrange
    when(recipientRepository.findReadyForBackup()).thenReturn(new ArrayList<>());

    // Act
    notificationServiceImpl.sendBackupNotifications();

    // Assert
    verify(recipientRepository).findReadyForBackup();
  }

  /**
   * Method under test: {@link NotificationServiceImpl#sendBackupNotifications()}
   */
  @Test
  public void testSendBackupNotifications2() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());

    ArrayList<Recipient> recipientList = new ArrayList<>();
    recipientList.add(recipient);
    when(recipientRepository.findReadyForBackup()).thenReturn(recipientList);

    // Act
    notificationServiceImpl.sendBackupNotifications();

    // Assert
    verify(recipientRepository).findReadyForBackup();
  }

  /**
   * Method under test: {@link NotificationServiceImpl#sendBackupNotifications()}
   */
  @Test
  public void testSendBackupNotifications3() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());

    Recipient recipient2 = new Recipient();
    recipient2.setAccountName("Mr John Smith");
    recipient2.setEmail("john.smith@example.org");
    recipient2.setScheduledNotifications(new HashMap<>());

    ArrayList<Recipient> recipientList = new ArrayList<>();
    recipientList.add(recipient2);
    recipientList.add(recipient);
    when(recipientRepository.findReadyForBackup()).thenReturn(recipientList);

    // Act
    notificationServiceImpl.sendBackupNotifications();

    // Assert
    verify(recipientRepository).findReadyForBackup();
  }

  /**
   * Method under test: {@link NotificationServiceImpl#sendBackupNotifications()}
   */
  @Test
  public void testSendBackupNotifications4() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setFrequency(Frequency.QUARTERLY);
    notificationSettings
        .setLastNotified(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    HashMap<NotificationType, NotificationSettings> scheduledNotifications = new HashMap<>();
    scheduledNotifications.putIfAbsent(NotificationType.BACKUP, notificationSettings);
    scheduledNotifications.putAll(new HashMap<>());

    Recipient recipient2 = new Recipient();
    recipient2.setAccountName("Mr John Smith");
    recipient2.setEmail("john.smith@example.org");
    recipient2.setScheduledNotifications(scheduledNotifications);

    ArrayList<Recipient> recipientList = new ArrayList<>();
    recipientList.add(recipient2);
    recipientList.add(recipient);
    when(recipientRepository.findReadyForBackup()).thenReturn(recipientList);

    // Act
    notificationServiceImpl.sendBackupNotifications();

    // Assert
    verify(recipientRepository).findReadyForBackup();
  }

  /**
   * Method under test: {@link NotificationServiceImpl#sendRemindNotifications()}
   */
  @Test
  public void testSendRemindNotifications() {
    // Arrange
    when(recipientRepository.findReadyForRemind()).thenReturn(new ArrayList<>());

    // Act
    notificationServiceImpl.sendRemindNotifications();

    // Assert
    verify(recipientRepository).findReadyForRemind();
  }

  /**
   * Method under test: {@link NotificationServiceImpl#sendRemindNotifications()}
   */
  @Test
  public void testSendRemindNotifications2() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());

    ArrayList<Recipient> recipientList = new ArrayList<>();
    recipientList.add(recipient);
    when(recipientRepository.findReadyForRemind()).thenReturn(recipientList);

    // Act
    notificationServiceImpl.sendRemindNotifications();

    // Assert
    verify(recipientRepository).findReadyForRemind();
  }

  /**
   * Method under test: {@link NotificationServiceImpl#sendRemindNotifications()}
   */
  @Test
  public void testSendRemindNotifications3() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());

    Recipient recipient2 = new Recipient();
    recipient2.setAccountName("Mr John Smith");
    recipient2.setEmail("john.smith@example.org");
    recipient2.setScheduledNotifications(new HashMap<>());

    ArrayList<Recipient> recipientList = new ArrayList<>();
    recipientList.add(recipient2);
    recipientList.add(recipient);
    when(recipientRepository.findReadyForRemind()).thenReturn(recipientList);

    // Act
    notificationServiceImpl.sendRemindNotifications();

    // Assert
    verify(recipientRepository).findReadyForRemind();
  }

  /**
   * Method under test: {@link NotificationServiceImpl#sendRemindNotifications()}
   */
  @Test
  public void testSendRemindNotifications4() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());

    Recipient recipient2 = new Recipient();
    recipient2.setAccountName("Mr John Smith");
    recipient2.setEmail("john.smith@example.org");
    recipient2.setScheduledNotifications(new HashMap<>());

    Recipient recipient3 = new Recipient();
    recipient3.setAccountName("Mr John Smith");
    recipient3.setEmail("john.smith@example.org");
    recipient3.setScheduledNotifications(new HashMap<>());

    ArrayList<Recipient> recipientList = new ArrayList<>();
    recipientList.add(recipient3);
    recipientList.add(1, recipient2);
    recipientList.add(recipient);
    when(recipientRepository.findReadyForRemind()).thenReturn(recipientList);

    // Act
    notificationServiceImpl.sendRemindNotifications();

    // Assert
    verify(recipientRepository).findReadyForRemind();
  }
}
