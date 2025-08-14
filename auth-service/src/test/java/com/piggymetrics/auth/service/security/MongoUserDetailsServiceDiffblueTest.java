package com.piggymetrics.auth.service.security;

import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.piggymetrics.auth.repository.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * <ul>
   *   <li>When {@code Username}.
   *   <li>Then throw {@link UsernameNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link MongoUserDetailsService#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.security.core.userdetails.UserDetails MongoUserDetailsService.loadUserByUsername(String)"
  })
  public void testLoadUserByUsername_whenUsername_thenThrowUsernameNotFoundException()
      throws UsernameNotFoundException {
    // Arrange, Act and Assert
    thrown.expect(UsernameNotFoundException.class);
    mongoUserDetailsService.loadUserByUsername("Username");
  }
}
