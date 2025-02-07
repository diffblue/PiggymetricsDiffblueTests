package com.piggymetrics.account.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserValidatorDiffblueTest {
    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>Given {@code null}.</li>
     *   <li>When {@link User} (default constructor) Username is {@code null}.</li>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); given 'null'; when User (default constructor) Username is 'null'; then throw IllegalArgumentException")
    @Tag("MaintainedByDiffblue")
    void testValidate_givenNull_whenUserUsernameIsNull_thenThrowIllegalArgumentException() {
        // Arrange
        User user = new User();
        user.setUsername(null);
        user.setPassword(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UserValidator.validate(user));
    }

    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>Given {@code qw}.</li>
     *   <li>When {@link User} (default constructor) Username is {@code qw}.</li>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); given 'qw'; when User (default constructor) Username is 'qw'; then throw IllegalArgumentException")
    @Tag("MaintainedByDiffblue")
    void testValidate_givenQw_whenUserUsernameIsQw_thenThrowIllegalArgumentException() {
        // Arrange
        User user = new User();
        user.setPassword("abc");
        user.setUsername("qw");

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UserValidator.validate(user));
    }

    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>Given {@code qwertyuio}.</li>
     *   <li>When {@link User} (default constructor) Password is
     * {@code qwertyuio}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); given 'qwertyuio'; when User (default constructor) Password is 'qwertyuio'; then return 'true'")
    @Tag("MaintainedByDiffblue")
    void testValidate_givenQwertyuio_whenUserPasswordIsQwertyuio_thenReturnTrue() {
        // Arrange
        User user = new User();
        user.setPassword("qwertyuio");
        user.setUsername("Smith");

        // Act and Assert
        assertTrue(UserValidator.validate(user));
    }

    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>Given {@code SmithCredentials Invalid}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); given 'SmithCredentials Invalid'")
    @Tag("MaintainedByDiffblue")
    void testValidate_givenSmithCredentialsInvalid() {
        // Arrange
        User user = new User();
        user.setPassword("abc");
        user.setUsername("SmithCredentials Invalid");

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UserValidator.validate(user));
    }

    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>Given {@code Smith}.</li>
     *   <li>When {@link User} (default constructor) Username is {@code Smith}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); given 'Smith'; when User (default constructor) Username is 'Smith'")
    @Tag("MaintainedByDiffblue")
    void testValidate_givenSmith_whenUserUsernameIsSmith() {
        // Arrange
        User user = new User();
        user.setPassword("abc");
        user.setUsername("Smith");

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UserValidator.validate(user));
    }

    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>When {@code null}.</li>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); when 'null'; then throw IllegalArgumentException")
    @Tag("MaintainedByDiffblue")
    void testValidate_whenNull_thenThrowIllegalArgumentException() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UserValidator.validate(null));
    }

    /**
     * Test {@link UserValidator#validateUsername(String)}.
     * <ul>
     *   <li>When {@code null}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validateUsername(String)}
     */
    @Test
    @DisplayName("Test validateUsername(String); when 'null'; then return 'false'")
    @Tag("MaintainedByDiffblue")
    void testValidateUsername_whenNull_thenReturnFalse() throws IllegalArgumentException {
        // Arrange, Act and Assert
        assertFalse(UserValidator.validateUsername(null));
    }

    /**
     * Test {@link UserValidator#validateUsername(String)}.
     * <ul>
     *   <li>When {@code qw}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validateUsername(String)}
     */
    @Test
    @DisplayName("Test validateUsername(String); when 'qw'; then return 'false'")
    @Tag("MaintainedByDiffblue")
    void testValidateUsername_whenQw_thenReturnFalse() throws IllegalArgumentException {
        // Arrange, Act and Assert
        assertFalse(UserValidator.validateUsername("qw"));
    }

    /**
     * Test {@link UserValidator#validateUsername(String)}.
     * <ul>
     *   <li>When {@code SmithUsernameUsername}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validateUsername(String)}
     */
    @Test
    @DisplayName("Test validateUsername(String); when 'SmithUsernameUsername'; then return 'false'")
    @Tag("MaintainedByDiffblue")
    void testValidateUsername_whenSmithUsernameUsername_thenReturnFalse() throws IllegalArgumentException {
        // Arrange, Act and Assert
        assertFalse(UserValidator.validateUsername("SmithUsernameUsername"));
    }

    /**
     * Test {@link UserValidator#validateUsername(String)}.
     * <ul>
     *   <li>When {@code Smith}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validateUsername(String)}
     */
    @Test
    @DisplayName("Test validateUsername(String); when 'Smith'; then return 'true'")
    @Tag("MaintainedByDiffblue")
    void testValidateUsername_whenSmith_thenReturnTrue() throws IllegalArgumentException {
        // Arrange, Act and Assert
        assertTrue(UserValidator.validateUsername("Smith"));
    }

    /**
     * Test {@link UserValidator#validatePassword(String)}.
     * <ul>
     *   <li>When {@code abc}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validatePassword(String)}
     */
    @Test
    @DisplayName("Test validatePassword(String); when 'abc'; then return 'false'")
    @Tag("MaintainedByDiffblue")
    void testValidatePassword_whenAbc_thenReturnFalse() throws IllegalArgumentException {
        // Arrange, Act and Assert
        assertFalse(UserValidator.validatePassword("abc"));
    }

    /**
     * Test {@link UserValidator#validatePassword(String)}.
     * <ul>
     *   <li>When {@code null}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validatePassword(String)}
     */
    @Test
    @DisplayName("Test validatePassword(String); when 'null'; then return 'false'")
    @Tag("MaintainedByDiffblue")
    void testValidatePassword_whenNull_thenReturnFalse() throws IllegalArgumentException {
        // Arrange, Act and Assert
        assertFalse(UserValidator.validatePassword(null));
    }

    /**
     * Test {@link UserValidator#validatePassword(String)}.
     * <ul>
     *   <li>When {@code qwertyuio}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validatePassword(String)}
     */
    @Test
    @DisplayName("Test validatePassword(String); when 'qwertyuio'; then return 'true'")
    @Tag("MaintainedByDiffblue")
    void testValidatePassword_whenQwertyuio_thenReturnTrue() throws IllegalArgumentException {
        // Arrange, Act and Assert
        assertTrue(UserValidator.validatePassword("qwertyuio"));
    }
}
