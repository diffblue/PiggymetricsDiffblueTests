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
  *   <li>{@link User#getAuthorities()}
  *   <li>{@link User#getPassword()}
  *   <li>{@link User#getUsername()}
  *   <li>{@link User#isAccountNonExpired()}
  *   <li>{@link User#isAccountNonLocked()}
  *   <li>{@link User#isCredentialsNonExpired()}
  *   <li>{@link User#isEnabled()}
  * </ul>
  */
  @Test
  public void testConstructor() {
    // Arrange and Act
    User actualUser = new User();
    actualUser.setPassword("iloveyou");
    actualUser.setUsername("janedoe");
    actualUser.getAuthorities();

    // Assert that nothing has changed
    assertEquals("iloveyou", actualUser.getPassword());
    assertEquals("janedoe", actualUser.getUsername());
    assertTrue(actualUser.isAccountNonExpired());
    assertTrue(actualUser.isAccountNonLocked());
    assertTrue(actualUser.isCredentialsNonExpired());
    assertTrue(actualUser.isEnabled());
  }
}

