package com.piggymetrics.auth.config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.piggymetrics.auth.repository.UserRepository;
import com.piggymetrics.auth.service.security.MongoUserDetailsService;
import de.flapdoodle.embed.mongo.MongodExecutable;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
    assertTrue(((DaoAuthenticationProvider) ((ProviderManager) auth.getOrBuild()).getProviders().get(0))
        .getUserCache() instanceof NullUserCache);
    assertFalse(((DaoAuthenticationProvider) ((ProviderManager) auth.getOrBuild()).getProviders().get(0))
        .isForcePrincipalAsString());
    assertTrue(((DaoAuthenticationProvider) ((ProviderManager) auth.getOrBuild()).getProviders().get(0))
        .isHideUserNotFoundExceptions());
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
    assertTrue(((DaoAuthenticationProvider) ((ProviderManager) auth.getOrBuild()).getProviders().get(0))
        .getUserCache() instanceof NullUserCache);
    assertFalse(((DaoAuthenticationProvider) ((ProviderManager) auth.getOrBuild()).getProviders().get(0))
        .isForcePrincipalAsString());
    assertTrue(((DaoAuthenticationProvider) ((ProviderManager) auth.getOrBuild()).getProviders().get(0))
        .isHideUserNotFoundExceptions());
  }

  /**
   * Method under test: {@link WebSecurityConfig#configure(HttpSecurity)}
   */
  @Test
  public void testConfigure3() throws Exception {
    // Arrange
    AuthenticationManagerBuilder authenticationBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
    HttpSecurity http = new HttpSecurity(objectPostProcessor, authenticationBuilder, new HashMap<>());

    // Act
    webSecurityConfig.configure(http);

    // Assert
    assertSame(http, http.anonymous().and());
  }
}
