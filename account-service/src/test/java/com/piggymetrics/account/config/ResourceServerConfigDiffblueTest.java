package com.piggymetrics.account.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.piggymetrics.account.service.security.CustomUserInfoTokenServices;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.http.OAuth2ErrorHandler;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.DefaultUriBuilderFactory;

@ContextConfiguration(
    classes = {
      ResourceServerConfig.class,
      ResourceServerProperties.class,
      AuthenticationConfiguration.class
    })
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceServerConfigDiffblueTest {
  @Autowired private ResourceServerConfig resourceServerConfig;

  @Autowired private ResourceServerProperties resourceServerProperties;

  /**
   * Test {@link ResourceServerConfig#clientCredentialsResourceDetails()}.
   *
   * <p>Method under test: {@link ResourceServerConfig#clientCredentialsResourceDetails()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClientCredentialsResourceDetails ResourceServerConfig.clientCredentialsResourceDetails()"
  })
  public void testClientCredentialsResourceDetails() {
    // Arrange and Act
    ClientCredentialsResourceDetails actualClientCredentialsResourceDetailsResult =
        new ResourceServerConfig(new ResourceServerProperties()).clientCredentialsResourceDetails();

    // Assert
    assertEquals("access_token", actualClientCredentialsResourceDetailsResult.getTokenName());
    assertEquals("client_credentials", actualClientCredentialsResourceDetailsResult.getGrantType());
    assertNull(actualClientCredentialsResourceDetailsResult.getAccessTokenUri());
    assertNull(actualClientCredentialsResourceDetailsResult.getClientId());
    assertNull(actualClientCredentialsResourceDetailsResult.getClientSecret());
    assertNull(actualClientCredentialsResourceDetailsResult.getId());
    assertNull(actualClientCredentialsResourceDetailsResult.getScope());
    assertEquals(
        AuthenticationScheme.header,
        actualClientCredentialsResourceDetailsResult.getAuthenticationScheme());
    assertEquals(
        AuthenticationScheme.header,
        actualClientCredentialsResourceDetailsResult.getClientAuthenticationScheme());
    assertFalse(actualClientCredentialsResourceDetailsResult.isAuthenticationRequired());
    assertFalse(actualClientCredentialsResourceDetailsResult.isScoped());
    assertTrue(actualClientCredentialsResourceDetailsResult.isClientOnly());
  }

  /**
   * Test {@link ResourceServerConfig#clientCredentialsResourceDetails()}.
   *
   * <ul>
   *   <li>Given {@link ResourceServerConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceServerConfig#clientCredentialsResourceDetails()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClientCredentialsResourceDetails ResourceServerConfig.clientCredentialsResourceDetails()"
  })
  public void testClientCredentialsResourceDetails_givenResourceServerConfig() {
    // Arrange and Act
    ClientCredentialsResourceDetails actualClientCredentialsResourceDetailsResult =
        resourceServerConfig.clientCredentialsResourceDetails();

    // Assert
    assertEquals("access_token", actualClientCredentialsResourceDetailsResult.getTokenName());
    assertEquals("client_credentials", actualClientCredentialsResourceDetailsResult.getGrantType());
    assertNull(actualClientCredentialsResourceDetailsResult.getAccessTokenUri());
    assertNull(actualClientCredentialsResourceDetailsResult.getClientId());
    assertNull(actualClientCredentialsResourceDetailsResult.getClientSecret());
    assertNull(actualClientCredentialsResourceDetailsResult.getId());
    assertNull(actualClientCredentialsResourceDetailsResult.getScope());
    assertEquals(
        AuthenticationScheme.header,
        actualClientCredentialsResourceDetailsResult.getAuthenticationScheme());
    assertEquals(
        AuthenticationScheme.header,
        actualClientCredentialsResourceDetailsResult.getClientAuthenticationScheme());
    assertFalse(actualClientCredentialsResourceDetailsResult.isAuthenticationRequired());
    assertFalse(actualClientCredentialsResourceDetailsResult.isScoped());
    assertTrue(actualClientCredentialsResourceDetailsResult.isClientOnly());
  }

  /**
   * Test {@link ResourceServerConfig#oauth2FeignRequestInterceptor()}.
   *
   * <p>Method under test: {@link ResourceServerConfig#oauth2FeignRequestInterceptor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "feign.RequestInterceptor ResourceServerConfig.oauth2FeignRequestInterceptor()"
  })
  public void testOauth2FeignRequestInterceptor() {
    // Arrange, Act and Assert
    assertTrue(
        new ResourceServerConfig(new ResourceServerProperties()).oauth2FeignRequestInterceptor()
            instanceof OAuth2FeignRequestInterceptor);
  }

  /**
   * Test {@link ResourceServerConfig#oauth2FeignRequestInterceptor()}.
   *
   * <ul>
   *   <li>Then return {@link OAuth2FeignRequestInterceptor}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceServerConfig#oauth2FeignRequestInterceptor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "feign.RequestInterceptor ResourceServerConfig.oauth2FeignRequestInterceptor()"
  })
  public void testOauth2FeignRequestInterceptor_thenReturnOAuth2FeignRequestInterceptor() {
    // Arrange, Act and Assert
    assertTrue(
        resourceServerConfig.oauth2FeignRequestInterceptor()
            instanceof OAuth2FeignRequestInterceptor);
  }

  /**
   * Test {@link ResourceServerConfig#clientCredentialsRestTemplate()}.
   *
   * <p>Method under test: {@link ResourceServerConfig#clientCredentialsRestTemplate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2RestTemplate ResourceServerConfig.clientCredentialsRestTemplate()"})
  public void testClientCredentialsRestTemplate() {
    // Arrange and Act
    OAuth2RestTemplate actualClientCredentialsRestTemplateResult =
        new ResourceServerConfig(new ResourceServerProperties()).clientCredentialsRestTemplate();

    // Assert
    assertTrue(
        actualClientCredentialsRestTemplateResult.getRequestFactory()
            instanceof SimpleClientHttpRequestFactory);
    assertTrue(
        actualClientCredentialsRestTemplateResult.getOAuth2ClientContext()
            instanceof DefaultOAuth2ClientContext);
    assertTrue(
        actualClientCredentialsRestTemplateResult.getErrorHandler() instanceof OAuth2ErrorHandler);
    assertTrue(
        actualClientCredentialsRestTemplateResult.getResource()
            instanceof ClientCredentialsResourceDetails);
    assertTrue(
        actualClientCredentialsRestTemplateResult.getUriTemplateHandler()
            instanceof DefaultUriBuilderFactory);
    assertEquals(7, actualClientCredentialsRestTemplateResult.getMessageConverters().size());
    assertTrue(actualClientCredentialsRestTemplateResult.getInterceptors().isEmpty());
  }

  /**
   * Test {@link ResourceServerConfig#clientCredentialsRestTemplate()}.
   *
   * <ul>
   *   <li>Given {@link ResourceServerConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceServerConfig#clientCredentialsRestTemplate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2RestTemplate ResourceServerConfig.clientCredentialsRestTemplate()"})
  public void testClientCredentialsRestTemplate_givenResourceServerConfig() {
    // Arrange and Act
    OAuth2RestTemplate actualClientCredentialsRestTemplateResult =
        resourceServerConfig.clientCredentialsRestTemplate();

    // Assert
    assertTrue(
        actualClientCredentialsRestTemplateResult.getRequestFactory()
            instanceof SimpleClientHttpRequestFactory);
    assertTrue(
        actualClientCredentialsRestTemplateResult.getOAuth2ClientContext()
            instanceof DefaultOAuth2ClientContext);
    assertTrue(
        actualClientCredentialsRestTemplateResult.getErrorHandler() instanceof OAuth2ErrorHandler);
    assertTrue(
        actualClientCredentialsRestTemplateResult.getResource()
            instanceof ClientCredentialsResourceDetails);
    assertTrue(
        actualClientCredentialsRestTemplateResult.getUriTemplateHandler()
            instanceof DefaultUriBuilderFactory);
    assertEquals(7, actualClientCredentialsRestTemplateResult.getMessageConverters().size());
    assertTrue(actualClientCredentialsRestTemplateResult.getInterceptors().isEmpty());
  }

  /**
   * Test {@link ResourceServerConfig#tokenServices()}.
   *
   * <ul>
   *   <li>Given {@link ResourceServerConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceServerConfig#tokenServices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.provider.token.ResourceServerTokenServices ResourceServerConfig.tokenServices()"
  })
  public void testTokenServices_givenResourceServerConfig() {
    // Arrange, Act and Assert
    assertTrue(resourceServerConfig.tokenServices() instanceof CustomUserInfoTokenServices);
  }

  /**
   * Test {@link ResourceServerConfig#tokenServices()}.
   *
   * <ul>
   *   <li>Given {@link ResourceServerConfig#ResourceServerConfig(ResourceServerProperties)} with
   *       sso is {@link ResourceServerProperties#ResourceServerProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceServerConfig#tokenServices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.provider.token.ResourceServerTokenServices ResourceServerConfig.tokenServices()"
  })
  public void testTokenServices_givenResourceServerConfigWithSsoIsResourceServerProperties() {
    // Arrange, Act and Assert
    assertTrue(
        new ResourceServerConfig(new ResourceServerProperties()).tokenServices()
            instanceof CustomUserInfoTokenServices);
  }
}
