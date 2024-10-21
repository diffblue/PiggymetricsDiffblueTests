package com.piggymetrics.auth.service.security;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.piggymetrics.auth.domain.User;
import com.piggymetrics.auth.repository.UserRepository;
import java.util.Optional;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MongoUserDetailsService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoUserDetailsServiceDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Autowired
  private MongoUserDetailsService mongoUserDetailsService;

  @MockBean
  private UserRepository userRepository;

  /**
   * Test {@link MongoUserDetailsService#loadUserByUsername(String)}.
   * <p>
   * Method under test: {@link MongoUserDetailsService#loadUserByUsername(String)}
   */
  @Test
  public void testLoadUserByUsername() throws UsernameNotFoundException {
    // Arrange
    when(userRepository.findById(Mockito.<String>any())).thenThrow(new UsernameNotFoundException("Msg"));

    // Act and Assert
    thrown.expect(UsernameNotFoundException.class);
    mongoUserDetailsService.loadUserByUsername("janedoe");
    verify(userRepository).findById(eq("janedoe"));
  }

  /**
   * Test {@link MongoUserDetailsService#loadUserByUsername(String)}.
   * <ul>
   *   <li>Given {@link User} (default constructor) Password is
   * {@code iloveyou}.</li>
   *   <li>Then return {@link User} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MongoUserDetailsService#loadUserByUsername(String)}
   */
  @Test
  public void testLoadUserByUsername_givenUserPasswordIsIloveyou_thenReturnUser() throws UsernameNotFoundException {
    // Arrange
    User user = new User();
    user.setPassword("iloveyou");
    user.setUsername("janedoe");
    Optional<User> ofResult = Optional.of(user);
    when(userRepository.findById(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    UserDetails actualLoadUserByUsernameResult = mongoUserDetailsService.loadUserByUsername("janedoe");

    // Assert
    verify(userRepository).findById(eq("janedoe"));
    assertSame(user, actualLoadUserByUsernameResult);
  }

  /**
   * Test {@link MongoUserDetailsService#loadUserByUsername(String)}.
   * <ul>
   *   <li>Given {@link UserRepository} {@link CrudRepository#findById(Object)}
   * return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MongoUserDetailsService#loadUserByUsername(String)}
   */
  @Test
  public void testLoadUserByUsername_givenUserRepositoryFindByIdReturnEmpty() throws UsernameNotFoundException {
    // Arrange
    Optional<User> emptyResult = Optional.empty();
    when(userRepository.findById(Mockito.<String>any())).thenReturn(emptyResult);

    // Act and Assert
    thrown.expect(UsernameNotFoundException.class);
    mongoUserDetailsService.loadUserByUsername("janedoe");
    verify(userRepository).findById(eq("janedoe"));
  }
}
