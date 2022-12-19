package com.piggymetrics.account.service.security;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;

public class CustomUserInfoTokenServicesDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  /**
  * Method under test: {@link CustomUserInfoTokenServices#loadAuthentication(String)}
  */
  @Test
  public void testLoadAuthentication() throws AuthenticationException, InvalidTokenException {
    // Arrange, Act and Assert
    thrown.expect(InvalidTokenException.class);
    (new CustomUserInfoTokenServices("https://config.us-east-2.amazonaws.com", "42")).loadAuthentication("ABC123");
  }

  /**
   * Method under test: {@link CustomUserInfoTokenServices#loadAuthentication(String)}
   */
  @Test
  public void testLoadAuthentication2() throws AuthenticationException, InvalidTokenException {
    // Arrange
    CustomUserInfoTokenServices customUserInfoTokenServices = new CustomUserInfoTokenServices(
        "https://config.us-east-2.amazonaws.com", "42");
    customUserInfoTokenServices.setRestTemplate(new OAuth2RestTemplate(new BaseOAuth2ProtectedResourceDetails()));

    // Act and Assert
    thrown.expect(InvalidTokenException.class);
    customUserInfoTokenServices.loadAuthentication("ABC123");
  }

  /**
   * Method under test: {@link CustomUserInfoTokenServices#readAccessToken(String)}
   */
  @Test
  public void testReadAccessToken() {
    // Arrange, Act and Assert
    thrown.expect(UnsupportedOperationException.class);
    (new CustomUserInfoTokenServices("https://config.us-east-2.amazonaws.com", "42")).readAccessToken("ABC123");
  }

  /**
   * Method under test: {@link CustomUserInfoTokenServices#readAccessToken(String)}
   */
  @Test
  public void testReadAccessToken2() {
    // Arrange, Act and Assert
    thrown.expect(UnsupportedOperationException.class);
    (new CustomUserInfoTokenServices("42", "Bearer")).readAccessToken("ABC123");
  }
}

