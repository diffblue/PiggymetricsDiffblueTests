package com.piggymetrics.auth.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UserDiffblueTest {
  /**
   * Test {@link User#getAuthorities()}.
   *
   * <p>Method under test: {@link User#getAuthorities()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List User.getAuthorities()"})
  public void testGetAuthorities() {
    // Arrange, Act and Assert
    assertNull(new User().getAuthorities());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void User.<init>()",
    "String User.getPassword()",
    "String User.getUsername()",
    "boolean User.isAccountNonExpired()",
    "boolean User.isAccountNonLocked()",
    "boolean User.isCredentialsNonExpired()",
    "boolean User.isEnabled()",
    "void User.setPassword(String)",
    "void User.setUsername(String)"
  })
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

    // Assert
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUsername);
    assertTrue(actualIsAccountNonExpiredResult);
    assertTrue(actualIsAccountNonLockedResult);
    assertTrue(actualIsCredentialsNonExpiredResult);
    assertTrue(actualUser.isEnabled());
  }
}
