package com.piggymetrics.account.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorHandlerDiffblueTest {
    /**
     * Test {@link ErrorHandler#processValidationError(IllegalArgumentException)}.
     * <p>
     * Method under test:
     * {@link ErrorHandler#processValidationError(IllegalArgumentException)}
     */
    @Test
    @DisplayName("Test processValidationError(IllegalArgumentException)")
    void testProcessValidationError() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ErrorHandler.log

        // Arrange
        ErrorHandler errorHandler = new ErrorHandler();

        // Act
        errorHandler.processValidationError(new IllegalArgumentException("foo"));
    }
}
