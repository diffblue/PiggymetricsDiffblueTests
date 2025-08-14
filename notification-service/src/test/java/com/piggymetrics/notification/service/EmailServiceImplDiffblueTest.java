package com.piggymetrics.notification.service;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.piggymetrics.notification.domain.NotificationType;
import com.piggymetrics.notification.domain.Recipient;
import java.io.IOException;
import java.util.HashMap;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceImplDiffblueTest {
  @InjectMocks private EmailServiceImpl emailServiceImpl;

  @Mock private Environment environment;

  @Mock private JavaMailSender javaMailSender;

  /**
   * Test {@link EmailServiceImpl#send(NotificationType, Recipient, String)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return {@code
   *       Property}.
   *   <li>Then calls {@link Environment#getProperty(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EmailServiceImpl#send(NotificationType, Recipient, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailServiceImpl.send(NotificationType, Recipient, String)"})
  public void testSend_givenEnvironmentGetPropertyReturnProperty_thenCallsGetProperty()
      throws IOException, MessagingException, MailException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    doNothing().when(javaMailSender).send(Mockito.<MimeMessage>any());
    when(javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));

    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());

    // Act
    emailServiceImpl.send(NotificationType.BACKUP, recipient, "Attachment");

    // Assert
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(javaMailSender).createMimeMessage();
    verify(javaMailSender).send(isA(MimeMessage.class));
  }

  /**
   * Test {@link EmailServiceImpl#send(NotificationType, Recipient, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then calls {@link Environment#getProperty(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EmailServiceImpl#send(NotificationType, Recipient, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailServiceImpl.send(NotificationType, Recipient, String)"})
  public void testSend_whenEmptyString_thenCallsGetProperty()
      throws IOException, MessagingException, MailException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    doNothing().when(javaMailSender).send(Mockito.<MimeMessage>any());
    when(javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));

    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());

    // Act
    emailServiceImpl.send(NotificationType.BACKUP, recipient, "");

    // Assert
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(javaMailSender).createMimeMessage();
    verify(javaMailSender).send(isA(MimeMessage.class));
  }
}
