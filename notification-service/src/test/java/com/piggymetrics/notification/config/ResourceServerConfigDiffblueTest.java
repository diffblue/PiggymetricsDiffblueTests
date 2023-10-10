package com.piggymetrics.notification.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.piggymetrics.notification.repository.RecipientRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
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
  * Method under test: {@link ResourceServerConfig#clientCredentialsResourceDetails()}
  */
  @Test
  public void testClientCredentialsResourceDetails() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ClientCredentialsResourceDetails actualClientCredentialsResourceDetailsResult = (new ResourceServerConfig())
        .clientCredentialsResourceDetails();

    // Assert
    assertEquals("access_token", actualClientCredentialsResourceDetailsResult.getTokenName());
    assertEquals("client_credentials", actualClientCredentialsResourceDetailsResult.getGrantType());
    assertEquals(AuthenticationScheme.header,
        actualClientCredentialsResourceDetailsResult.getClientAuthenticationScheme());
    assertEquals(AuthenticationScheme.header, actualClientCredentialsResourceDetailsResult.getAuthenticationScheme());
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
    OAuth2ProtectedResourceDetails resource = actualClientCredentialsRestTemplateResult.getResource();
    assertNull(resource.getAccessTokenUri());
    assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
        ((DefaultUriBuilderFactory) actualClientCredentialsRestTemplateResult.getUriTemplateHandler())
            .getEncodingMode());
    assertNull(resource.getClientId());
    assertNull(resource.getClientSecret());
    assertEquals(actualClientCredentialsRestTemplateResult.getOAuth2ClientContext().getAccessTokenRequest(),
        ((DefaultUriBuilderFactory) actualClientCredentialsRestTemplateResult.getUriTemplateHandler())
            .getDefaultUriVariables());
    assertNull(resource.getId());
    assertFalse(
        ((Jaxb2RootElementHttpMessageConverter) actualClientCredentialsRestTemplateResult.getMessageConverters().get(5))
            .isProcessExternalEntities());
  }
}

