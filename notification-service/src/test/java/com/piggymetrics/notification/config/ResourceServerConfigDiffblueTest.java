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
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
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
  * Method under test: {@link ResourceServerConfig#clientCredentialsResourceDetails()}
  */
  @Test
  public void testClientCredentialsResourceDetails() {
    // Arrange, Act and Assert
    assertFalse(resourceServerConfig.clientCredentialsResourceDetails().isScoped());
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
    // Arrange and Act
    OAuth2RestTemplate actualClientCredentialsRestTemplateResult = resourceServerConfig.clientCredentialsRestTemplate();

    // Assert
    List<HttpMessageConverter<?>> messageConverters = actualClientCredentialsRestTemplateResult.getMessageConverters();
    assertEquals(7, messageConverters.size());
    OAuth2ProtectedResourceDetails resource = actualClientCredentialsRestTemplateResult.getResource();
    assertEquals(AuthenticationScheme.header, resource.getAuthenticationScheme());
    assertFalse(resource.isScoped());
    assertEquals("access_token", resource.getTokenName());
    assertFalse(resource.isAuthenticationRequired());
    assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
        ((DefaultUriBuilderFactory) actualClientCredentialsRestTemplateResult.getUriTemplateHandler())
            .getEncodingMode());
    assertEquals(AuthenticationScheme.header, resource.getClientAuthenticationScheme());
    assertNull(resource.getId());
    HttpMessageConverter<?> getResult = messageConverters.get(5);
    assertEquals(3, getResult.getSupportedMediaTypes().size());
    assertNull(((Jaxb2RootElementHttpMessageConverter) getResult).getDefaultCharset());
  }
}

