package com.piggymetrics.notification.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.notification.domain.Frequency;
import com.piggymetrics.notification.domain.NotificationSettings;
import com.piggymetrics.notification.domain.NotificationType;
import com.piggymetrics.notification.domain.Recipient;
import com.piggymetrics.notification.repository.RecipientRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {RecipientServiceImpl.class})
@RunWith(SpringRunner.class)
public class RecipientServiceImplDiffblueTest {
  @MockBean
  private RecipientRepository recipientRepository;

  @Autowired
  private RecipientServiceImpl recipientServiceImpl;
  @Test
  public void testFindByAccountName() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>(1));
    recipient.setAccountName("Dr Jane Doe");
    when(this.recipientRepository.findByAccountName((String) any())).thenReturn(recipient);

    // Act and Assert
    assertSame(recipient, this.recipientServiceImpl.findByAccountName("Dr Jane Doe"));
    verify(this.recipientRepository).findByAccountName((String) any());
  }

  @Test
  public void testSave() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>(1));
    recipient.setAccountName("Dr Jane Doe");
    when(this.recipientRepository.save((Recipient) any())).thenReturn(recipient);

    Recipient recipient1 = new Recipient();
    recipient1.setEmail("jane.doe@example.org");
    recipient1.setScheduledNotifications(new HashMap<>(1));
    recipient1.setAccountName("Dr Jane Doe");

    // Act
    Recipient actualSaveResult = this.recipientServiceImpl.save("Dr Jane Doe", recipient1);

    // Assert
    assertSame(recipient1, actualSaveResult);
    assertEquals("Dr Jane Doe", actualSaveResult.getAccountName());
    verify(this.recipientRepository).save((Recipient) any());
  }

  @Test
  public void testSave2() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>(1));
    recipient.setAccountName("Dr Jane Doe");
    when(this.recipientRepository.save((Recipient) any())).thenReturn(recipient);

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    notificationSettings.setLastNotified(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
    notificationSettings.setFrequency(Frequency.WEEKLY);

    HashMap<NotificationType, NotificationSettings> notificationTypeNotificationSettingsMap = new HashMap<>(1);
    notificationTypeNotificationSettingsMap.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient1 = new Recipient();
    recipient1.setEmail("jane.doe@example.org");
    recipient1.setScheduledNotifications(notificationTypeNotificationSettingsMap);
    recipient1.setAccountName("Dr Jane Doe");

    // Act
    Recipient actualSaveResult = this.recipientServiceImpl.save("Dr Jane Doe", recipient1);

    // Assert
    assertSame(recipient1, actualSaveResult);
    assertEquals("Dr Jane Doe", actualSaveResult.getAccountName());
    verify(this.recipientRepository).save((Recipient) any());
  }

  @Test
  public void testSave3() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>(1));
    recipient.setAccountName("Dr Jane Doe");
    when(this.recipientRepository.save((Recipient) any())).thenReturn(recipient);

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setLastNotified(null);
    notificationSettings.setFrequency(Frequency.WEEKLY);

    HashMap<NotificationType, NotificationSettings> notificationTypeNotificationSettingsMap = new HashMap<>(1);
    notificationTypeNotificationSettingsMap.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient1 = new Recipient();
    recipient1.setEmail("jane.doe@example.org");
    recipient1.setScheduledNotifications(notificationTypeNotificationSettingsMap);
    recipient1.setAccountName("Dr Jane Doe");

    // Act
    Recipient actualSaveResult = this.recipientServiceImpl.save("Dr Jane Doe", recipient1);

    // Assert
    assertSame(recipient1, actualSaveResult);
    assertEquals("Dr Jane Doe", actualSaveResult.getAccountName());
    verify(this.recipientRepository).save((Recipient) any());
  }

  @Test
  public void testFindReadyToNotify() {
    // Arrange
    ArrayList<Recipient> recipientList = new ArrayList<>();
    when(this.recipientRepository.findReadyForBackup()).thenReturn(recipientList);

    // Act
    List<Recipient> actualFindReadyToNotifyResult = this.recipientServiceImpl
        .findReadyToNotify(NotificationType.BACKUP);

    // Assert
    assertSame(recipientList, actualFindReadyToNotifyResult);
    assertTrue(actualFindReadyToNotifyResult.isEmpty());
    verify(this.recipientRepository).findReadyForBackup();
  }

  @Test
  public void testFindReadyToNotify2() {
    // Arrange
    ArrayList<Recipient> recipientList = new ArrayList<>();
    when(this.recipientRepository.findReadyForRemind()).thenReturn(recipientList);
    when(this.recipientRepository.findReadyForBackup()).thenReturn(new ArrayList<>());

    // Act
    List<Recipient> actualFindReadyToNotifyResult = this.recipientServiceImpl
        .findReadyToNotify(NotificationType.REMIND);

    // Assert
    assertSame(recipientList, actualFindReadyToNotifyResult);
    assertTrue(actualFindReadyToNotifyResult.isEmpty());
    verify(this.recipientRepository).findReadyForRemind();
  }

  @Test
  public void testMarkNotified() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>(1));
    recipient.setAccountName("Dr Jane Doe");
    when(this.recipientRepository.save((Recipient) any())).thenReturn(recipient);

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    notificationSettings.setLastNotified(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
    notificationSettings.setFrequency(Frequency.WEEKLY);

    HashMap<NotificationType, NotificationSettings> notificationTypeNotificationSettingsMap = new HashMap<>(1);
    notificationTypeNotificationSettingsMap.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient1 = new Recipient();
    recipient1.setEmail("jane.doe@example.org");
    recipient1.setScheduledNotifications(notificationTypeNotificationSettingsMap);
    recipient1.setAccountName("Dr Jane Doe");

    // Act
    this.recipientServiceImpl.markNotified(NotificationType.BACKUP, recipient1);

    // Assert
    verify(this.recipientRepository).save((Recipient) any());
  }
}

