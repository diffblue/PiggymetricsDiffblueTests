package com.piggymetrics.auth.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UserDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>default or parameterless constructor of {@link User}
  *   <li>{@link User#setPassword(String)}
  *   <li>{@link User#setUsername(String)}
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
    assertTrue(actualUser.isAccountNonExpired());
    assertTrue(actualUser.isAccountNonLocked());
    assertTrue(actualUser.isCredentialsNonExpired());
    assertTrue(actualUser.isEnabled());
  }
}

