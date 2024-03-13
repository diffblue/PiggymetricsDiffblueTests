package com.piggymetrics.account.config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.piggymetrics.account.repository.AccountRepository;
import com.piggymetrics.account.service.security.CustomUserInfoTokenServices;
import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceServerConfigDiffblueTest {
  @MockBean
  private AccountRepository accountRepository;

  @MockBean
  private MongodExecutable mongodExecutable;

  @Autowired
  private ResourceServerConfig resourceServerConfig;

  @Autowired
  private ResourceServerProperties resourceServerProperties;
  /**
   * Method under test:
   * {@link ResourceServerConfig#clientCredentialsResourceDetails()}
   */
  @Test
  public void testClientCredentialsResourceDetails() {
    // Arrange, Act and Assert
    assertFalse(resourceServerConfig.clientCredentialsResourceDetails().isAuthenticationRequired());
  }

  /**
   * Method under test:
   * {@link ResourceServerConfig#oauth2FeignRequestInterceptor()}
   */
  @Test
  public void testOauth2FeignRequestInterceptor() {
    // Arrange, Act and Assert
    assertTrue(resourceServerConfig.oauth2FeignRequestInterceptor() instanceof OAuth2FeignRequestInterceptor);
  }

  /**
   * Method under test:
   * {@link ResourceServerConfig#clientCredentialsRestTemplate()}
   */
  @Test
  public void testClientCredentialsRestTemplate() {
    // Arrange, Act and Assert
    ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) resourceServerConfig
        .clientCredentialsRestTemplate()
        .getMessageConverters()
        .get(6)).getObjectMapper();
    TypeFactory expectedTypeFactory = objectMapper.getTypeFactory();
    assertSame(expectedTypeFactory, objectMapper.getSerializerProviderInstance().getTypeFactory());
  }

  /**
   * Method under test: {@link ResourceServerConfig#tokenServices()}
   */
  @Test
  public void testTokenServices() {
    // Arrange, Act and Assert
    assertTrue(resourceServerConfig.tokenServices() instanceof CustomUserInfoTokenServices);
  }
}
