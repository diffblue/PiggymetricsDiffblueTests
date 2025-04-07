package com.piggymetrics.statistics.service.security;

import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomUserInfoTokenServicesDiffblueTest {
  @Autowired
  private CustomUserInfoTokenServices customUserInfoTokenServices;

  @MockBean
  private MongodExecutable mongodExecutable;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  /**
   * Test {@link CustomUserInfoTokenServices#loadAuthentication(String)}.
   * <p>
   * Method under test: {@link CustomUserInfoTokenServices#loadAuthentication(String)}
   */
  @Test
  public void testLoadAuthentication() throws AuthenticationException, InvalidTokenException {
    // Arrange
    CustomUserInfoTokenServices customUserInfoTokenServices = new CustomUserInfoTokenServices(
        "https://config.us-east-2.amazonaws.com", "42");
    customUserInfoTokenServices.setRestTemplate(new OAuth2RestTemplate(new BaseOAuth2ProtectedResourceDetails()));

    // Act and Assert
    thrown.expect(InvalidTokenException.class);
    customUserInfoTokenServices.loadAuthentication("ABC123");
  }

  /**
   * Test {@link CustomUserInfoTokenServices#loadAuthentication(String)}.
   * <ul>
   *   <li>Given {@link CustomUserInfoTokenServices}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomUserInfoTokenServices#loadAuthentication(String)}
   */
  @Test
  public void testLoadAuthentication_givenCustomUserInfoTokenServices()
      throws AuthenticationException, InvalidTokenException {
    // Arrange, Act and Assert
    thrown.expect(InvalidTokenException.class);
    customUserInfoTokenServices.loadAuthentication("ABC123");
  }

  /**
   * Test {@link CustomUserInfoTokenServices#readAccessToken(String)}.
   * <p>
   * Method under test: {@link CustomUserInfoTokenServices#readAccessToken(String)}
   */
  @Test
  public void testReadAccessToken() {
    // Arrange, Act and Assert
    thrown.expect(UnsupportedOperationException.class);
    customUserInfoTokenServices.readAccessToken("ABC123");
  }
}
