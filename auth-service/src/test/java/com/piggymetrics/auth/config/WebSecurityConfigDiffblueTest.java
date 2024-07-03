package com.piggymetrics.auth.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.piggymetrics.auth.repository.UserRepository;
import com.piggymetrics.auth.service.security.MongoUserDetailsService;
import de.flapdoodle.embed.mongo.MongodExecutable;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class WebSecurityConfigDiffblueTest {
  @Autowired
  private ApplicationContext applicationContext;

  @MockBean
  private MongodExecutable mongodExecutable;

  @Autowired
  private ObjectPostProcessor<Object> objectPostProcessor;

  @MockBean
  private UserRepository userRepository;

  @Autowired
  private WebSecurityConfig webSecurityConfig;

  /**
   * Method under test:
   * {@link WebSecurityConfig#configure(AuthenticationManagerBuilder)}
   */
  @Test
  public void testConfigure() throws Exception {
    // Arrange
    AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(objectPostProcessor);

    // Act
    webSecurityConfig.configure(auth);

    // Assert
    assertTrue(auth.getDefaultUserDetailsService() instanceof MongoUserDetailsService);
    AuthenticationManager orBuild = auth.getOrBuild();
    assertTrue(orBuild instanceof ProviderManager);
    List<AuthenticationProvider> providers = ((ProviderManager) orBuild).getProviders();
    assertEquals(1, providers.size());
    AuthenticationProvider getResult = providers.get(0);
    assertTrue(getResult instanceof DaoAuthenticationProvider);
    assertTrue(((DaoAuthenticationProvider) getResult).getUserCache() instanceof NullUserCache);
    assertFalse(((DaoAuthenticationProvider) getResult).isForcePrincipalAsString());
    assertTrue(((ProviderManager) orBuild).isEraseCredentialsAfterAuthentication());
    assertTrue(((DaoAuthenticationProvider) getResult).isHideUserNotFoundExceptions());
    assertTrue(auth.isConfigured());
    assertSame(orBuild, auth.getObject());
  }

  /**
   * Method under test:
   * {@link WebSecurityConfig#configure(AuthenticationManagerBuilder)}
   */
  @Test
  public void testConfigure2() throws Exception {
    // Arrange
    AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(objectPostProcessor);
    auth.authenticationEventPublisher(new DefaultAuthenticationEventPublisher(mock(ApplicationEventPublisher.class)));

    // Act
    webSecurityConfig.configure(auth);

    // Assert
    assertTrue(auth.getDefaultUserDetailsService() instanceof MongoUserDetailsService);
    AuthenticationManager orBuild = auth.getOrBuild();
    assertTrue(orBuild instanceof ProviderManager);
    List<AuthenticationProvider> providers = ((ProviderManager) orBuild).getProviders();
    assertEquals(1, providers.size());
    AuthenticationProvider getResult = providers.get(0);
    assertTrue(getResult instanceof DaoAuthenticationProvider);
    assertTrue(((DaoAuthenticationProvider) getResult).getUserCache() instanceof NullUserCache);
    assertFalse(((DaoAuthenticationProvider) getResult).isForcePrincipalAsString());
    assertTrue(((ProviderManager) orBuild).isEraseCredentialsAfterAuthentication());
    assertTrue(((DaoAuthenticationProvider) getResult).isHideUserNotFoundExceptions());
    assertTrue(auth.isConfigured());
    assertSame(orBuild, auth.getObject());
  }
}
