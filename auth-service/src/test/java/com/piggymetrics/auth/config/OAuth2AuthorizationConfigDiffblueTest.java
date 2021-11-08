package com.piggymetrics.auth.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OAuth2AuthorizationConfigDiffblueTest {
  @Autowired
  private OAuth2AuthorizationConfig oAuth2AuthorizationConfig;
  @Test
  public void testConfigure() throws Exception {
    // Arrange
    AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer = new AuthorizationServerEndpointsConfigurer();

    // Act
    this.oAuth2AuthorizationConfig.configure(authorizationServerEndpointsConfigurer);

    // Assert
    assertTrue(authorizationServerEndpointsConfigurer.isUserDetailsServiceOverride());
    assertTrue(authorizationServerEndpointsConfigurer
        .getTokenStore() instanceof org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore);
  }

  @Test
  public void testConfigure2() throws Exception {
    // Arrange
    AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer = new AuthorizationServerSecurityConfigurer();

    // Act
    this.oAuth2AuthorizationConfig.configure(authorizationServerSecurityConfigurer);

    // Assert
    assertEquals("isAuthenticated()", authorizationServerSecurityConfigurer.getCheckTokenAccess());
    assertEquals("permitAll()", authorizationServerSecurityConfigurer.getTokenKeyAccess());
  }
}

