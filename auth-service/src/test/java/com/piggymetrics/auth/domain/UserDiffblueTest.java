package com.piggymetrics.auth.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
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
    public void testGettersAndSetters2() {
        // Arrange
        User user = new User();

        // Act
        user.setPassword("abc");
        user.setUsername("Smith");
        String actualPassword = user.getPassword();
        String actualUsername = user.getUsername();
        boolean actualIsAccountNonExpiredResult = user.isAccountNonExpired();
        boolean actualIsAccountNonLockedResult = user.isAccountNonLocked();
        boolean actualIsCredentialsNonExpiredResult = user.isCredentialsNonExpired();

        // Assert
        assertEquals("Smith", actualUsername);
        assertEquals("abc", actualPassword);
        assertTrue(actualIsAccountNonExpiredResult);
        assertTrue(actualIsAccountNonLockedResult);
        assertTrue(actualIsCredentialsNonExpiredResult);
        assertTrue(user.isEnabled());
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
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
        // Arrange
        User user = new User();

        // Act
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        String actualPassword = user.getPassword();
        String actualUsername = user.getUsername();
        boolean actualIsAccountNonExpiredResult = user.isAccountNonExpired();
        boolean actualIsAccountNonLockedResult = user.isAccountNonLocked();
        boolean actualIsCredentialsNonExpiredResult = user.isCredentialsNonExpired();

        // Assert
        assertEquals("iloveyou", actualPassword);
        assertEquals("janedoe", actualUsername);
        assertTrue(actualIsAccountNonExpiredResult);
        assertTrue(actualIsAccountNonLockedResult);
        assertTrue(actualIsCredentialsNonExpiredResult);
        assertTrue(user.isEnabled());
    }

    /**
     * Test {@link User#getAuthorities()}.
     * <p>
     * Method under test: {@link User#getAuthorities()}
     */
    @Test
    public void testGetAuthorities() {
        // Arrange, Act and Assert
        assertNull((new User()).getAuthorities());
    }
}
