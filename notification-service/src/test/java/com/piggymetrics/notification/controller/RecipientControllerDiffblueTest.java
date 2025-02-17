package com.piggymetrics.notification.controller;

import static org.mockito.Mockito.when;
import com.piggymetrics.notification.domain.Recipient;
import com.piggymetrics.notification.service.RecipientService;
import com.sun.security.auth.UserPrincipal;
import java.security.Principal;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RecipientController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RecipientControllerDiffblueTest {
  @Autowired
  private RecipientController recipientController;

  @MockBean
  private RecipientService recipientService;

  /**
   * Test {@link RecipientController#getCurrentNotificationsSettings(Principal)}.
   * <p>
   * Method under test: {@link RecipientController#getCurrentNotificationsSettings(Principal)}
   */
  @Test
  public void testGetCurrentNotificationsSettings() throws Exception {
    // Arrange
    Recipient recipient = new Recipient();
    recipient.setAccountName("Dr Jane Doe");
    recipient.setEmail("jane.doe@example.org");
    recipient.setScheduledNotifications(new HashMap<>());
    when(recipientService.findByAccountName(Mockito.<String>any())).thenReturn(recipient);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/recipients/current");
    requestBuilder.principal(new UserPrincipal("principal"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(recipientController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"accountName\":\"Dr Jane Doe\",\"email\":\"jane.doe@example.org\",\"scheduledNotifications\":{}}"));
  }
}
