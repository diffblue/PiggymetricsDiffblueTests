package com.piggymetrics.auth.service;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {UserServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplDiffblueTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @MockBean
  private UserRepository userRepository;

  @Autowired
  private UserServiceImpl userServiceImpl;
  /**
  * Method under test: {@link UserServiceImpl#create(User)}
  */
  @Test
  public void testCreate() {
    // Arrange
    User user = new User();
    user.setPassword("iloveyou");
    user.setUsername("janedoe");

    User user1 = new User();
    user1.setPassword("iloveyou");
    user1.setUsername("janedoe");
    Optional<User> ofResult = Optional.of(user1);
    when(this.userRepository.save((User) any())).thenReturn(user);
    when(this.userRepository.findById((String) any())).thenReturn(ofResult);

    User user2 = new User();
    user2.setPassword("iloveyou");
    user2.setUsername("janedoe");

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    this.userServiceImpl.create(user2);
    verify(this.userRepository).findById((String) any());
  }

  /**
   * Method under test: {@link UserServiceImpl#create(User)}
   */
  @Test
  public void testCreate2() {
    // Arrange
    User user = new User();
    user.setPassword("iloveyou");
    user.setUsername("janedoe");
    when(this.userRepository.save((User) any())).thenReturn(user);
    when(this.userRepository.findById((String) any())).thenReturn(Optional.empty());

    User user1 = new User();
    user1.setPassword("iloveyou");
    user1.setUsername("janedoe");

    // Act
    this.userServiceImpl.create(user1);

    // Assert
    verify(this.userRepository).save((User) any());
    verify(this.userRepository).findById((String) any());
  }

  /**
   * Method under test: {@link UserServiceImpl#create(User)}
   */
  @Test
  public void testCreate3() {
    // Arrange
    when(this.userRepository.save((User) any()))
        .thenThrow(new IllegalArgumentException("new user has been created: {}"));
    when(this.userRepository.findById((String) any()))
        .thenThrow(new IllegalArgumentException("new user has been created: {}"));

    User user = new User();
    user.setPassword("iloveyou");
    user.setUsername("janedoe");

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    this.userServiceImpl.create(user);
    verify(this.userRepository).findById((String) any());
  }
}

