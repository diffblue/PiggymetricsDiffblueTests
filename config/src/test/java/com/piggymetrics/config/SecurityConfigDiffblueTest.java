package com.piggymetrics.config;

import static org.junit.Assert.assertSame;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SecurityConfigDiffblueTest {
  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private ObjectPostProcessor<Object> objectPostProcessor;

  @Autowired
  private SecurityConfig securityConfig;

  /**
   * Method under test: {@link SecurityConfig#configure(HttpSecurity)}
   */
  @Test
  public void testConfigure() throws Exception {
    // Arrange
    AuthenticationManagerBuilder authenticationBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
    HttpSecurity http = new HttpSecurity(objectPostProcessor, authenticationBuilder, new HashMap<>());

    // Act
    securityConfig.configure(http);

    // Assert
    assertSame(http, http.anonymous().and());
  }
}
