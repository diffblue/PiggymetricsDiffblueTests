package com.piggymetrics.notification.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.notification.domain.Frequency;
import com.piggymetrics.notification.domain.NotificationSettings;
import com.piggymetrics.notification.domain.NotificationType;
import com.piggymetrics.notification.domain.Recipient;
import com.piggymetrics.notification.repository.RecipientRepository;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RecipientServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RecipientServiceImplDiffblueTest {
  @MockBean private RecipientRepository recipientRepository;

  @Autowired private RecipientServiceImpl recipientServiceImpl;

  @Rule public ExpectedException thrown = ExpectedException.none();

  /**
   * Test {@link RecipientServiceImpl#findByAccountName(String)}.
   *
   * <ul>
   *   <li>When {@code not empty}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RecipientServiceImpl#findByAccountName(String)}
   */
  @Test
  public void testFindByAccountName_whenNotEmpty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(recipientServiceImpl.findByAccountName("not empty"));
  }

  /**
   * Test {@link RecipientServiceImpl#save(String, Recipient)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@code Mr John Smith}.
   *   <li>Then {@link Recipient} (default constructor) AccountName is {@code Mr John Smith}.
   * </ul>
   *
   * <p>Method under test: {@link RecipientServiceImpl#save(String, Recipient)}
   */
  @Test
  public void testSave_givenHashMap_whenMrJohnSmith_thenRecipientAccountNameIsMrJohnSmith() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());

    // Act
    Recipient actualSaveResult = recipientServiceImpl.save("Mr John Smith", recipient);

    // Assert
    assertEquals("Mr John Smith", recipient.getAccountName());
    assertSame(recipient, actualSaveResult);
  }

  /**
   * Test {@link RecipientServiceImpl#save(String, Recipient)}.
   *
   * <ul>
   *   <li>Given {@link NotificationSettings} (default constructor) LastNotified is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RecipientServiceImpl#save(String, Recipient)}
   */
  @Test
  public void testSave_givenNotificationSettingsLastNotifiedIsNull() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setFrequency(Frequency.WEEKLY);
    notificationSettings.setLastNotified(null);

    HashMap<NotificationType, NotificationSettings> scheduledNotifications = new HashMap<>();
    scheduledNotifications.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(scheduledNotifications);

    // Act
    Recipient actualSaveResult = recipientServiceImpl.save("Dr Jane Doe", recipient);

    // Assert
    assertEquals("Dr Jane Doe", recipient.getAccountName());
    assertEquals("Dr Jane Doe", actualSaveResult.getAccountName());
    assertSame(scheduledNotifications, actualSaveResult.getScheduledNotifications());
  }

  /**
   * Test {@link RecipientServiceImpl#save(String, Recipient)}.
   *
   * <ul>
   *   <li>Then {@link Recipient} (default constructor) AccountName is {@code Dr Jane Doe}.
   * </ul>
   *
   * <p>Method under test: {@link RecipientServiceImpl#save(String, Recipient)}
   */
  @Test
  public void testSave_thenRecipientAccountNameIsDrJaneDoe() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setFrequency(Frequency.WEEKLY);
    notificationSettings.setLastNotified(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    HashMap<NotificationType, NotificationSettings> scheduledNotifications = new HashMap<>();
    scheduledNotifications.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(scheduledNotifications);

    // Act
    Recipient actualSaveResult = recipientServiceImpl.save("Dr Jane Doe", recipient);

    // Assert
    assertEquals("Dr Jane Doe", recipient.getAccountName());
    assertEquals("Dr Jane Doe", actualSaveResult.getAccountName());
    assertSame(scheduledNotifications, actualSaveResult.getScheduledNotifications());
  }

  /**
   * Test {@link RecipientServiceImpl#save(String, Recipient)}.
   *
   * <ul>
   *   <li>Then return ScheduledNotifications size is two.
   * </ul>
   *
   * <p>Method under test: {@link RecipientServiceImpl#save(String, Recipient)}
   */
  @Test
  public void testSave_thenReturnScheduledNotificationsSizeIsTwo() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setFrequency(Frequency.WEEKLY);
    notificationSettings.setLastNotified(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    NotificationSettings notificationSettings2 = new NotificationSettings();
    notificationSettings2.setActive(false);
    notificationSettings2.setFrequency(Frequency.MONTHLY);
    notificationSettings2.setLastNotified(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    HashMap<NotificationType, NotificationSettings> scheduledNotifications = new HashMap<>();
    scheduledNotifications.put(NotificationType.REMIND, notificationSettings2);
    scheduledNotifications.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(scheduledNotifications);

    // Act and Assert
    Map<NotificationType, NotificationSettings> scheduledNotifications2 =
        recipientServiceImpl.save("Dr Jane Doe", recipient).getScheduledNotifications();
    assertEquals(2, scheduledNotifications2.size());
    assertTrue(scheduledNotifications2.containsKey(NotificationType.BACKUP));
    assertSame(notificationSettings2, scheduledNotifications2.get(NotificationType.REMIND));
  }

  /**
   * Test {@link RecipientServiceImpl#findReadyToNotify(NotificationType)}.
   *
   * <ul>
   *   <li>When {@code REMIND}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RecipientServiceImpl#findReadyToNotify(NotificationType)}
   */
  @Test
  public void testFindReadyToNotify_whenRemind_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(recipientServiceImpl.findReadyToNotify(NotificationType.REMIND).isEmpty());
  }

  /**
   * Test {@link RecipientServiceImpl#markNotified(NotificationType, Recipient)}.
   *
   * <ul>
   *   <li>Given {@link Recipient} (default constructor) AccountName is {@code Dr Jane Doe}.
   *   <li>Then calls {@link RecipientRepository#save(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link RecipientServiceImpl#markNotified(NotificationType, Recipient)}
   */
  @Test
  public void testMarkNotified_givenRecipientAccountNameIsDrJaneDoe_thenCallsSave() {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());
    when(recipientRepository.save(Mockito.<Recipient>any())).thenReturn(recipient);

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setFrequency(Frequency.WEEKLY);
    notificationSettings.setLastNotified(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    HashMap<NotificationType, NotificationSettings> scheduledNotifications = new HashMap<>();
    scheduledNotifications.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient2 = new Recipient();
    recipient2.setAccountName("Dr Jane Doe");
    recipient2.setEmail("jane.doe@example.org");
    recipient2.setScheduledNotifications(scheduledNotifications);

    // Act
    recipientServiceImpl.markNotified(NotificationType.BACKUP, recipient2);

    // Assert
    verify(recipientRepository).save(isA(Recipient.class));
  }

  /**
   * Test {@link RecipientServiceImpl#markNotified(NotificationType, Recipient)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RecipientServiceImpl#markNotified(NotificationType, Recipient)}
   */
  @Test
  public void testMarkNotified_thenThrowIllegalArgumentException() {
    // Arrange
    when(recipientRepository.save(Mockito.<Recipient>any()))
        .thenThrow(new IllegalArgumentException());

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setActive(true);
    notificationSettings.setFrequency(Frequency.WEEKLY);
    notificationSettings.setLastNotified(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    HashMap<NotificationType, NotificationSettings> scheduledNotifications = new HashMap<>();
    scheduledNotifications.put(NotificationType.BACKUP, notificationSettings);

    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(scheduledNotifications);

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    recipientServiceImpl.markNotified(NotificationType.BACKUP, recipient);
    verify(recipientRepository).save(isA(Recipient.class));
  }
}
