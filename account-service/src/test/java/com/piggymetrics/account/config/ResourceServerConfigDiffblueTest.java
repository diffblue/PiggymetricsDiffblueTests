package com.piggymetrics.account.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.piggymetrics.account.repository.AccountRepository;
import com.piggymetrics.account.service.security.CustomUserInfoTokenServices;
import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringValueResolver;

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
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ClientCredentialsResourceDetails actualClientCredentialsResourceDetailsResult = (new ResourceServerConfig(
        new ResourceServerProperties())).clientCredentialsResourceDetails();

    // Assert
    assertEquals("access_token", actualClientCredentialsResourceDetailsResult.getTokenName());
    assertEquals("client_credentials", actualClientCredentialsResourceDetailsResult.getGrantType());
    assertEquals(AuthenticationScheme.header, actualClientCredentialsResourceDetailsResult.getAuthenticationScheme());
    assertEquals(AuthenticationScheme.header,
        actualClientCredentialsResourceDetailsResult.getClientAuthenticationScheme());
  }

  /**
   * Method under test:
   * {@link ResourceServerConfig#clientCredentialsResourceDetails()}
   */
  @Test
  public void testClientCredentialsResourceDetails2() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.addEmbeddedValueResolver(mock(StringValueResolver.class));

    ResourceServerProperties sso = new ResourceServerProperties();
    sso.setBeanFactory(beanFactory);

    // Act
    ClientCredentialsResourceDetails actualClientCredentialsResourceDetailsResult = (new ResourceServerConfig(sso))
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
    assertEquals(1, actualClientCredentialsRestTemplateResult.getInterceptors().size());
    assertEquals(7, actualClientCredentialsRestTemplateResult.getMessageConverters().size());
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
