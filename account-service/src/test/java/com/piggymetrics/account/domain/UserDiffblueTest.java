package com.piggymetrics.account.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserDiffblueTest {
    /**
     * Test {@link User#setUsername(String)}.
     * <ul>
     *   <li>When {@code qw}.</li>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link User#setUsername(String)}
     */
    @Test
    @DisplayName("Test setUsername(String); when 'qw'; then throw IllegalArgumentException")
    @Tag("MaintainedByDiffblue")
    void testSetUsername_whenQw_thenThrowIllegalArgumentException() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> (new User()).setUsername("qw"));
    }

    /**
     * Test {@link User#setUsername(String)}.
     * <ul>
     *   <li>When {@code Smith}.</li>
     *   <li>Then {@link User} (default constructor) Username is {@code Smith}.</li>
     * </ul>
     * <p>
     * Method under test: {@link User#setUsername(String)}
     */
    @Test
    @DisplayName("Test setUsername(String); when 'Smith'; then User (default constructor) Username is 'Smith'")
    @Tag("MaintainedByDiffblue")
    void testSetUsername_whenSmith_thenUserUsernameIsSmith() {
        // Arrange
        User user = new User();

        // Act
        user.setUsername("Smith");

        // Assert
        assertEquals("Smith", user.getUsername());
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getUsername()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    @Tag("MaintainedByDiffblue")
    void testGettersAndSetters() {
        // Arrange
        User user = new User();

        // Act
        String actualPassword = user.getPassword();

        // Assert
        assertNull(actualPassword);
        assertNull(user.getUsername());
    }

    /**
     * Test {@link User#setPassword(String)}.
     * <ul>
     *   <li>When {@code abc}.</li>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link User#setPassword(String)}
     */
    @Test
    @DisplayName("Test setPassword(String); when 'abc'; then throw IllegalArgumentException")
    @Tag("MaintainedByDiffblue")
    void testSetPassword_whenAbc_thenThrowIllegalArgumentException() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> (new User()).setPassword("abc"));
    }

    /**
     * Test {@link User#setPassword(String)}.
     * <ul>
     *   <li>When {@code qwertyuio}.</li>
     *   <li>Then {@link User} (default constructor) Password is
     * {@code qwertyuio}.</li>
     * </ul>
     * <p>
     * Method under test: {@link User#setPassword(String)}
     */
    @Test
    @DisplayName("Test setPassword(String); when 'qwertyuio'; then User (default constructor) Password is 'qwertyuio'")
    @Tag("MaintainedByDiffblue")
    void testSetPassword_whenQwertyuio_thenUserPasswordIsQwertyuio() {
        // Arrange
        User user = new User();

        // Act
        user.setPassword("qwertyuio");

        // Assert
        assertEquals("qwertyuio", user.getPassword());
    }
}
