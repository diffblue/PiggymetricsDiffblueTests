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
  public void testSendBackupNotifications_thenCallsFindReadyForBackup() {
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
  public void testSendBackupNotifications_thenCallsFindReadyForBackup2() {
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
  public void testSendBackupNotifications_thenCallsFindReadyForBackup3() {
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
  public void testSendBackupNotifications_thenCallsFindReadyForBackup4() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(false);
    notificationSettings.setFrequency(Frequency.MONTHLY);
    notificationSettings
        .setLastNotified(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    NotificationSettings notificationSettings2 = new NotificationSettings();
    notificationSettings2.setActive(false);
    notificationSettings2.setFrequency(Frequency.MONTHLY);
    notificationSettings2
        .setLastNotified(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    HashMap<NotificationType, NotificationSettings> scheduledNotifications = new HashMap<>();
    scheduledNotifications.putIfAbsent(NotificationType.REMIND, notificationSettings2);
    scheduledNotifications.putIfAbsent(NotificationType.REMIND, notificationSettings);

    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(scheduledNotifications);

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
   * Method under test: {@link NotificationServiceImpl#sendRemindNotifications()}
   */
  @Test
  public void testSendRemindNotifications_thenCallsFindReadyForRemind() {
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
  public void testSendRemindNotifications_thenCallsFindReadyForRemind2() {
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
  public void testSendRemindNotifications_thenCallsFindReadyForRemind3() {
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
}
