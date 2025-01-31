package com.piggymetrics.account.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LicenseCheckerDiffblueTest extends LicenseCheckerDiffblueBase {
    /**
     * Test {@link LicenseChecker#setValidLicenseKey(String)}.
     * <p>
     * Method under test: {@link LicenseChecker#setValidLicenseKey(String)}
     */
    @Test
    @DisplayName("Test setValidLicenseKey(String)")
    void testSetValidLicenseKey() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> LicenseChecker
                .setValidLicenseKey("Invalid license key provided. It must be between 25 and 50 characters."));
    }

    /**
     * Test {@link LicenseChecker#setValidLicenseKey(String)}.
     * <ul>
     *   <li>When empty string.</li>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link LicenseChecker#setValidLicenseKey(String)}
     */
    @Test
    @DisplayName("Test setValidLicenseKey(String); when empty string; then throw IllegalArgumentException")
    void testSetValidLicenseKey_whenEmptyString_thenThrowIllegalArgumentException() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> LicenseChecker.setValidLicenseKey(""));
    }

    /**
     * Test {@link LicenseChecker#setValidLicenseKey(String)}.
     * <ul>
     *   <li>When {@code License Key}.</li>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link LicenseChecker#setValidLicenseKey(String)}
     */
    @Test
    @DisplayName("Test setValidLicenseKey(String); when 'License Key'; then throw IllegalArgumentException")
    void testSetValidLicenseKey_whenLicenseKey_thenThrowIllegalArgumentException() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> LicenseChecker.setValidLicenseKey("License Key"));
    }

    /**
     * Test {@link LicenseChecker#setValidLicenseKey(String)}.
     * <ul>
     *   <li>When {@code null}.</li>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link LicenseChecker#setValidLicenseKey(String)}
     */
    @Test
    @DisplayName("Test setValidLicenseKey(String); when 'null'; then throw IllegalArgumentException")
    void testSetValidLicenseKey_whenNull_thenThrowIllegalArgumentException() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> LicenseChecker.setValidLicenseKey(null));
    }

    /**
     * Test {@link LicenseChecker#validateLicense(String)}.
     * <ul>
     *   <li>When {@code 12312312414fdgdfgfdgdfGbPxRfiCY}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link LicenseChecker#validateLicense(String)}
     */
    @Test
    @DisplayName("Test validateLicense(String); when '12312312414fdgdfgfdgdfGbPxRfiCY'; then return 'true'")
    void testValidateLicense_when12312312414fdgdfgfdgdfGbPxRfiCY_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(LicenseChecker.validateLicense("12312312414fdgdfgfdgdfGbPxRfiCY"));
    }

    /**
     * Test {@link LicenseChecker#validateLicense(String)}.
     * <ul>
     *   <li>When {@code EXAMPLEKEaaabbbcccdddeeefffggggg}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link LicenseChecker#validateLicense(String)}
     */
    @Test
    @DisplayName("Test validateLicense(String); when 'EXAMPLEKEaaabbbcccdddeeefffggggg'; then return 'false'")
    void testValidateLicense_whenEXAMPLEKEaaabbbcccdddeeefffggggg_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(LicenseChecker.validateLicense("EXAMPLEKEaaabbbcccdddeeefffggggg"));
    }

    /**
     * Test {@link LicenseChecker#validateLicense(String)}.
     * <ul>
     *   <li>When empty string.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link LicenseChecker#validateLicense(String)}
     */
    @Test
    @DisplayName("Test validateLicense(String); when empty string; then return 'false'")
    void testValidateLicense_whenEmptyString_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(LicenseChecker.validateLicense(""));
    }

    /**
     * Test {@link LicenseChecker#validateLicense(String)}.
     * <ul>
     *   <li>When {@code null}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link LicenseChecker#validateLicense(String)}
     */
    @Test
    @DisplayName("Test validateLicense(String); when 'null'; then return 'false'")
    void testValidateLicense_whenNull_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(LicenseChecker.validateLicense(null));
    }

    /**
     * Test {@link LicenseChecker#runCheck(String[])}.
     * <ul>
     *   <li>When array of {@link String} with
     * {@code 12312312414fdgdfgfdgdfGbPxRfiCY}.</li>
     * </ul>
     * <p>
     * Method under test: {@link LicenseChecker#runCheck(String[])}
     */
    @Test
    @DisplayName("Test runCheck(String[]); when array of String with '12312312414fdgdfgfdgdfGbPxRfiCY'")
    void testRunCheck_whenArrayOfStringWith12312312414fdgdfgfdgdfGbPxRfiCY() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        LicenseChecker.runCheck(new String[]{"12312312414fdgdfgfdgdfGbPxRfiCY"});
    }

    /**
     * Test {@link LicenseChecker#runCheck(String[])}.
     * <ul>
     *   <li>When array of {@link String} with {@code Args}.</li>
     * </ul>
     * <p>
     * Method under test: {@link LicenseChecker#runCheck(String[])}
     */
    @Test
    @DisplayName("Test runCheck(String[]); when array of String with 'Args'")
    @Disabled("TODO: Complete this test")
    void testRunCheck_whenArrayOfStringWithArgs() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        // Arrange and Act
        LicenseChecker.runCheck(new String[]{"Args"});
    }
}
