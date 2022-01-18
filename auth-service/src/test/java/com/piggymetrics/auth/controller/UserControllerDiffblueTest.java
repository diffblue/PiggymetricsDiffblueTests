package com.piggymetrics.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggymetrics.auth.domain.User;
import com.piggymetrics.auth.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@RunWith(SpringRunner.class)
public class UserControllerDiffblueTest {
  @Autowired
  private UserController userController;

  @MockBean
  private UserService userService;
  @Test
  public void testCreateUser() throws Exception {
    // Arrange
    User user = new User();
    user.setPassword("iloveyou");
    user.setUsername("janedoe");
    String content = (new ObjectMapper()).writeValueAsString(user);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
  }

  @Test
  public void testGetUser() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/current");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(this.userController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void testGetUser2() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/users/current");
    getResult.characterEncoding("Encoding");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(this.userController)
        .build()
        .perform(getResult)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}

