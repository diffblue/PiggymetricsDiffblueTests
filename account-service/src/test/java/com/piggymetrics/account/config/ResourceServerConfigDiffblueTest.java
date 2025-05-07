package com.piggymetrics.account.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.piggymetrics.account.service.security.CustomUserInfoTokenServices;
import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.http.OAuth2ErrorHandler;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.DefaultUriBuilderFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ResourceServerConfigDiffblueTest {
  @MockBean
  private MongodExecutable mongodExecutable;

  @Autowired
  private ResourceServerConfig resourceServerConfig;

  @Autowired
  private ResourceServerProperties resourceServerProperties;

  /**
   * Test {@link ResourceServerConfig#clientCredentialsResourceDetails()}.
   * <p>
   * Method under test: {@link ResourceServerConfig#clientCredentialsResourceDetails()}
   */
  @Test
  public void testClientCredentialsResourceDetails() {
    // Arrange and Act
    ClientCredentialsResourceDetails actualClientCredentialsResourceDetailsResult = (new ResourceServerConfig(
        new ResourceServerProperties())).clientCredentialsResourceDetails();

    // Assert
    assertEquals("access_token", actualClientCredentialsResourceDetailsResult.getTokenName());
    assertEquals("client_credentials", actualClientCredentialsResourceDetailsResult.getGrantType());
    assertNull(actualClientCredentialsResourceDetailsResult.getAccessTokenUri());
    assertNull(actualClientCredentialsResourceDetailsResult.getClientId());
    assertNull(actualClientCredentialsResourceDetailsResult.getClientSecret());
    assertNull(actualClientCredentialsResourceDetailsResult.getId());
    assertNull(actualClientCredentialsResourceDetailsResult.getScope());
    assertEquals(AuthenticationScheme.header, actualClientCredentialsResourceDetailsResult.getAuthenticationScheme());
    assertEquals(AuthenticationScheme.header,
        actualClientCredentialsResourceDetailsResult.getClientAuthenticationScheme());
    assertFalse(actualClientCredentialsResourceDetailsResult.isAuthenticationRequired());
    assertFalse(actualClientCredentialsResourceDetailsResult.isScoped());
    assertTrue(actualClientCredentialsResourceDetailsResult.isClientOnly());
  }

  /**
   * Test {@link ResourceServerConfig#clientCredentialsResourceDetails()}.
   * <ul>
   *   <li>Given {@link ResourceServerConfig}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceServerConfig#clientCredentialsResourceDetails()}
   */
  @Test
  public void testClientCredentialsResourceDetails_givenResourceServerConfig() {
    // Arrange and Act
    ClientCredentialsResourceDetails actualClientCredentialsResourceDetailsResult = resourceServerConfig
        .clientCredentialsResourceDetails();

    // Assert
    assertEquals("access_token", actualClientCredentialsResourceDetailsResult.getTokenName());
    assertEquals("client_credentials", actualClientCredentialsResourceDetailsResult.getGrantType());
    assertNull(actualClientCredentialsResourceDetailsResult.getAccessTokenUri());
    assertNull(actualClientCredentialsResourceDetailsResult.getClientId());
    assertNull(actualClientCredentialsResourceDetailsResult.getClientSecret());
    assertNull(actualClientCredentialsResourceDetailsResult.getId());
    assertNull(actualClientCredentialsResourceDetailsResult.getScope());
    assertEquals(AuthenticationScheme.header, actualClientCredentialsResourceDetailsResult.getAuthenticationScheme());
    assertEquals(AuthenticationScheme.header,
        actualClientCredentialsResourceDetailsResult.getClientAuthenticationScheme());
    assertFalse(actualClientCredentialsResourceDetailsResult.isAuthenticationRequired());
    assertFalse(actualClientCredentialsResourceDetailsResult.isScoped());
    assertTrue(actualClientCredentialsResourceDetailsResult.isClientOnly());
  }

  /**
   * Test {@link ResourceServerConfig#oauth2FeignRequestInterceptor()}.
   * <p>
   * Method under test: {@link ResourceServerConfig#oauth2FeignRequestInterceptor()}
   */
  @Test
  public void testOauth2FeignRequestInterceptor() {
    // Arrange, Act and Assert
    assertTrue((new ResourceServerConfig(new ResourceServerProperties()))
        .oauth2FeignRequestInterceptor() instanceof OAuth2FeignRequestInterceptor);
  }

  /**
   * Test {@link ResourceServerConfig#oauth2FeignRequestInterceptor()}.
   * <ul>
   *   <li>Then return {@link OAuth2FeignRequestInterceptor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceServerConfig#oauth2FeignRequestInterceptor()}
   */
  @Test
  public void testOauth2FeignRequestInterceptor_thenReturnOAuth2FeignRequestInterceptor() {
    // Arrange, Act and Assert
    assertTrue(resourceServerConfig.oauth2FeignRequestInterceptor() instanceof OAuth2FeignRequestInterceptor);
  }

  /**
   * Test {@link ResourceServerConfig#clientCredentialsRestTemplate()}.
   * <p>
   * Method under test: {@link ResourceServerConfig#clientCredentialsRestTemplate()}
   */
  @Test
  public void testClientCredentialsRestTemplate() {
    // Arrange and Act
    OAuth2RestTemplate actualClientCredentialsRestTemplateResult = resourceServerConfig.clientCredentialsRestTemplate();

    // Assert
    assertTrue(
        actualClientCredentialsRestTemplateResult.getRequestFactory() instanceof InterceptingClientHttpRequestFactory);
    assertTrue(
        actualClientCredentialsRestTemplateResult.getOAuth2ClientContext() instanceof DefaultOAuth2ClientContext);
    assertTrue(actualClientCredentialsRestTemplateResult.getErrorHandler() instanceof OAuth2ErrorHandler);
    assertTrue(actualClientCredentialsRestTemplateResult.getResource() instanceof ClientCredentialsResourceDetails);
    assertTrue(actualClientCredentialsRestTemplateResult.getUriTemplateHandler() instanceof DefaultUriBuilderFactory);
    assertEquals(1, actualClientCredentialsRestTemplateResult.getInterceptors().size());
    assertEquals(7, actualClientCredentialsRestTemplateResult.getMessageConverters().size());
  }

  /**
   * Test {@link ResourceServerConfig#clientCredentialsRestTemplate()}.
   * <p>
   * Method under test: {@link ResourceServerConfig#clientCredentialsRestTemplate()}
   */
  @Test
  public void testClientCredentialsRestTemplate2() {
    // Arrange and Act
    OAuth2RestTemplate actualClientCredentialsRestTemplateResult = (new ResourceServerConfig(
        new ResourceServerProperties())).clientCredentialsRestTemplate();

    // Assert
    assertTrue(actualClientCredentialsRestTemplateResult.getRequestFactory() instanceof SimpleClientHttpRequestFactory);
    assertTrue(
        actualClientCredentialsRestTemplateResult.getOAuth2ClientContext() instanceof DefaultOAuth2ClientContext);
    assertTrue(actualClientCredentialsRestTemplateResult.getErrorHandler() instanceof OAuth2ErrorHandler);
    assertTrue(actualClientCredentialsRestTemplateResult.getResource() instanceof ClientCredentialsResourceDetails);
    assertTrue(actualClientCredentialsRestTemplateResult.getUriTemplateHandler() instanceof DefaultUriBuilderFactory);
    assertEquals(7, actualClientCredentialsRestTemplateResult.getMessageConverters().size());
    assertTrue(actualClientCredentialsRestTemplateResult.getInterceptors().isEmpty());
  }

  /**
   * Test {@link ResourceServerConfig#tokenServices()}.
   * <ul>
   *   <li>Given {@link ResourceServerConfig}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceServerConfig#tokenServices()}
   */
  @Test
  public void testTokenServices_givenResourceServerConfig() {
    // Arrange, Act and Assert
    assertTrue(resourceServerConfig.tokenServices() instanceof CustomUserInfoTokenServices);
  }

  /**
   * Test {@link ResourceServerConfig#tokenServices()}.
   * <ul>
   *   <li>Given {@link ResourceServerConfig#ResourceServerConfig(ResourceServerProperties)} with sso is {@link ResourceServerProperties#ResourceServerProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceServerConfig#tokenServices()}
   */
  @Test
  public void testTokenServices_givenResourceServerConfigWithSsoIsResourceServerProperties() {
    // Arrange, Act and Assert
    assertTrue((new ResourceServerConfig(new ResourceServerProperties()))
        .tokenServices() instanceof CustomUserInfoTokenServices);
  }
}
