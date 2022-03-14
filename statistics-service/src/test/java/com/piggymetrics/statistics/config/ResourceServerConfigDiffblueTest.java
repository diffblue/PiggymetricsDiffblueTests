package com.piggymetrics.statistics.config;

import static org.junit.Assert.assertTrue;
import com.piggymetrics.statistics.repository.DataPointRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceServerConfigDiffblueTest {
  @MockBean
  private DataPointRepository dataPointRepository;

  @MockBean
  private MongodExecutable mongodExecutable;

  @Autowired
  private ResourceServerConfig resourceServerConfig;

  @Autowired
  private ResourceServerProperties resourceServerProperties;
  @Test
  public void testTokenServices() {
    // Arrange, Act and Assert
    assertTrue(this.resourceServerConfig
        .tokenServices() instanceof com.piggymetrics.statistics.service.security.CustomUserInfoTokenServices);
  }
}

