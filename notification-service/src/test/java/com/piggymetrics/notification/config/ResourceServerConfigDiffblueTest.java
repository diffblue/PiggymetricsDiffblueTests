package com.piggymetrics.notification.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.piggymetrics.notification.repository.RecipientRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.DefaultUriBuilderFactory;

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
   * Method under test:
   * {@link ResourceServerConfig#clientCredentialsResourceDetails()}
   */
  @Test
  public void testClientCredentialsResourceDetails() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ClientCredentialsResourceDetails actualClientCredentialsResourceDetailsResult = (new ResourceServerConfig())
        .clientCredentialsResourceDetails();

    // Assert
    assertEquals("access_token", actualClientCredentialsResourceDetailsResult.getTokenName());
    assertEquals("client_credentials", actualClientCredentialsResourceDetailsResult.getGrantType());
    assertEquals(AuthenticationScheme.header, actualClientCredentialsResourceDetailsResult.getAuthenticationScheme());
    assertEquals(AuthenticationScheme.header,
        actualClientCredentialsResourceDetailsResult.getClientAuthenticationScheme());
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
    // Arrange and Act
    OAuth2RestTemplate actualClientCredentialsRestTemplateResult = resourceServerConfig.clientCredentialsRestTemplate();

    // Assert
    List<HttpMessageConverter<?>> messageConverters = actualClientCredentialsRestTemplateResult.getMessageConverters();
    assertEquals(7, messageConverters.size());
    HttpMessageConverter<?> getResult = messageConverters.get(6);
    assertEquals("UTF-8", ((MappingJackson2HttpMessageConverter) getResult).getDefaultCharset().name());
    assertNull(((MappingJackson2HttpMessageConverter) getResult).getObjectMapper().getInjectableValues());
    OAuth2ProtectedResourceDetails resource = actualClientCredentialsRestTemplateResult.getResource();
    assertNull(resource.getAccessTokenUri());
    assertNull(resource.getClientId());
    assertNull(actualClientCredentialsRestTemplateResult.getOAuth2ClientContext().getAccessToken());
    assertEquals(2, getResult.getSupportedMediaTypes().size());
    assertFalse(resource.isScoped());
    assertTrue(((DefaultUriBuilderFactory) actualClientCredentialsRestTemplateResult.getUriTemplateHandler())
        .getDefaultUriVariables()
        .isEmpty());
  }
}
