package com.piggymetrics.statistics.service.security;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.FixedAuthoritiesExtractor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CustomUserInfoTokenServices.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomUserInfoTokenServicesDiffblueTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private CustomUserInfoTokenServices customUserInfoTokenServices;

    /**
     * Test {@link CustomUserInfoTokenServices#loadAuthentication(String)}.
     * <p>
     * Method under test:
     * {@link CustomUserInfoTokenServices#loadAuthentication(String)}
     */
    @Test
    public void testLoadAuthentication() throws AuthenticationException, InvalidTokenException {
        // Arrange, Act and Assert
        thrown.expect(InvalidTokenException.class);
        customUserInfoTokenServices.loadAuthentication("ABC123");
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
    public void testGettersAndSetters() {
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
     * Test {@link CustomUserInfoTokenServices#readAccessToken(String)}.
     * <p>
     * Method under test:
     * {@link CustomUserInfoTokenServices#readAccessToken(String)}
     */
    @Test
    public void testReadAccessToken() {
        // Arrange, Act and Assert
        thrown.expect(UnsupportedOperationException.class);
        customUserInfoTokenServices.readAccessToken("ABC123");
    }

    /**
     * Test
     * {@link CustomUserInfoTokenServices#CustomUserInfoTokenServices(String, String)}.
     * <p>
     * Method under test:
     * {@link CustomUserInfoTokenServices#CustomUserInfoTokenServices(String, String)}
     */
    @Test
    public void testNewCustomUserInfoTokenServices() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        new CustomUserInfoTokenServices("https://example.org/example", "42");

    }
}
