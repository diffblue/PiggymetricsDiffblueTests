package com.piggymetrics.notification.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggymetrics.notification.domain.NotificationSettings;
import com.piggymetrics.notification.domain.NotificationType;
import com.piggymetrics.notification.domain.Recipient;
import com.piggymetrics.notification.service.RecipientServiceImpl;
import com.sun.security.auth.UserPrincipal;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RecipientController.class})
@RunWith(SpringRunner.class)
public class RecipientControllerDiffblueTest {
  @Autowired
  private RecipientController recipientController;

  @MockBean
  private RecipientServiceImpl recipientServiceImpl;
  @Test
  public void testGetCurrentNotificationsSettings() throws Exception {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<NotificationType, NotificationSettings>(1));
    recipient.setAccountName("Dr Jane Doe");
    when(this.recipientServiceImpl.findByAccountName((String) any())).thenReturn(recipient);
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/recipients/current");
    getResult.principal(new UserPrincipal("principal"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(this.recipientController)
        .build()
        .perform(getResult)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"accountName\":\"Dr Jane Doe\",\"email\":\"jane.doe@example.org\",\"scheduledNotifications\":{}}"));
  }

  @Test
  public void testSaveCurrentNotificationsSettings() throws Exception {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<NotificationType, NotificationSettings>(1));
    recipient.setAccountName("Dr Jane Doe");
    when(this.recipientServiceImpl.save((String) any(), (Recipient) any())).thenReturn(recipient);
    MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/recipients/current");
    putResult.principal(new UserPrincipal("principal"));

    Recipient recipient1 = new Recipient();
    recipient1.setEmail("jane.doe@example.org");
    recipient1.setScheduledNotifications(new HashMap<NotificationType, NotificationSettings>(1));
    recipient1.setAccountName("Dr Jane Doe");
    String content = (new ObjectMapper()).writeValueAsString(recipient1);
    MockHttpServletRequestBuilder requestBuilder = putResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(this.recipientController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"accountName\":\"Dr Jane Doe\",\"email\":\"jane.doe@example.org\",\"scheduledNotifications\":{}}"));
  }
}

