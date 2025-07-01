package com.piggymetrics.statistics.config;

import static org.junit.Assert.assertTrue;
import com.piggymetrics.statistics.service.security.CustomUserInfoTokenServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(
    classes = {
      ResourceServerConfig.class,
      ResourceServerProperties.class,
      AuthenticationConfiguration.class
    })
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceServerConfigDiffblueTest {
  @Autowired private ResourceServerConfig resourceServerConfig;

  @Autowired private ResourceServerProperties resourceServerProperties;

  /**
   * Test {@link ResourceServerConfig#tokenServices()}.
   *
   * <p>Method under test: {@link ResourceServerConfig#tokenServices()}
   */
  @Test
  public void testTokenServices() {
    // Arrange, Act and Assert
    assertTrue(resourceServerConfig.tokenServices() instanceof CustomUserInfoTokenServices);
  }
}
