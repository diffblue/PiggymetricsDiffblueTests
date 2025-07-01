package com.piggymetrics.auth.service.security;

import com.piggymetrics.auth.repository.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MongoUserDetailsService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoUserDetailsServiceDiffblueTest {
  @Autowired private MongoUserDetailsService mongoUserDetailsService;

  @Rule public ExpectedException thrown = ExpectedException.none();

  @MockBean private UserRepository userRepository;

  /**
   * Test {@link MongoUserDetailsService#loadUserByUsername(String)}.
   *
   * <p>Method under test: {@link MongoUserDetailsService#loadUserByUsername(String)}
   */
  @Test
  public void testLoadUserByUsername() throws UsernameNotFoundException {
    // Arrange, Act and Assert
    thrown.expect(UsernameNotFoundException.class);
    mongoUserDetailsService.loadUserByUsername("janedoe");
  }
}
