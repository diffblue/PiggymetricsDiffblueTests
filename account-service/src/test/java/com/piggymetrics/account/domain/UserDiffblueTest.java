package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link User}
  *   <li>{@link User#setPassword(String)}
  *   <li>{@link User#setUsername(String)}
  *   <li>{@link User#getPassword()}
  *   <li>{@link User#getUsername()}
  * </ul>
  */
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

