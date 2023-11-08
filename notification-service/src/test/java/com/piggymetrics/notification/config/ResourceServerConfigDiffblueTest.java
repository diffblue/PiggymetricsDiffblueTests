package com.piggymetrics.notification.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.piggymetrics.notification.repository.RecipientRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

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
    // Arrange and Act
    ClientCredentialsResourceDetails actualClientCredentialsResourceDetailsResult = resourceServerConfig
        .clientCredentialsResourceDetails();

    // Assert
    assertNull(actualClientCredentialsResourceDetailsResult.getAccessTokenUri());
    assertEquals(AuthenticationScheme.header,
        actualClientCredentialsResourceDetailsResult.getClientAuthenticationScheme());
    assertFalse(actualClientCredentialsResourceDetailsResult.isAuthenticationRequired());
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
    OAuth2RestTemplate actualClientCredentialsRestTemplateResult = (new ResourceServerConfig())
        .clientCredentialsRestTemplate();

    // Assert
    List<HttpMessageConverter<?>> messageConverters = actualClientCredentialsRestTemplateResult.getMessageConverters();
    HttpMessageConverter<?> getResult = messageConverters.get(6);
    ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) getResult).getObjectMapper();
    SerializationConfig serializationConfig = objectMapper.getSerializationConfig();
    assertTrue(serializationConfig.getDefaultPrettyPrinter() instanceof DefaultPrettyPrinter);
    ContextAttributes attributes = serializationConfig.getAttributes();
    assertTrue(attributes instanceof ContextAttributes.Impl);
    DeserializationContext deserializationContext = objectMapper.getDeserializationContext();
    DeserializerFactory factory = deserializationContext.getFactory();
    assertTrue(factory instanceof BeanDeserializerFactory);
    assertTrue(deserializationContext instanceof DefaultDeserializationContext.Impl);
    ClassIntrospector classIntrospector = serializationConfig.getClassIntrospector();
    assertTrue(classIntrospector instanceof BasicClassIntrospector);
    SubtypeResolver subtypeResolver = objectMapper.getSubtypeResolver();
    assertTrue(subtypeResolver instanceof StdSubtypeResolver);
    SerializerFactory serializerFactory = objectMapper.getSerializerFactory();
    assertTrue(serializerFactory instanceof BeanSerializerFactory);
    SerializerProvider serializerProvider = objectMapper.getSerializerProvider();
    assertTrue(serializerProvider instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance = objectMapper.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance instanceof DefaultSerializerProvider.Impl);
    assertTrue(actualClientCredentialsRestTemplateResult.getRequestFactory() instanceof SimpleClientHttpRequestFactory);
    OAuth2ClientContext oAuth2ClientContext = actualClientCredentialsRestTemplateResult.getOAuth2ClientContext();
    assertTrue(oAuth2ClientContext instanceof DefaultOAuth2ClientContext);
    assertTrue(actualClientCredentialsRestTemplateResult.getErrorHandler() instanceof OAuth2ErrorHandler);
    assertTrue(oAuth2ClientContext.getAccessTokenRequest() instanceof DefaultAccessTokenRequest);
    OAuth2ProtectedResourceDetails resource = actualClientCredentialsRestTemplateResult.getResource();
    assertTrue(resource instanceof ClientCredentialsResourceDetails);
    UriTemplateHandler uriTemplateHandler = actualClientCredentialsRestTemplateResult.getUriTemplateHandler();
    assertTrue(uriTemplateHandler instanceof DefaultUriBuilderFactory);
    JsonFactory factory2 = objectMapper.getFactory();
    assertEquals(" ", factory2.getRootValueSeparator());
    assertEquals("access_token", resource.getTokenName());
    assertEquals("client_credentials", resource.getGrantType());
    assertNull(deserializationContext.getParser());
    assertNull(deserializationContext.getConfig());
    DeserializationConfig deserializationConfig = objectMapper.getDeserializationConfig();
    assertNull(deserializationConfig.getFullRootName());
    assertNull(serializationConfig.getFullRootName());
    assertNull(objectMapper.getPropertyNamingStrategy());
    assertNull(deserializationConfig.getPropertyNamingStrategy());
    assertNull(serializationConfig.getPropertyNamingStrategy());
    assertNull(serializerProvider.getConfig());
    assertNull(deserializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig.getFilterProvider());
    assertNull(deserializationConfig.getProblemHandlers());
    assertNull(deserializationConfig.getDefaultMergeable());
    assertNull(serializationConfig.getDefaultMergeable());
    assertNull(deserializationContext.getActiveView());
    assertNull(serializerProvider.getSerializationView());
    assertNull(deserializationConfig.getActiveView());
    assertNull(serializationConfig.getActiveView());
    TypeFactory typeFactory = objectMapper.getTypeFactory();
    assertNull(typeFactory.getClassLoader());
    assertEquals(0, deserializationContext.getDeserializationFeatures());
    assertEquals(1, messageConverters.get(2).getSupportedMediaTypes().size());
    assertEquals(2, messageConverters.get(0).getSupportedMediaTypes().size());
    assertEquals(2, messageConverters.get(1).getSupportedMediaTypes().size());
    assertEquals(2, messageConverters.get(4).getSupportedMediaTypes().size());
    assertEquals(2, getResult.getSupportedMediaTypes().size());
    assertEquals(2, objectMapper.getRegisteredModuleIds().size());
    assertEquals(237020288, deserializationConfig.getDeserializationFeatures());
    assertEquals(2722236, serializationConfig.getSerializationFeatures());
    HttpMessageConverter<?> getResult2 = messageConverters.get(5);
    assertEquals(3, getResult2.getSupportedMediaTypes().size());
    assertEquals(7, messageConverters.size());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig.getSerializationInclusion());
    assertEquals(AuthenticationScheme.header, resource.getAuthenticationScheme());
    assertEquals(AuthenticationScheme.header, resource.getClientAuthenticationScheme());
    assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
        ((DefaultUriBuilderFactory) uriTemplateHandler).getEncodingMode());
    DeserializerFactoryConfig factoryConfig = ((BeanDeserializerFactory) factory).getFactoryConfig();
    assertFalse(factoryConfig.hasAbstractTypeResolvers());
    assertFalse(factoryConfig.hasDeserializerModifiers());
    SerializerFactoryConfig factoryConfig2 = ((BeanSerializerFactory) serializerFactory).getFactoryConfig();
    assertFalse(factoryConfig2.hasSerializerModifiers());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult2).isProcessExternalEntities());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult2).isSupportDtd());
    assertTrue(factoryConfig.hasDeserializers());
    assertTrue(factoryConfig.hasKeyDeserializers());
    assertTrue(factoryConfig.hasValueInstantiators());
    assertTrue(deserializationConfig.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig.isAnnotationProcessingEnabled());
    assertTrue(factoryConfig2.hasKeySerializers());
    assertTrue(factoryConfig2.hasSerializers());
    assertTrue(((ArrayIterator<Deserializers>) factoryConfig.deserializers()).hasNext());
    assertTrue(((ArrayIterator<Serializers>) factoryConfig2.serializers()).hasNext());
    assertTrue(actualClientCredentialsRestTemplateResult.getInterceptors().isEmpty());
    assertTrue(((DefaultUriBuilderFactory) uriTemplateHandler).getDefaultUriVariables().isEmpty());
    JsonNodeFactory expectedNodeFactory = objectMapper.getNodeFactory();
    assertSame(expectedNodeFactory, deserializationConfig.getNodeFactory());
    assertSame(typeFactory, deserializationConfig.getTypeFactory());
    assertSame(typeFactory, serializationConfig.getTypeFactory());
    Base64Variant expectedBase64Variant = serializationConfig.getBase64Variant();
    assertSame(expectedBase64Variant, deserializationConfig.getBase64Variant());
    Locale expectedLocale = deserializationConfig.getLocale();
    assertSame(expectedLocale, serializationConfig.getLocale());
    TimeZone expectedTimeZone = deserializationConfig.getTimeZone();
    assertSame(expectedTimeZone, serializationConfig.getTimeZone());
    JsonSetter.Value expectedDefaultSetterInfo = deserializationConfig.getDefaultSetterInfo();
    assertSame(expectedDefaultSetterInfo, serializationConfig.getDefaultSetterInfo());
    assertSame(objectMapper, factory2.getCodec());
    assertSame(factory2, objectMapper.getJsonFactory());
    assertSame(attributes, deserializationConfig.getAttributes());
    assertSame(classIntrospector, deserializationConfig.getClassIntrospector());
    assertSame(serializerProviderInstance.getAnnotationIntrospector(),
        deserializationConfig.getAnnotationIntrospector());
    assertSame(serializerProviderInstance.getAnnotationIntrospector(), serializationConfig.getAnnotationIntrospector());
    assertSame(objectMapper.getVisibilityChecker(), serializationConfig.getDefaultVisibilityChecker());
    assertSame(subtypeResolver, deserializationConfig.getSubtypeResolver());
    assertSame(subtypeResolver, serializationConfig.getSubtypeResolver());
    assertSame(serializerProviderInstance.getDefaultNullKeySerializer(),
        serializerProvider.getDefaultNullKeySerializer());
    assertSame(serializerProviderInstance.getDefaultNullValueSerializer(),
        serializerProvider.getDefaultNullValueSerializer());
    assertSame(objectMapper.getDateFormat(), deserializationConfig.getDateFormat());
    assertSame(objectMapper.getDateFormat(), serializationConfig.getDateFormat());
  }
}

