package com.piggymetrics.account.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggymetrics.account.repository.AccountRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ResourceServerConfigDiffblueTest {
  @MockBean
  private AccountRepository accountRepository;

  @MockBean
  private MongodExecutable mongodExecutable;

  @Autowired
  private ResourceServerConfig resourceServerConfig;

  @Autowired
  private ResourceServerProperties resourceServerProperties;

  @Test
  public void testClientCredentialsResourceDetails() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R004 No meaningful assertions found.
    //   Diffblue Cover was unable to create an assertion.
    //   Make sure that fields modified by clientCredentialsResourceDetails()
    //   have package-private, protected, or public getters.
    //   See https://diff.blue/R004 to resolve this issue.

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

  @Test
  public void testOauth2FeignRequestInterceptor() {
    // Arrange, Act and Assert
    assertTrue(this.resourceServerConfig
        .oauth2FeignRequestInterceptor() instanceof org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor);
  }

  @Test
  public void testClientCredentialsRestTemplate() {
    //   Diffblue Cover was unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: R004 No meaningful assertions found.
    //   Diffblue Cover was unable to create an assertion.
    //   Make sure that fields modified by clientCredentialsRestTemplate()
    //   have package-private, protected, or public getters.
    //   See https://diff.blue/R004 to resolve this issue.

    // Arrange and Act
    OAuth2RestTemplate actualClientCredentialsRestTemplateResult = (new ResourceServerConfig(
        new ResourceServerProperties())).clientCredentialsRestTemplate();

    // Assert
    assertTrue(actualClientCredentialsRestTemplateResult
        .getErrorHandler() instanceof org.springframework.security.oauth2.client.http.OAuth2ErrorHandler);
    UriTemplateHandler uriTemplateHandler = actualClientCredentialsRestTemplateResult.getUriTemplateHandler();
    assertTrue(uriTemplateHandler instanceof DefaultUriBuilderFactory);
    OAuth2ProtectedResourceDetails resource = actualClientCredentialsRestTemplateResult.getResource();
    assertTrue(
        resource instanceof org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails);
    assertTrue(actualClientCredentialsRestTemplateResult.getInterceptors().isEmpty());
    OAuth2ClientContext oAuth2ClientContext = actualClientCredentialsRestTemplateResult.getOAuth2ClientContext();
    assertTrue(oAuth2ClientContext instanceof org.springframework.security.oauth2.client.DefaultOAuth2ClientContext);
    assertTrue(actualClientCredentialsRestTemplateResult
        .getRequestFactory() instanceof org.springframework.http.client.SimpleClientHttpRequestFactory);
    List<HttpMessageConverter<?>> messageConverters = actualClientCredentialsRestTemplateResult.getMessageConverters();
    assertEquals(7, messageConverters.size());
    assertEquals(AuthenticationScheme.header, resource.getClientAuthenticationScheme());
    assertEquals(AuthenticationScheme.header, resource.getAuthenticationScheme());
    assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
        ((DefaultUriBuilderFactory) uriTemplateHandler).getEncodingMode());
    assertTrue(((DefaultUriBuilderFactory) uriTemplateHandler).getDefaultUriVariables().isEmpty());
    assertTrue(oAuth2ClientContext
        .getAccessTokenRequest() instanceof org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest);
    assertEquals("client_credentials", resource.getGrantType());
    assertEquals("access_token", resource.getTokenName());
    HttpMessageConverter<?> getResult = messageConverters.get(5);
    assertEquals(3, getResult.getSupportedMediaTypes().size());
    assertEquals(2, messageConverters.get(1).getSupportedMediaTypes().size());
    assertEquals(2, messageConverters.get(4).getSupportedMediaTypes().size());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult).isProcessExternalEntities());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult).isSupportDtd());
    ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) messageConverters.get(6)).getObjectMapper();
    assertTrue(objectMapper
        .getDeserializationContext() instanceof com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl);
    assertTrue(objectMapper.getDateFormat() instanceof com.fasterxml.jackson.databind.util.StdDateFormat);
  }

  @Test
  public void testTokenServices() {
    // Arrange, Act and Assert
    assertTrue(this.resourceServerConfig
        .tokenServices() instanceof com.piggymetrics.account.service.security.CustomUserInfoTokenServices);
  }
}

