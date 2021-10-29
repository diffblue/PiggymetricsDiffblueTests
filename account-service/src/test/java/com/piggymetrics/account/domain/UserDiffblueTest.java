package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserDiffblueTest {
  @Test
  public void testConstructor() {
    // Arrange and Act
    User actualUser = new User();
    actualUser.setPassword("iloveyou");
    actualUser.setUsername("janedoe");

    // Assert
    assertEquals("iloveyou", actualUser.getPassword());
    assertEquals("janedoe", actualUser.getUsername());
  }
}

