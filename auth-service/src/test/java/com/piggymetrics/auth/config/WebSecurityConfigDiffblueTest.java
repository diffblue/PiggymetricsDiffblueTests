package com.piggymetrics.auth.config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.piggymetrics.auth.repository.UserRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
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
  @Test
  public void testConfigure() throws Exception {
    // Arrange
    AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(
        this.objectPostProcessor);

    // Act
    this.webSecurityConfig.configure(authenticationManagerBuilder);

    // Assert
    assertTrue(authenticationManagerBuilder
        .getDefaultUserDetailsService() instanceof com.piggymetrics.auth.service.security.MongoUserDetailsService);
    assertTrue(((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
        .get(0)).getUserCache() instanceof org.springframework.security.core.userdetails.cache.NullUserCache);
    assertTrue(((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
        .get(0)).isHideUserNotFoundExceptions());
    assertFalse(
        ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
            .get(0)).isForcePrincipalAsString());
  }
}

