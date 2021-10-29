package com.piggymetrics.auth.service.security;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.auth.domain.User;
import com.piggymetrics.auth.repository.UserRepository;
import java.util.Optional;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {MongoUserDetailsService.class})
@RunWith(SpringRunner.class)
public class MongoUserDetailsServiceDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Autowired
  private MongoUserDetailsService mongoUserDetailsService;

  @MockBean
  private UserRepository userRepository;
  @Test
  public void testLoadUserByUsername() throws UsernameNotFoundException {
    // Arrange
    User user = new User();
    user.setPassword("iloveyou");
    user.setUsername("janedoe");
    Optional<User> ofResult = Optional.<User>of(user);
    when(this.userRepository.findById((String) any())).thenReturn(ofResult);

    // Act and Assert
    assertSame(user, this.mongoUserDetailsService.loadUserByUsername("janedoe"));
    verify(this.userRepository).findById((String) any());
  }

  @Test
  public void testLoadUserByUsername2() throws UsernameNotFoundException {
    // Arrange
    when(this.userRepository.findById((String) any())).thenReturn(Optional.<User>empty());

    // Act and Assert
    thrown.expect(UsernameNotFoundException.class);
    this.mongoUserDetailsService.loadUserByUsername("janedoe");
    verify(this.userRepository).findById((String) any());
  }
}

