package com.piggymetrics.auth.config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.piggymetrics.auth.repository.UserRepository;
import com.piggymetrics.auth.service.security.MongoUserDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.accept.ContentNegotiationStrategy;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {WebSecurityConfig.class, AuthenticationManagerBuilder.class,
    MongoUserDetailsService.class, AuthenticationConfiguration.class})
@RunWith(SpringRunner.class)
public class WebSecurityConfigDiffblueTest {
  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private AuthenticationManagerBuilder authenticationManagerBuilder;

  @MockBean
  private AuthenticationTrustResolver authenticationTrustResolver;

  @MockBean
  private ContentNegotiationStrategy contentNegotiationStrategy;

  @Autowired
  private ObjectPostProcessor<Object> objectPostProcessor;

  @MockBean
  private UserRepository userRepository;

  @Autowired
  private WebSecurityConfig webSecurityConfig;
  @Test
  public void testConfigure() throws Exception {
    // Arrange and Act
    this.webSecurityConfig.configure(this.authenticationManagerBuilder);

    // Assert
    assertTrue(this.authenticationManagerBuilder.getDefaultUserDetailsService() instanceof MongoUserDetailsService);
    AuthenticationManager orBuild = this.authenticationManagerBuilder.getOrBuild();
    assertTrue(orBuild instanceof ProviderManager);
    assertTrue(((DaoAuthenticationProvider) ((ProviderManager) orBuild).getProviders().get(0))
        .getUserCache() instanceof org.springframework.security.core.userdetails.cache.NullUserCache);
    assertTrue(
        ((DaoAuthenticationProvider) ((ProviderManager) orBuild).getProviders().get(0)).isHideUserNotFoundExceptions());
    assertFalse(
        ((DaoAuthenticationProvider) ((ProviderManager) orBuild).getProviders().get(0)).isForcePrincipalAsString());
  }
}

