package com.piggymetrics.account.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.piggymetrics.account.repository.AccountRepository;
import com.piggymetrics.account.service.security.CustomUserInfoTokenServices;
import de.flapdoodle.embed.mongo.MongodExecutable;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.http.OAuth2ErrorHandler;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringValueResolver;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

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
  * Method under test: {@link ResourceServerConfig#clientCredentialsResourceDetails()}
  */
  @Test
  public void testClientCredentialsResourceDetails() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ClientCredentialsResourceDetails actualClientCredentialsResourceDetailsResult = (new ResourceServerConfig(
        new ResourceServerProperties())).clientCredentialsResourceDetails();

    // Assert
    assertEquals("access_token", actualClientCredentialsResourceDetailsResult.getTokenName());
    assertEquals("client_credentials", actualClientCredentialsResourceDetailsResult.getGrantType());
    assertEquals(AuthenticationScheme.header,
        actualClientCredentialsResourceDetailsResult.getClientAuthenticationScheme());
    assertEquals(AuthenticationScheme.header, actualClientCredentialsResourceDetailsResult.getAuthenticationScheme());
  }

  /**
   * Method under test: {@link ResourceServerConfig#clientCredentialsResourceDetails()}
   */
  @Test
  public void testClientCredentialsResourceDetails2() throws BeansException {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange
    DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
    defaultListableBeanFactory.addEmbeddedValueResolver(mock(StringValueResolver.class));

    ResourceServerProperties resourceServerProperties = new ResourceServerProperties();
    resourceServerProperties.setBeanFactory(defaultListableBeanFactory);

    // Act
    ClientCredentialsResourceDetails actualClientCredentialsResourceDetailsResult = (new ResourceServerConfig(
        resourceServerProperties)).clientCredentialsResourceDetails();

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
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    OAuth2RestTemplate actualClientCredentialsRestTemplateResult = (new ResourceServerConfig(
        new ResourceServerProperties())).clientCredentialsRestTemplate();

    // Assert
    assertTrue(actualClientCredentialsRestTemplateResult.getErrorHandler() instanceof OAuth2ErrorHandler);
    UriTemplateHandler uriTemplateHandler = actualClientCredentialsRestTemplateResult.getUriTemplateHandler();
    assertTrue(uriTemplateHandler instanceof DefaultUriBuilderFactory);
    OAuth2ProtectedResourceDetails resource = actualClientCredentialsRestTemplateResult.getResource();
    assertTrue(resource instanceof ClientCredentialsResourceDetails);
    assertTrue(actualClientCredentialsRestTemplateResult.getInterceptors().isEmpty());
    OAuth2ClientContext oAuth2ClientContext = actualClientCredentialsRestTemplateResult.getOAuth2ClientContext();
    assertTrue(oAuth2ClientContext instanceof DefaultOAuth2ClientContext);
    assertTrue(actualClientCredentialsRestTemplateResult.getRequestFactory() instanceof SimpleClientHttpRequestFactory);
    List<HttpMessageConverter<?>> messageConverters = actualClientCredentialsRestTemplateResult.getMessageConverters();
    assertEquals(7, messageConverters.size());
    assertEquals(AuthenticationScheme.header, resource.getClientAuthenticationScheme());
    assertEquals(AuthenticationScheme.header, resource.getAuthenticationScheme());
    assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
        ((DefaultUriBuilderFactory) uriTemplateHandler).getEncodingMode());
    assertTrue(((DefaultUriBuilderFactory) uriTemplateHandler).getDefaultUriVariables().isEmpty());
    assertTrue(oAuth2ClientContext.getAccessTokenRequest() instanceof DefaultAccessTokenRequest);
    assertEquals("client_credentials", resource.getGrantType());
    assertEquals("access_token", resource.getTokenName());
    HttpMessageConverter<?> getResult = messageConverters.get(5);
    assertEquals(3, getResult.getSupportedMediaTypes().size());
    assertEquals(2, messageConverters.get(1).getSupportedMediaTypes().size());
    assertEquals(2, messageConverters.get(4).getSupportedMediaTypes().size());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult).isProcessExternalEntities());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult).isSupportDtd());
    ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) messageConverters.get(6)).getObjectMapper();
    assertTrue(objectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(objectMapper.getDateFormat() instanceof StdDateFormat);
  }

  /**
   * Method under test: {@link ResourceServerConfig#clientCredentialsRestTemplate()}
   */
  @Test
  public void testClientCredentialsRestTemplate2() throws BeansException {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Diffblue AI was unable to find a test

    // Arrange
    DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
    defaultListableBeanFactory.addEmbeddedValueResolver(mock(StringValueResolver.class));

    ResourceServerProperties resourceServerProperties = new ResourceServerProperties();
    resourceServerProperties.setBeanFactory(defaultListableBeanFactory);

    // Act
    OAuth2RestTemplate actualClientCredentialsRestTemplateResult = (new ResourceServerConfig(resourceServerProperties))
        .clientCredentialsRestTemplate();

    // Assert
    assertTrue(actualClientCredentialsRestTemplateResult.getErrorHandler() instanceof OAuth2ErrorHandler);
    UriTemplateHandler uriTemplateHandler = actualClientCredentialsRestTemplateResult.getUriTemplateHandler();
    assertTrue(uriTemplateHandler instanceof DefaultUriBuilderFactory);
    OAuth2ProtectedResourceDetails resource = actualClientCredentialsRestTemplateResult.getResource();
    assertTrue(resource instanceof ClientCredentialsResourceDetails);
    assertTrue(actualClientCredentialsRestTemplateResult.getInterceptors().isEmpty());
    OAuth2ClientContext oAuth2ClientContext = actualClientCredentialsRestTemplateResult.getOAuth2ClientContext();
    assertTrue(oAuth2ClientContext instanceof DefaultOAuth2ClientContext);
    assertTrue(actualClientCredentialsRestTemplateResult.getRequestFactory() instanceof SimpleClientHttpRequestFactory);
    List<HttpMessageConverter<?>> messageConverters = actualClientCredentialsRestTemplateResult.getMessageConverters();
    assertEquals(7, messageConverters.size());
    assertEquals(AuthenticationScheme.header, resource.getClientAuthenticationScheme());
    assertEquals(AuthenticationScheme.header, resource.getAuthenticationScheme());
    assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
        ((DefaultUriBuilderFactory) uriTemplateHandler).getEncodingMode());
    assertTrue(((DefaultUriBuilderFactory) uriTemplateHandler).getDefaultUriVariables().isEmpty());
    assertTrue(oAuth2ClientContext.getAccessTokenRequest() instanceof DefaultAccessTokenRequest);
    assertEquals("client_credentials", resource.getGrantType());
    assertEquals("access_token", resource.getTokenName());
    HttpMessageConverter<?> getResult = messageConverters.get(5);
    assertEquals(3, getResult.getSupportedMediaTypes().size());
    assertEquals(2, messageConverters.get(1).getSupportedMediaTypes().size());
    assertEquals(2, messageConverters.get(4).getSupportedMediaTypes().size());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult).isProcessExternalEntities());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult).isSupportDtd());
    ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) messageConverters.get(6)).getObjectMapper();
    assertTrue(objectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(objectMapper.getDateFormat() instanceof StdDateFormat);
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

