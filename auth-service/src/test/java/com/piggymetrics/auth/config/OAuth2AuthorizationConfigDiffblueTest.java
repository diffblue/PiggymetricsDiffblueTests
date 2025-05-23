package com.piggymetrics.auth.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OAuth2AuthorizationConfigDiffblueTest {
  @MockBean
  private MongodExecutable mongodExecutable;

  @Autowired
  private OAuth2AuthorizationConfig oAuth2AuthorizationConfig;

  /**
   * Test {@link OAuth2AuthorizationConfig#configure(ClientDetailsServiceConfigurer)} with {@code clients}.
   * <p>
   * Method under test: {@link OAuth2AuthorizationConfig#configure(ClientDetailsServiceConfigurer)}
   */
  @Test
  public void testConfigureWithClients() throws Exception {
    // Arrange
    ClientDetailsServiceConfigurer clients = new ClientDetailsServiceConfigurer(new ClientDetailsServiceBuilder<>());

    // Act
    oAuth2AuthorizationConfig.configure(clients);

    // Assert
    assertTrue(clients.and() instanceof InMemoryClientDetailsServiceBuilder);
  }

  /**
   * Test {@link OAuth2AuthorizationConfig#configure(AuthorizationServerEndpointsConfigurer)} with {@code endpoints}.
   * <p>
   * Method under test: {@link OAuth2AuthorizationConfig#configure(AuthorizationServerEndpointsConfigurer)}
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
   * Test {@link OAuth2AuthorizationConfig#configure(AuthorizationServerSecurityConfigurer)} with {@code oauthServer}.
   * <p>
   * Method under test: {@link OAuth2AuthorizationConfig#configure(AuthorizationServerSecurityConfigurer)}
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
