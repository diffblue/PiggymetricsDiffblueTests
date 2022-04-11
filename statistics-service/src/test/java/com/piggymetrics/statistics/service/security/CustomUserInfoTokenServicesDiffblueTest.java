package com.piggymetrics.statistics.service.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.autoconfigure.security.oauth2.resource.FixedAuthoritiesExtractor;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

public class CustomUserInfoTokenServicesDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link CustomUserInfoTokenServices#CustomUserInfoTokenServices(String, String)}
  *   <li>{@link CustomUserInfoTokenServices#setAuthoritiesExtractor(org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor)}
  *   <li>{@link CustomUserInfoTokenServices#setRestTemplate(org.springframework.security.oauth2.client.OAuth2RestOperations)}
  *   <li>{@link CustomUserInfoTokenServices#setTokenType(String)}
  * </ul>
  */
  @Test
  public void testConstructor() {
    // Arrange and Act
    CustomUserInfoTokenServices actualCustomUserInfoTokenServices = new CustomUserInfoTokenServices(
        "https://config.us-east-2.amazonaws.com", "42");
    actualCustomUserInfoTokenServices.setAuthoritiesExtractor(new FixedAuthoritiesExtractor());
    BaseOAuth2ProtectedResourceDetails baseOAuth2ProtectedResourceDetails = new BaseOAuth2ProtectedResourceDetails();
    OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(baseOAuth2ProtectedResourceDetails);
    actualCustomUserInfoTokenServices.setRestTemplate(oAuth2RestTemplate);
    actualCustomUserInfoTokenServices.setTokenType("ABC123");

    // Assert
    assertTrue(oAuth2RestTemplate
        .getErrorHandler() instanceof org.springframework.security.oauth2.client.http.OAuth2ErrorHandler);
    UriTemplateHandler uriTemplateHandler = oAuth2RestTemplate.getUriTemplateHandler();
    assertTrue(uriTemplateHandler instanceof DefaultUriBuilderFactory);
    OAuth2ProtectedResourceDetails resource = oAuth2RestTemplate.getResource();
    assertSame(baseOAuth2ProtectedResourceDetails, resource);
    assertTrue(resource instanceof BaseOAuth2ProtectedResourceDetails);
    assertTrue(oAuth2RestTemplate.getInterceptors().isEmpty());
    OAuth2ClientContext oAuth2ClientContext = oAuth2RestTemplate.getOAuth2ClientContext();
    assertTrue(oAuth2ClientContext instanceof org.springframework.security.oauth2.client.DefaultOAuth2ClientContext);
    assertSame(baseOAuth2ProtectedResourceDetails, resource);
    assertTrue(oAuth2RestTemplate
        .getRequestFactory() instanceof org.springframework.http.client.SimpleClientHttpRequestFactory);
    List<HttpMessageConverter<?>> messageConverters = oAuth2RestTemplate.getMessageConverters();
    assertEquals(7, messageConverters.size());
    HttpMessageConverter<?> getResult = messageConverters.get(6);
    assertTrue(getResult instanceof MappingJackson2HttpMessageConverter);
    HttpMessageConverter<?> getResult1 = messageConverters.get(5);
    assertTrue(getResult1 instanceof Jaxb2RootElementHttpMessageConverter);
    assertEquals(AuthenticationScheme.header, resource.getClientAuthenticationScheme());
    assertFalse(resource.isScoped());
    assertEquals(AuthenticationScheme.header, resource.getAuthenticationScheme());
    assertFalse(resource.isAuthenticationRequired());
    assertFalse(resource.isClientOnly());
    assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
        ((DefaultUriBuilderFactory) uriTemplateHandler).getEncodingMode());
    assertNull(oAuth2ClientContext.getAccessToken());
    HttpMessageConverter<?> getResult2 = messageConverters.get(4);
    assertTrue(
        getResult2 instanceof org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter);
    HttpMessageConverter<?> getResult3 = messageConverters.get(2);
    assertTrue(getResult3 instanceof ResourceHttpMessageConverter);
    HttpMessageConverter<?> getResult4 = messageConverters.get(0);
    assertTrue(getResult4 instanceof ByteArrayHttpMessageConverter);
    assertTrue(((DefaultUriBuilderFactory) uriTemplateHandler).getDefaultUriVariables().isEmpty());
    assertNull(resource.getClientId());
    HttpMessageConverter<?> getResult5 = messageConverters.get(1);
    assertTrue(getResult5 instanceof org.springframework.http.converter.StringHttpMessageConverter);
    assertNull(resource.getClientSecret());
    AccessTokenRequest accessTokenRequest = oAuth2ClientContext.getAccessTokenRequest();
    assertTrue(
        accessTokenRequest instanceof org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest);
    assertTrue(accessTokenRequest.isEmpty());
    assertEquals("unsupported", resource.getGrantType());
    assertNull(resource.getId());
    assertNull(resource.getAccessTokenUri());
    assertNull(resource.getScope());
    assertEquals("access_token", resource.getTokenName());
    assertEquals(3, getResult1.getSupportedMediaTypes().size());
    assertNull(((Jaxb2RootElementHttpMessageConverter) getResult1).getDefaultCharset());
    assertEquals(2, getResult5.getSupportedMediaTypes().size());
    assertEquals(2, getResult2.getSupportedMediaTypes().size());
    assertNull(((ResourceHttpMessageConverter) getResult3).getDefaultCharset());
    assertNull(((ByteArrayHttpMessageConverter) getResult4).getDefaultCharset());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult1).isProcessExternalEntities());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult1).isSupportDtd());
    ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) getResult).getObjectMapper();
    assertTrue(objectMapper
        .getDeserializationContext() instanceof com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl);
    assertTrue(objectMapper.getDateFormat() instanceof com.fasterxml.jackson.databind.util.StdDateFormat);
  }

  /**
   * Method under test: {@link CustomUserInfoTokenServices#loadAuthentication(String)}
   */
  @Test
  public void testLoadAuthentication() throws AuthenticationException, InvalidTokenException {
    // Arrange, Act and Assert
    thrown.expect(InvalidTokenException.class);
    (new CustomUserInfoTokenServices("https://config.us-east-2.amazonaws.com", "42")).loadAuthentication("ABC123");
  }

  /**
   * Method under test: {@link CustomUserInfoTokenServices#loadAuthentication(String)}
   */
  @Test
  public void testLoadAuthentication2() throws AuthenticationException, InvalidTokenException {
    // Arrange
    CustomUserInfoTokenServices customUserInfoTokenServices = new CustomUserInfoTokenServices(
        "https://config.us-east-2.amazonaws.com", "42");
    customUserInfoTokenServices.setRestTemplate(new OAuth2RestTemplate(new BaseOAuth2ProtectedResourceDetails()));

    // Act and Assert
    thrown.expect(InvalidTokenException.class);
    customUserInfoTokenServices.loadAuthentication("ABC123");
  }

  /**
   * Method under test: {@link CustomUserInfoTokenServices#readAccessToken(String)}
   */
  @Test
  public void testReadAccessToken() {
    // Arrange, Act and Assert
    thrown.expect(UnsupportedOperationException.class);
    (new CustomUserInfoTokenServices("https://config.us-east-2.amazonaws.com", "42")).readAccessToken("ABC123");
  }
}

