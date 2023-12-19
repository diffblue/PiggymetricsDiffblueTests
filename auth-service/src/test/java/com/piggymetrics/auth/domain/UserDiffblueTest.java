package com.piggymetrics.auth.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UserDiffblueTest {
  /**
   * Method under test: {@link User#getAuthorities()}
   */
  @Test
  public void testGetAuthorities() {
    // Arrange, Act and Assert
    assertNull((new User()).getAuthorities());
  }

  /**
   * Methods under test:
   * 
   * <ul>
   *   <li>default or parameterless constructor of {@link User}
   *   <li>{@link User#setPassword(String)}
   *   <li>{@link User#setUsername(String)}
   *   <li>{@link User#getPassword()}
   *   <li>{@link User#getUsername()}
   *   <li>{@link User#isAccountNonExpired()}
   *   <li>{@link User#isAccountNonLocked()}
   *   <li>{@link User#isCredentialsNonExpired()}
   *   <li>{@link User#isEnabled()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    User actualUser = new User();
    actualUser.setPassword("iloveyou");
    actualUser.setUsername("janedoe");
    String actualPassword = actualUser.getPassword();
    String actualUsername = actualUser.getUsername();
    boolean actualIsAccountNonExpiredResult = actualUser.isAccountNonExpired();
    boolean actualIsAccountNonLockedResult = actualUser.isAccountNonLocked();
    boolean actualIsCredentialsNonExpiredResult = actualUser.isCredentialsNonExpired();

    // Assert that nothing has changed
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUsername);
    assertTrue(actualIsAccountNonExpiredResult);
    assertTrue(actualIsAccountNonLockedResult);
    assertTrue(actualIsCredentialsNonExpiredResult);
    assertTrue(actualUser.isEnabled());
  }
}
