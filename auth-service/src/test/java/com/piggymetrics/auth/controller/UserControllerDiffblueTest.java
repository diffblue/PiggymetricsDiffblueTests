package com.piggymetrics.auth.controller;

import static org.mockito.Mockito.doNothing;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggymetrics.auth.domain.User;
import com.piggymetrics.auth.service.UserService;
import java.security.Principal;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerDiffblueTest {
  @Autowired private UserController userController;

  @MockBean private UserService userService;

  /**
   * Test {@link UserController#getUser(Principal)}.
   *
   * <p>Method under test: {@link UserController#getUser(Principal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Principal UserController.getUser(Principal)"})
  public void testGetUser() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/current");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link UserController#createUser(User)}.
   *
   * <p>Method under test: {@link UserController#createUser(User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.createUser(User)"})
  public void testCreateUser() throws Exception {
    // Arrange
    doNothing().when(userService).create(Mockito.<User>any());

    User user = new User();
    user.setPassword("iloveyou");
    user.setUsername("janedoe");
    String content = new ObjectMapper().writeValueAsString(user);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
