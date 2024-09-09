package com.piggymetrics.account.service.security;

import com.piggymetrics.account.repository.AccountRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomUserInfoTokenServicesDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @MockBean
  private AccountRepository accountRepository;

  @Autowired
  private CustomUserInfoTokenServices customUserInfoTokenServices;

  @MockBean
  private MongodExecutable mongodExecutable;

  /**
   * Method under test:
   * {@link CustomUserInfoTokenServices#loadAuthentication(String)}
   */
  @Test
  public void testLoadAuthentication_givenAccountRepositoryAndMongodExecutableAndCustomUserInfoTokenServices_whenAbc123_thenThrowsInvalidTokenException()
      throws AuthenticationException, InvalidTokenException {
    // Arrange, Act and Assert
    thrown.expect(InvalidTokenException.class);
    customUserInfoTokenServices.loadAuthentication("ABC123");
  }

  /**
   * Method under test:
   * {@link CustomUserInfoTokenServices#readAccessToken(String)}
   */
  @Test
  public void testReadAccessToken_givenAccountRepositoryAndMongodExecutableAndCustomUserInfoTokenServices_whenAbc123_thenThrowsUnsupportedOperationException() {
    // Arrange, Act and Assert
    thrown.expect(UnsupportedOperationException.class);
    customUserInfoTokenServices.readAccessToken("ABC123");
  }
}
