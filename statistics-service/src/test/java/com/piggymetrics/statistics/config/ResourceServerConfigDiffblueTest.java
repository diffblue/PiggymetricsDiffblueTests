package com.piggymetrics.statistics.config;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ResourceServerConfigDiffblueTest {
  @Autowired
  private ResourceServerConfig resourceServerConfig;
  @Test
  public void testTokenServices() {
    // Arrange, Act and Assert
    assertTrue(this.resourceServerConfig
        .tokenServices() instanceof com.piggymetrics.statistics.service.security.CustomUserInfoTokenServices);
  }
}

