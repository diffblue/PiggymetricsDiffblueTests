package com.piggymetrics.account.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserValidatorDiffblueTest {

    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>Given {@code abc}.</li>
     *   <li>When {@link User} (default constructor) Password is {@code abc}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); given 'abc'; when User (default constructor) Password is 'abc'")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testValidate_givenAbc_whenUserPasswordIsAbc() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at com.piggymetrics.account.domain.User.setPassword(User.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        User user = new User();
        user.setPassword("abc");
        user.setUsername("Smith");

        // Act
        UserValidator.validate(user);
    }

    /**
     * Test {@link UserValidator#validate(User)}.
     * <ul>
     *   <li>Given {@code qwertyuio}.</li>
     *   <li>When {@link User} (default constructor) Password is
     * {@code qwertyuio}.</li>
     * </ul>
     * <p>
     * Method under test: {@link UserValidator#validate(User)}
     */
    @Test
    @DisplayName("Test validate(User); given 'qwertyuio'; when User (default constructor) Password is 'qwertyuio'")
    @Tag("MaintainedByDiffblue")
    void testValidate_givenQwertyuio_whenUserPasswordIsQwertyuio() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        User user = new User();
        user.setPassword("qwertyuio");
        user.setUsername("Smith");

        // Act
        UserValidator.validate(user);
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
