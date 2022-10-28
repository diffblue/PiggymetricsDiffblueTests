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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RecipientServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RecipientServiceImplDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @MockBean
  private RecipientRepository recipientRepository;

  @Autowired
  private RecipientServiceImpl recipientServiceImpl;
  /**
  * Method under test: {@link RecipientServiceImpl#findByAccountName(String)}
  */
  @Test
  public void testFindByAccountName() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());
    when(recipientRepository.findByAccountName((String) any())).thenReturn(recipient);

    // Act and Assert
    assertSame(recipient, recipientServiceImpl.findByAccountName("Dr Jane Doe"));
    verify(recipientRepository).findByAccountName((String) any());
  }

  /**
   * Method under test: {@link RecipientServiceImpl#findByAccountName(String)}
   */
  @Test
  public void testFindByAccountName2() {
    // Arrange
    when(recipientRepository.findByAccountName((String) any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    recipientServiceImpl.findByAccountName("Dr Jane Doe");
    verify(recipientRepository).findByAccountName((String) any());
  }

  /**
   * Method under test: {@link RecipientServiceImpl#save(String, Recipient)}
   */
  @Test
  public void testSave() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());
    when(recipientRepository.save((Recipient) any())).thenReturn(recipient);

    Recipient recipient1 = new Recipient();
    recipient1.setAccountName("Dr Jane Doe");
    recipient1.setEmail("jane.doe@example.org");
    recipient1.setScheduledNotifications(new HashMap<>());

    // Act
    Recipient actualSaveResult = recipientServiceImpl.save("Dr Jane Doe", recipient1);

    // Assert
    assertSame(recipient1, actualSaveResult);
    assertEquals("Dr Jane Doe", actualSaveResult.getAccountName());
    verify(recipientRepository).save((Recipient) any());
  }

  /**
   * Method under test: {@link RecipientServiceImpl#save(String, Recipient)}
   */
  @Test
  public void testSave2() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());
    when(recipientRepository.save((Recipient) any())).thenReturn(recipient);

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setFrequency(Frequency.WEEKLY);
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    notificationSettings.setLastNotified(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));

    HashMap<NotificationType, NotificationSettings> notificationTypeNotificationSettingsMap = new HashMap<>();
    notificationTypeNotificationSettingsMap.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient1 = new Recipient();
    recipient1.setAccountName("Dr Jane Doe");
    recipient1.setEmail("jane.doe@example.org");
    recipient1.setScheduledNotifications(notificationTypeNotificationSettingsMap);

    // Act
    Recipient actualSaveResult = recipientServiceImpl.save("Dr Jane Doe", recipient1);

    // Assert
    assertSame(recipient1, actualSaveResult);
    assertEquals("Dr Jane Doe", actualSaveResult.getAccountName());
    verify(recipientRepository).save((Recipient) any());
  }

  /**
   * Method under test: {@link RecipientServiceImpl#save(String, Recipient)}
   */
  @Test
  public void testSave3() {
    // Arrange
    when(recipientRepository.save((Recipient) any())).thenThrow(new IllegalArgumentException());

    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    recipientServiceImpl.save("Dr Jane Doe", recipient);
    verify(recipientRepository).save((Recipient) any());
  }

  /**
   * Method under test: {@link RecipientServiceImpl#save(String, Recipient)}
   */
  @Test
  public void testSave4() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());
    when(recipientRepository.save((Recipient) any())).thenReturn(recipient);

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setFrequency(Frequency.WEEKLY);
    notificationSettings.setLastNotified(null);

    HashMap<NotificationType, NotificationSettings> notificationTypeNotificationSettingsMap = new HashMap<>();
    notificationTypeNotificationSettingsMap.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient1 = new Recipient();
    recipient1.setAccountName("Dr Jane Doe");
    recipient1.setEmail("jane.doe@example.org");
    recipient1.setScheduledNotifications(notificationTypeNotificationSettingsMap);

    // Act
    Recipient actualSaveResult = recipientServiceImpl.save("Dr Jane Doe", recipient1);

    // Assert
    assertSame(recipient1, actualSaveResult);
    assertEquals("Dr Jane Doe", actualSaveResult.getAccountName());
    verify(recipientRepository).save((Recipient) any());
  }

  /**
   * Method under test: {@link RecipientServiceImpl#findReadyToNotify(NotificationType)}
   */
  @Test
  public void testFindReadyToNotify() {
    // Arrange
    ArrayList<Recipient> recipientList = new ArrayList<>();
    when(recipientRepository.findReadyForBackup()).thenReturn(recipientList);

    // Act
    List<Recipient> actualFindReadyToNotifyResult = recipientServiceImpl.findReadyToNotify(NotificationType.BACKUP);

    // Assert
    assertSame(recipientList, actualFindReadyToNotifyResult);
    assertTrue(actualFindReadyToNotifyResult.isEmpty());
    verify(recipientRepository).findReadyForBackup();
  }

  /**
   * Method under test: {@link RecipientServiceImpl#findReadyToNotify(NotificationType)}
   */
  @Test
  public void testFindReadyToNotify2() {
    // Arrange
    ArrayList<Recipient> recipientList = new ArrayList<>();
    when(recipientRepository.findReadyForRemind()).thenReturn(recipientList);
    when(recipientRepository.findReadyForBackup()).thenReturn(new ArrayList<>());

    // Act
    List<Recipient> actualFindReadyToNotifyResult = recipientServiceImpl.findReadyToNotify(NotificationType.REMIND);

    // Assert
    assertSame(recipientList, actualFindReadyToNotifyResult);
    assertTrue(actualFindReadyToNotifyResult.isEmpty());
    verify(recipientRepository).findReadyForRemind();
  }

  /**
   * Method under test: {@link RecipientServiceImpl#findReadyToNotify(NotificationType)}
   */
  @Test
  public void testFindReadyToNotify3() {
    // Arrange
    when(recipientRepository.findReadyForRemind()).thenThrow(new IllegalArgumentException());
    when(recipientRepository.findReadyForBackup()).thenReturn(new ArrayList<>());

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    recipientServiceImpl.findReadyToNotify(NotificationType.REMIND);
    verify(recipientRepository).findReadyForRemind();
  }

  /**
   * Method under test: {@link RecipientServiceImpl#findReadyToNotify(NotificationType)}
   */
  @Test
  public void testFindReadyToNotify4() {
    // Arrange
    when(recipientRepository.findReadyForBackup()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    recipientServiceImpl.findReadyToNotify(NotificationType.BACKUP);
    verify(recipientRepository).findReadyForBackup();
  }

  /**
   * Method under test: {@link RecipientServiceImpl#markNotified(NotificationType, Recipient)}
   */
  @Test
  public void testMarkNotified() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());
    when(recipientRepository.save((Recipient) any())).thenReturn(recipient);

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setFrequency(Frequency.WEEKLY);
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    notificationSettings.setLastNotified(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));

    HashMap<NotificationType, NotificationSettings> notificationTypeNotificationSettingsMap = new HashMap<>();
    notificationTypeNotificationSettingsMap.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient1 = new Recipient();
    recipient1.setAccountName("Dr Jane Doe");
    recipient1.setEmail("jane.doe@example.org");
    recipient1.setScheduledNotifications(notificationTypeNotificationSettingsMap);

    // Act
    recipientServiceImpl.markNotified(NotificationType.BACKUP, recipient1);

    // Assert
    verify(recipientRepository).save((Recipient) any());
  }

  /**
   * Method under test: {@link RecipientServiceImpl#markNotified(NotificationType, Recipient)}
   */
  @Test
  public void testMarkNotified2() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());
    when(recipientRepository.save((Recipient) any())).thenReturn(recipient);

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setFrequency(Frequency.WEEKLY);
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    notificationSettings.setLastNotified(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));

    HashMap<NotificationType, NotificationSettings> notificationTypeNotificationSettingsMap = new HashMap<>();
    notificationTypeNotificationSettingsMap.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient1 = new Recipient();
    recipient1.setAccountName("Account Name");
    recipient1.setEmail("jane.doe@example.org");
    recipient1.setScheduledNotifications(notificationTypeNotificationSettingsMap);

    // Act
    recipientServiceImpl.markNotified(NotificationType.BACKUP, recipient1);

    // Assert
    verify(recipientRepository).save((Recipient) any());
  }

  /**
   * Method under test: {@link RecipientServiceImpl#markNotified(NotificationType, Recipient)}
   */
  @Test
  public void testMarkNotified3() {
    // Arrange
    when(recipientRepository.save((Recipient) any())).thenThrow(new IllegalArgumentException());

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setFrequency(Frequency.WEEKLY);
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    notificationSettings.setLastNotified(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));

    HashMap<NotificationType, NotificationSettings> notificationTypeNotificationSettingsMap = new HashMap<>();
    notificationTypeNotificationSettingsMap.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(notificationTypeNotificationSettingsMap);

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    recipientServiceImpl.markNotified(NotificationType.BACKUP, recipient);
    verify(recipientRepository).save((Recipient) any());
  }
}

