package com.piggymetrics.statistics.service.security;

import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CustomUserInfoTokenServices.class, String.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomUserInfoTokenServicesDiffblueTest {
  @Autowired private CustomUserInfoTokenServices customUserInfoTokenServices;

  @Rule public ExpectedException thrown = ExpectedException.none();

  /**
   * Test {@link CustomUserInfoTokenServices#loadAuthentication(String)}.
   *
   * <p>Method under test: {@link CustomUserInfoTokenServices#loadAuthentication(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.provider.OAuth2Authentication CustomUserInfoTokenServices.loadAuthentication(String)"
  })
  public void testLoadAuthentication() throws AuthenticationException, InvalidTokenException {
    // Arrange
    customUserInfoTokenServices.setRestTemplate(
        new OAuth2RestTemplate(new BaseOAuth2ProtectedResourceDetails()));

    // Act and Assert
    thrown.expect(InvalidTokenException.class);
    customUserInfoTokenServices.loadAuthentication("ABC123");
  }

  /**
   * Test {@link CustomUserInfoTokenServices#loadAuthentication(String)}.
   *
   * <ul>
   *   <li>Given {@link CustomUserInfoTokenServices}.
   *   <li>When {@code ABC123}.
   * </ul>
   *
   * <p>Method under test: {@link CustomUserInfoTokenServices#loadAuthentication(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.provider.OAuth2Authentication CustomUserInfoTokenServices.loadAuthentication(String)"
  })
  public void testLoadAuthentication_givenCustomUserInfoTokenServices_whenAbc123()
      throws AuthenticationException, InvalidTokenException {
    // Arrange, Act and Assert
    thrown.expect(InvalidTokenException.class);
    customUserInfoTokenServices.loadAuthentication("ABC123");
  }

  /**
   * Test {@link CustomUserInfoTokenServices#loadAuthentication(String)}.
   *
   * <ul>
   *   <li>Given {@link CustomUserInfoTokenServices}.
   *   <li>When {@code ExampleToken}.
   * </ul>
   *
   * <p>Method under test: {@link CustomUserInfoTokenServices#loadAuthentication(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.provider.OAuth2Authentication CustomUserInfoTokenServices.loadAuthentication(String)"
  })
  public void testLoadAuthentication_givenCustomUserInfoTokenServices_whenExampleToken()
      throws AuthenticationException, InvalidTokenException {
    // Arrange, Act and Assert
    thrown.expect(InvalidTokenException.class);
    customUserInfoTokenServices.loadAuthentication("ExampleToken");
  }

  /**
   * Test {@link CustomUserInfoTokenServices#loadAuthentication(String)}.
   *
   * <ul>
   *   <li>Given {@link CustomUserInfoTokenServices}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomUserInfoTokenServices#loadAuthentication(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.provider.OAuth2Authentication CustomUserInfoTokenServices.loadAuthentication(String)"
  })
  public void testLoadAuthentication_givenCustomUserInfoTokenServices_whenNull()
      throws AuthenticationException, InvalidTokenException {
    // Arrange, Act and Assert
    thrown.expect(InvalidTokenException.class);
    customUserInfoTokenServices.loadAuthentication(null);
  }

  /**
   * Test {@link CustomUserInfoTokenServices#readAccessToken(String)}.
   *
   * <p>Method under test: {@link CustomUserInfoTokenServices#readAccessToken(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.oauth2.common.OAuth2AccessToken CustomUserInfoTokenServices.readAccessToken(String)"
  })
  public void testReadAccessToken() {
    // Arrange, Act and Assert
    thrown.expect(UnsupportedOperationException.class);
    customUserInfoTokenServices.readAccessToken("ABC123");
  }
}
