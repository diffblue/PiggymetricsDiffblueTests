package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UserDiffblueTest {
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
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void User.<init>()",
    "String User.getPassword()",
    "String User.getUsername()",
    "void User.setPassword(String)",
    "void User.setUsername(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    User actualUser = new User();
    actualUser.setPassword("iloveyou");
    actualUser.setUsername("janedoe");
    String actualPassword = actualUser.getPassword();

    // Assert
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUser.getUsername());
  }
}
