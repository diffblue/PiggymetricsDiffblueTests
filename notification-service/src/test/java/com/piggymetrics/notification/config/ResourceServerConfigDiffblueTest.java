package com.piggymetrics.notification.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.piggymetrics.notification.repository.RecipientRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceServerConfigDiffblueTest {
  @MockBean
  private MongodExecutable mongodExecutable;

  @MockBean
  private RecipientRepository recipientRepository;

  @Autowired
  private ResourceServerConfig resourceServerConfig;
  /**
  * Method under test: {@link ResourceServerConfig#clientCredentialsResourceDetails()}
  */
  @Test
  public void testClientCredentialsResourceDetails() {
    // Arrange, Act and Assert
    assertEquals("access_token", resourceServerConfig.clientCredentialsResourceDetails().getTokenName());
  }

  /**
   * Method under test: {@link ResourceServerConfig#oauth2FeignRequestInterceptor()}
   */
  @Test
  public void testOauth2FeignRequestInterceptor() {
    // Arrange, Act and Assert
    assertTrue(resourceServerConfig.oauth2FeignRequestInterceptor() instanceof OAuth2FeignRequestInterceptor);
  }

  /**
   * Method under test: {@link ResourceServerConfig#clientCredentialsRestTemplate()}
   */
  @Test
  public void testClientCredentialsRestTemplate() {
    // Arrange, Act and Assert
    OAuth2ProtectedResourceDetails resource = resourceServerConfig.clientCredentialsRestTemplate().getResource();
    assertTrue(resource.isClientOnly());
    assertEquals(AuthenticationScheme.header, resource.getClientAuthenticationScheme());
  }
}

