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
     *   <li>When createUser Username is {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); given 'null'; when createUser Username is 'null'")
    @Tag("MaintainedByDiffblue")
    void testValidate_givenNull_whenCreateUserUsernameIsNull() {
        // Arrange
        User user = UserFactory.createUser();
        user.setUsername(null);
        user.setPassword(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UserValidator.validate(user));
    }

    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>Given {@code qw}.</li>
     *   <li>When createUser Username is {@code qw}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); given 'qw'; when createUser Username is 'qw'")
    @Tag("MaintainedByDiffblue")
    void testValidate_givenQw_whenCreateUserUsernameIsQw() {
        // Arrange
        User user = UserFactory.createUser();
        user.setUsername("qw");
        user.setPassword(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UserValidator.validate(user));
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
        User user = UserFactory.createUser();
        user.setUsername("SmithCredentials Invalid");
        user.setPassword(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UserValidator.validate(user));
    }

    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>Given {@code User}.</li>
     *   <li>When createUser Password is {@code User}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); given 'User'; when createUser Password is 'User'")
    @Tag("MaintainedByDiffblue")
    void testValidate_givenUser_whenCreateUserPasswordIsUser() {
        // Arrange
        User user = UserFactory.createUser();
        user.setUsername(null);
        user.setPassword("User");

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UserValidator.validate(user));
    }

    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>Given {@code User}.</li>
     *   <li>When createUser Username is {@code User}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); given 'User'; when createUser Username is 'User'")
    @Tag("MaintainedByDiffblue")
    void testValidate_givenUser_whenCreateUserUsernameIsUser() {
        // Arrange
        User user = UserFactory.createUser();
        user.setUsername("User");
        user.setPassword(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UserValidator.validate(user));
    }

    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>When createUser.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); when createUser; then return 'true'")
    @Tag("MaintainedByDiffblue")
    void testValidate_whenCreateUser_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(UserValidator.validate(UserFactory.createUser()));
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
