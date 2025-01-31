package com.piggymetrics.account.service.security;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.FixedAuthoritiesExtractor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomUserInfoTokenServices.class, String.class})
@ExtendWith(SpringExtension.class)
class CustomUserInfoTokenServicesDiffblueTest {
    @Autowired
    private CustomUserInfoTokenServices customUserInfoTokenServices;

    /**
     * Test {@link CustomUserInfoTokenServices#loadAuthentication(String)}.
     * <p>
     * Method under test:
     * {@link CustomUserInfoTokenServices#loadAuthentication(String)}
     */
    @Test
    @DisplayName("Test loadAuthentication(String)")
    void testLoadAuthentication() throws AuthenticationException, InvalidTokenException {
        // Arrange, Act and Assert
        assertThrows(InvalidTokenException.class, () -> customUserInfoTokenServices.loadAuthentication("ABC123"));
    }

    /**
     * Test {@link CustomUserInfoTokenServices#readAccessToken(String)}.
     * <p>
     * Method under test:
     * {@link CustomUserInfoTokenServices#readAccessToken(String)}
     */
    @Test
    @DisplayName("Test readAccessToken(String)")
    void testReadAccessToken() {
        // Arrange, Act and Assert
        assertThrows(UnsupportedOperationException.class, () -> customUserInfoTokenServices.readAccessToken("ABC123"));
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>
     * {@link CustomUserInfoTokenServices#setAuthoritiesExtractor(AuthoritiesExtractor)}
     *   <li>{@link CustomUserInfoTokenServices#setRestTemplate(OAuth2RestOperations)}
     *   <li>{@link CustomUserInfoTokenServices#setTokenType(String)}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     CustomUserInfoTokenServices.authoritiesExtractor
        //     CustomUserInfoTokenServices.clientId
        //     CustomUserInfoTokenServices.logger
        //     CustomUserInfoTokenServices.restTemplate
        //     CustomUserInfoTokenServices.tokenType
        //     CustomUserInfoTokenServices.userInfoEndpointUrl

        // Arrange
        CustomUserInfoTokenServices customUserInfoTokenServices = new CustomUserInfoTokenServices(
                "https://example.org/example", "42");

        // Act
        customUserInfoTokenServices.setAuthoritiesExtractor(new FixedAuthoritiesExtractor());
        customUserInfoTokenServices.setRestTemplate(new OAuth2RestTemplate(new BaseOAuth2ProtectedResourceDetails()));
        customUserInfoTokenServices.setTokenType("ABC123");
    }

    /**
     * Test
     * {@link CustomUserInfoTokenServices#CustomUserInfoTokenServices(String, String)}.
     * <p>
     * Method under test:
     * {@link CustomUserInfoTokenServices#CustomUserInfoTokenServices(String, String)}
     */
    @Test
    @DisplayName("Test new CustomUserInfoTokenServices(String, String)")
    void testNewCustomUserInfoTokenServices() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        new CustomUserInfoTokenServices("https://example.org/example", "42");

    }
}
