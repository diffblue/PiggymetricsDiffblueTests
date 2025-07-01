package com.piggymetrics.auth.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.auth.service.security.MongoUserDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@RunWith(MockitoJUnitRunner.class)
public class OAuth2AuthorizationConfigDiffblueTest {
  @Mock private Environment environment;

  @Mock private MongoUserDetailsService mongoUserDetailsService;

  @InjectMocks private OAuth2AuthorizationConfig oAuth2AuthorizationConfig;

  /**
   * Test {@link OAuth2AuthorizationConfig#configure(ClientDetailsServiceConfigurer)} with {@code
   * clients}.
   *
   * <p>Method under test: {@link
   * OAuth2AuthorizationConfig#configure(ClientDetailsServiceConfigurer)}
   */
  @Test
  public void testConfigureWithClients() throws Exception {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ClientDetailsServiceConfigurer clients =
        new ClientDetailsServiceConfigurer(new ClientDetailsServiceBuilder<>());

    // Act
    oAuth2AuthorizationConfig.configure(clients);

    // Assert
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any());
    assertTrue(clients.and() instanceof InMemoryClientDetailsServiceBuilder);
  }

  /**
   * Test {@link OAuth2AuthorizationConfig#configure(AuthorizationServerEndpointsConfigurer)} with
   * {@code endpoints}.
   *
   * <p>Method under test: {@link
   * OAuth2AuthorizationConfig#configure(AuthorizationServerEndpointsConfigurer)}
   */
  @Test
  public void testConfigureWithEndpoints() throws Exception {
    // Arrange
    AuthorizationServerEndpointsConfigurer endpoints = new AuthorizationServerEndpointsConfigurer();

    // Act
    oAuth2AuthorizationConfig.configure(endpoints);

    // Assert
    assertTrue(endpoints.isUserDetailsServiceOverride());
  }

  /**
   * Test {@link OAuth2AuthorizationConfig#configure(AuthorizationServerSecurityConfigurer)} with
   * {@code oauthServer}.
   *
   * <p>Method under test: {@link
   * OAuth2AuthorizationConfig#configure(AuthorizationServerSecurityConfigurer)}
   */
  @Test
  public void testConfigureWithOauthServer() throws Exception {
    // Arrange
    AuthorizationServerSecurityConfigurer oauthServer = new AuthorizationServerSecurityConfigurer();

    // Act
    oAuth2AuthorizationConfig.configure(oauthServer);

    // Assert
    assertEquals("isAuthenticated()", oauthServer.getCheckTokenAccess());
    assertEquals("permitAll()", oauthServer.getTokenKeyAccess());
  }
}
