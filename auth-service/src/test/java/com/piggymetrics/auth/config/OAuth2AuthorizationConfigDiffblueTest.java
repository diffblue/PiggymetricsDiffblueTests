package com.piggymetrics.auth.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.piggymetrics.auth.repository.UserRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OAuth2AuthorizationConfigDiffblueTest {
  @MockBean
  private MongodExecutable mongodExecutable;

  @Autowired
  private OAuth2AuthorizationConfig oAuth2AuthorizationConfig;

  @MockBean
  private UserRepository userRepository;
  /**
  * Method under test: {@link OAuth2AuthorizationConfig#configure(ClientDetailsServiceConfigurer)}
  */
  @Test
  public void testConfigure() throws Exception {
    // Arrange
    ClientDetailsServiceConfigurer clients = new ClientDetailsServiceConfigurer(new ClientDetailsServiceBuilder<>());

    // Act
    oAuth2AuthorizationConfig.configure(clients);

    // Assert
    assertTrue(clients.and() instanceof InMemoryClientDetailsServiceBuilder);
  }

  /**
   * Method under test: {@link OAuth2AuthorizationConfig#configure(ClientDetailsServiceConfigurer)}
   */
  @Test
  public void testConfigure2() throws Exception {
    // Arrange
    JdbcClientDetailsServiceBuilder builder = new JdbcClientDetailsServiceBuilder();
    builder.dataSource(mock(DataSource.class));
    ClientDetailsServiceConfigurer clients = new ClientDetailsServiceConfigurer(builder);

    // Act
    oAuth2AuthorizationConfig.configure(clients);

    // Assert
    assertTrue(clients.and() instanceof InMemoryClientDetailsServiceBuilder);
  }

  /**
   * Method under test: {@link OAuth2AuthorizationConfig#configure(AuthorizationServerEndpointsConfigurer)}
   */
  @Test
  public void testConfigure3() throws Exception {
    // Arrange
    AuthorizationServerEndpointsConfigurer endpoints = new AuthorizationServerEndpointsConfigurer();

    // Act
    oAuth2AuthorizationConfig.configure(endpoints);

    // Assert
    assertTrue(endpoints.isUserDetailsServiceOverride());
    assertTrue(endpoints.getTokenStore() instanceof InMemoryTokenStore);
  }

  /**
   * Method under test: {@link OAuth2AuthorizationConfig#configure(AuthorizationServerSecurityConfigurer)}
   */
  @Test
  public void testConfigure4() throws Exception {
    // Arrange
    AuthorizationServerSecurityConfigurer oauthServer = new AuthorizationServerSecurityConfigurer();

    // Act
    oAuth2AuthorizationConfig.configure(oauthServer);

    // Assert
    assertEquals("isAuthenticated()", oauthServer.getCheckTokenAccess());
    assertEquals("permitAll()", oauthServer.getTokenKeyAccess());
  }
}

