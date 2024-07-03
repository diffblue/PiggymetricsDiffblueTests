package com.piggymetrics.account.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
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
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.piggymetrics.account.repository.AccountRepository;
import com.piggymetrics.account.service.security.CustomUserInfoTokenServices;
import de.flapdoodle.embed.mongo.MongodExecutable;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.http.MediaType;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.http.OAuth2ErrorHandler;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
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
  public void testClientCredentialsRestTemplate() throws MissingResourceException {
    // Arrange and Act
    OAuth2RestTemplate actualClientCredentialsRestTemplateResult = resourceServerConfig.clientCredentialsRestTemplate();

    // Assert
    List<HttpMessageConverter<?>> messageConverters = actualClientCredentialsRestTemplateResult.getMessageConverters();
    assertEquals(7, messageConverters.size());
    HttpMessageConverter<?> getResult = messageConverters.get(6);
    ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) getResult).getObjectMapper();
    SerializationConfig serializationConfig = objectMapper.getSerializationConfig();
    assertTrue(serializationConfig.getDefaultPrettyPrinter() instanceof DefaultPrettyPrinter);
    JsonFactory factory = objectMapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(serializationConfig.getAttributes() instanceof ContextAttributes.Impl);
    DeserializationContext deserializationContext = objectMapper.getDeserializationContext();
    DeserializerFactory factory2 = deserializationContext.getFactory();
    assertTrue(factory2 instanceof BeanDeserializerFactory);
    assertTrue(deserializationContext instanceof DefaultDeserializationContext.Impl);
    assertTrue(serializationConfig.getClassIntrospector() instanceof BasicClassIntrospector);
    SerializerProvider serializerProviderInstance = objectMapper.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance.getAnnotationIntrospector() instanceof JacksonAnnotationIntrospector);
    assertTrue(objectMapper.getVisibilityChecker() instanceof VisibilityChecker.Std);
    assertTrue(objectMapper.getSubtypeResolver() instanceof StdSubtypeResolver);
    SerializerFactory serializerFactory = objectMapper.getSerializerFactory();
    assertTrue(serializerFactory instanceof BeanSerializerFactory);
    SerializerProvider serializerProvider = objectMapper.getSerializerProvider();
    assertTrue(serializerProvider instanceof DefaultSerializerProvider.Impl);
    assertTrue(serializerProviderInstance instanceof DefaultSerializerProvider.Impl);
    JsonSerializer<Object> defaultNullKeySerializer = serializerProvider.getDefaultNullKeySerializer();
    assertTrue(defaultNullKeySerializer instanceof FailingSerializer);
    JsonSerializer<Object> defaultNullValueSerializer = serializerProvider.getDefaultNullValueSerializer();
    assertTrue(defaultNullValueSerializer instanceof NullSerializer);
    DeserializerFactoryConfig factoryConfig = ((BeanDeserializerFactory) factory2).getFactoryConfig();
    Iterable<Deserializers> deserializersResult = factoryConfig.deserializers();
    assertTrue(deserializersResult instanceof ArrayIterator);
    SerializerFactoryConfig factoryConfig2 = ((BeanSerializerFactory) serializerFactory).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig2.serializers();
    assertTrue(serializersResult instanceof ArrayIterator);
    DateFormat dateFormat = objectMapper.getDateFormat();
    assertTrue(dateFormat instanceof StdDateFormat);
    assertTrue(
        actualClientCredentialsRestTemplateResult.getRequestFactory() instanceof InterceptingClientHttpRequestFactory);
    HttpMessageConverter<?> getResult2 = messageConverters.get(0);
    assertTrue(getResult2 instanceof ByteArrayHttpMessageConverter);
    HttpMessageConverter<?> getResult3 = messageConverters.get(2);
    assertTrue(getResult3 instanceof ResourceHttpMessageConverter);
    HttpMessageConverter<?> getResult4 = messageConverters.get(1);
    assertTrue(getResult4 instanceof StringHttpMessageConverter);
    assertTrue(getResult instanceof MappingJackson2HttpMessageConverter);
    HttpMessageConverter<?> getResult5 = messageConverters.get(4);
    assertTrue(getResult5 instanceof AllEncompassingFormHttpMessageConverter);
    HttpMessageConverter<?> getResult6 = messageConverters.get(5);
    assertTrue(getResult6 instanceof Jaxb2RootElementHttpMessageConverter);
    OAuth2ClientContext oAuth2ClientContext = actualClientCredentialsRestTemplateResult.getOAuth2ClientContext();
    assertTrue(oAuth2ClientContext instanceof DefaultOAuth2ClientContext);
    assertTrue(actualClientCredentialsRestTemplateResult.getErrorHandler() instanceof OAuth2ErrorHandler);
    AccessTokenRequest accessTokenRequest = oAuth2ClientContext.getAccessTokenRequest();
    assertTrue(accessTokenRequest instanceof DefaultAccessTokenRequest);
    OAuth2ProtectedResourceDetails resource = actualClientCredentialsRestTemplateResult.getResource();
    assertTrue(resource instanceof ClientCredentialsResourceDetails);
    UriTemplateHandler uriTemplateHandler = actualClientCredentialsRestTemplateResult.getUriTemplateHandler();
    assertTrue(uriTemplateHandler instanceof DefaultUriBuilderFactory);
    assertEquals(" ", factory.getRootValueSeparator());
    Locale locale = serializerProviderInstance.getLocale();
    assertEquals("", locale.getCountry());
    assertEquals("", locale.getDisplayCountry());
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getISO3Country());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    List<MediaType> supportedMediaTypes = getResult4.getSupportedMediaTypes();
    assertEquals(2, supportedMediaTypes.size());
    MediaType getResult7 = supportedMediaTypes.get(1);
    assertEquals("*", getResult7.getSubtype());
    assertEquals("*", getResult7.getType());
    List<MediaType> supportedMediaTypes2 = getResult.getSupportedMediaTypes();
    assertEquals(2, supportedMediaTypes2.size());
    MediaType getResult8 = supportedMediaTypes2.get(1);
    assertEquals("*+json", getResult8.getSubtype());
    List<MediaType> supportedMediaTypes3 = getResult6.getSupportedMediaTypes();
    assertEquals(3, supportedMediaTypes3.size());
    MediaType getResult9 = supportedMediaTypes3.get(2);
    assertEquals("*+xml", getResult9.getSubtype());
    TimeZone timeZone = serializationConfig.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("English", locale.getDisplayName());
    assertEquals("ISO-8859-1", ((StringHttpMessageConverter) getResult4).getDefaultCharset().name());
    assertEquals("JSON", factory.getFormatName());
    Base64Variant base64Variant = serializationConfig.getBase64Variant();
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.getName());
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.toString());
    assertEquals("UTC", timeZone.getID());
    assertEquals("UTF-8", ((MappingJackson2HttpMessageConverter) getResult).getDefaultCharset().name());
    assertEquals("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSZ', 'EEE, dd MMM yyyy HH:mm:ss zzz' (lenient)]",
        ((StdDateFormat) dateFormat).toPattern());
    assertEquals("access_token", resource.getTokenName());
    List<MediaType> supportedMediaTypes4 = getResult2.getSupportedMediaTypes();
    assertEquals(2, supportedMediaTypes4.size());
    MediaType getResult10 = supportedMediaTypes4.get(0);
    assertEquals("application", getResult10.getType());
    List<MediaType> supportedMediaTypes5 = getResult5.getSupportedMediaTypes();
    assertEquals(2, supportedMediaTypes5.size());
    MediaType getResult11 = supportedMediaTypes5.get(0);
    assertEquals("application", getResult11.getType());
    MediaType getResult12 = supportedMediaTypes3.get(0);
    assertEquals("application", getResult12.getType());
    assertEquals("application", getResult9.getType());
    MediaType getResult13 = supportedMediaTypes2.get(0);
    assertEquals("application", getResult13.getType());
    assertEquals("application", getResult8.getType());
    assertEquals("client_credentials", resource.getGrantType());
    Version versionResult = factory.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    Version versionResult2 = objectMapper.version();
    assertEquals("com.fasterxml.jackson.core", versionResult2.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-core/2.9.6", versionResult.toFullString());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.9.6", versionResult2.toFullString());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    MediaType getResult14 = supportedMediaTypes5.get(1);
    assertEquals("form-data", getResult14.getSubtype());
    assertEquals("jackson-core", versionResult.getArtifactId());
    assertEquals("jackson-databind", versionResult2.getArtifactId());
    assertEquals("json", getResult13.getSubtype());
    assertEquals("multipart", getResult14.getType());
    assertEquals("octet-stream", getResult10.getSubtype());
    MediaType getResult15 = supportedMediaTypes.get(0);
    assertEquals("plain", getResult15.getSubtype());
    assertEquals("text", getResult15.getType());
    MediaType getResult16 = supportedMediaTypes3.get(1);
    assertEquals("text", getResult16.getType());
    assertEquals("x-www-form-urlencoded", getResult11.getSubtype());
    assertEquals("xml", getResult12.getSubtype());
    assertEquals("xml", getResult16.getSubtype());
    assertEquals('=', base64Variant.getPaddingChar());
    assertNull(serializerProvider.getGenerator());
    assertNull(serializerProviderInstance.getGenerator());
    assertNull(deserializationContext.getParser());
    assertNull(factory.getCharacterEscapes());
    assertNull(factory.getInputDecorator());
    assertNull(factory.getOutputDecorator());
    assertNull(deserializationContext.getConfig());
    assertNull(objectMapper.getInjectableValues());
    assertNull(deserializationContext.getContextualType());
    assertNull(defaultNullKeySerializer.getDelegatee());
    assertNull(defaultNullValueSerializer.getDelegatee());
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
    assertNull(serializerProviderInstance.getFilterProvider());
    assertNull(deserializationConfig.getProblemHandlers());
    assertNull(deserializationConfig.getDefaultMergeable());
    assertNull(serializationConfig.getDefaultMergeable());
    assertNull(factory.getFormatReadFeatureType());
    assertNull(factory.getFormatWriteFeatureType());
    JsonInclude.Value defaultPropertyInclusion = serializationConfig.getDefaultPropertyInclusion();
    assertNull(defaultPropertyInclusion.getContentFilter());
    assertNull(defaultPropertyInclusion.getValueFilter());
    assertNull(deserializationContext.getActiveView());
    assertNull(serializerProvider.getActiveView());
    assertNull(serializerProviderInstance.getActiveView());
    assertNull(serializerProvider.getSerializationView());
    assertNull(serializerProviderInstance.getSerializationView());
    assertNull(deserializationConfig.getActiveView());
    assertNull(serializationConfig.getActiveView());
    assertNull(objectMapper.getTypeFactory().getClassLoader());
    assertNull(deserializationConfig.getRootName());
    assertNull(serializationConfig.getRootName());
    assertNull(resource.getAccessTokenUri());
    assertNull(resource.getClientId());
    assertNull(resource.getClientSecret());
    assertNull(resource.getId());
    assertNull(((ByteArrayHttpMessageConverter) getResult2).getDefaultCharset());
    assertNull(((ResourceHttpMessageConverter) getResult3).getDefaultCharset());
    assertNull(((Jaxb2RootElementHttpMessageConverter) getResult6).getDefaultCharset());
    assertNull(getResult10.getCharset());
    assertNull(getResult15.getCharset());
    assertNull(getResult7.getCharset());
    assertNull(getResult11.getCharset());
    assertNull(getResult14.getCharset());
    assertNull(getResult12.getCharset());
    assertNull(getResult16.getCharset());
    assertNull(getResult9.getCharset());
    assertNull(getResult13.getCharset());
    assertNull(getResult8.getCharset());
    assertNull(dateFormat.getNumberFormat());
    assertNull(dateFormat.getCalendar());
    assertNull(resource.getScope());
    assertNull(dateFormat.getTimeZone());
    assertNull(oAuth2ClientContext.getAccessToken());
    assertEquals(0, deserializationContext.getDeserializationFeatures());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualClientCredentialsRestTemplateResult.getInterceptors().size());
    List<MediaType> supportedMediaTypes6 = getResult3.getSupportedMediaTypes();
    assertEquals(1, supportedMediaTypes6.size());
    assertEquals(1.0d, getResult10.getQualityValue(), 0.0);
    assertEquals(1.0d, getResult15.getQualityValue(), 0.0);
    assertEquals(1.0d, getResult7.getQualityValue(), 0.0);
    assertEquals(1.0d, getResult11.getQualityValue(), 0.0);
    assertEquals(1.0d, getResult14.getQualityValue(), 0.0);
    assertEquals(1.0d, getResult12.getQualityValue(), 0.0);
    assertEquals(1.0d, getResult16.getQualityValue(), 0.0);
    assertEquals(1.0d, getResult9.getQualityValue(), 0.0);
    assertEquals(1.0d, getResult13.getQualityValue(), 0.0);
    assertEquals(1.0d, getResult8.getQualityValue(), 0.0);
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult2.getMajorVersion());
    assertEquals(2, objectMapper.getRegisteredModuleIds().size());
    assertEquals(237020288, deserializationConfig.getDeserializationFeatures());
    assertEquals(2722236, serializationConfig.getSerializationFeatures());
    assertEquals(6, versionResult.getPatchLevel());
    assertEquals(6, versionResult2.getPatchLevel());
    assertEquals(9, versionResult.getMinorVersion());
    assertEquals(9, versionResult2.getMinorVersion());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig.getSerializationInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getContentInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getValueInclusion());
    JsonSetter.Value defaultSetterInfo = serializationConfig.getDefaultSetterInfo();
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getContentNulls());
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getValueNulls());
    assertEquals(AuthenticationScheme.header, resource.getAuthenticationScheme());
    assertEquals(AuthenticationScheme.header, resource.getClientAuthenticationScheme());
    assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
        ((DefaultUriBuilderFactory) uriTemplateHandler).getEncodingMode());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult2.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult2.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(versionResult2.isUnknownVersion());
    assertFalse(defaultNullKeySerializer.isUnwrappingSerializer());
    assertFalse(defaultNullValueSerializer.isUnwrappingSerializer());
    assertFalse(factoryConfig.hasAbstractTypeResolvers());
    assertFalse(factoryConfig.hasDeserializerModifiers());
    assertFalse(factoryConfig2.hasSerializerModifiers());
    assertFalse(((StdDateFormat) dateFormat).isColonIncludedInTimeZone());
    assertFalse(locale.hasExtensions());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult6).isProcessExternalEntities());
    assertFalse(((Jaxb2RootElementHttpMessageConverter) getResult6).isSupportDtd());
    assertFalse(resource.isAuthenticationRequired());
    assertFalse(resource.isScoped());
    assertFalse(getResult7.isConcrete());
    assertFalse(getResult9.isConcrete());
    assertFalse(getResult8.isConcrete());
    assertFalse(getResult10.isWildcardType());
    assertFalse(getResult15.isWildcardType());
    assertFalse(getResult11.isWildcardType());
    assertFalse(getResult14.isWildcardType());
    assertFalse(getResult12.isWildcardType());
    assertFalse(getResult16.isWildcardType());
    assertFalse(getResult9.isWildcardType());
    assertFalse(getResult13.isWildcardType());
    assertFalse(getResult8.isWildcardType());
    assertTrue(factoryConfig.hasDeserializers());
    assertTrue(factoryConfig.hasKeyDeserializers());
    assertTrue(factoryConfig.hasValueInstantiators());
    assertTrue(deserializationConfig.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig.isAnnotationProcessingEnabled());
    assertTrue(factoryConfig2.hasKeySerializers());
    assertTrue(factoryConfig2.hasSerializers());
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).hasNext());
    assertTrue(((ArrayIterator<Serializers>) serializersResult).hasNext());
    assertTrue(dateFormat.isLenient());
    assertTrue(accessTokenRequest.isEmpty());
    Set<String> unicodeLocaleAttributes = locale.getUnicodeLocaleAttributes();
    assertTrue(unicodeLocaleAttributes.isEmpty());
    assertTrue(resource.isClientOnly());
    assertTrue(getResult10.isConcrete());
    assertTrue(getResult15.isConcrete());
    assertTrue(getResult11.isConcrete());
    assertTrue(getResult14.isConcrete());
    assertTrue(getResult12.isConcrete());
    assertTrue(getResult16.isConcrete());
    assertTrue(getResult13.isConcrete());
    assertTrue(getResult7.isWildcardType());
    assertEquals(accessTokenRequest, getResult10.getParameters());
    assertEquals(accessTokenRequest, ((DefaultUriBuilderFactory) uriTemplateHandler).getDefaultUriVariables());
    assertEquals(Integer.MAX_VALUE, base64Variant.getMaxLineLength());
    assertEquals('=', base64Variant.getPaddingByte());
    assertSame(dateFormat, deserializationConfig.getDateFormat());
    assertSame(dateFormat, serializationConfig.getDateFormat());
    assertSame(factory, objectMapper.getJsonFactory());
    assertSame(serializationConfig, serializerProviderInstance.getConfig());
    assertSame(defaultNullKeySerializer, serializerProviderInstance.getDefaultNullKeySerializer());
    assertSame(defaultNullValueSerializer, serializerProviderInstance.getDefaultNullValueSerializer());
    assertSame(timeZone, serializerProviderInstance.getTimeZone());
    assertSame(getResult7, supportedMediaTypes4.get(1));
    assertSame(getResult7, supportedMediaTypes6.get(0));
    assertSame(unicodeLocaleAttributes, locale.getUnicodeLocaleKeys());
    assertSame(objectMapper, factory.getCodec());
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
