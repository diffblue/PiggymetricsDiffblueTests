package com.piggymetrics.auth.controller;

import static org.junit.Assert.assertEquals;

import com.piggymetrics.auth.domain.User;
import com.sun.security.auth.UserPrincipal;

import java.security.Principal;

import org.junit.Ignore;
import org.junit.Test;

public class UserControllerDiffblueTest {
    /**
     * Test {@link UserController#getUser(Principal)}.
     * <p>
     * Method under test: {@link UserController#getUser(Principal)}
     */
    @Test
    public void testGetUser() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        UserController userController = new UserController();

        // Act and Assert
        assertEquals("principal", userController.getUser(new UserPrincipal("principal")).getName());
    }

    /**
     * Test {@link UserController#createUser(User)}.
     * <p>
     * Method under test: {@link UserController#createUser(User)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testCreateUser() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Unable to load class.
        //   Class: jakarta.servlet.ServletContext
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        UserController userController = null;
        User user = null;

        // Act
        userController.createUser(user);

        // Assert
        // TODO: Add assertions on result
    }
}
