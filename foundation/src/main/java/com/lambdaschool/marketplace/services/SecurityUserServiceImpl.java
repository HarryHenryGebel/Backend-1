package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This implements User Details Service that allows us to authenticate a user.
 */
@Service(value = "securityUserService")
public class SecurityUserServiceImpl implements UserDetailsService {
  /**
   * Ties this implementation to the User Repository so we can find a user in the database.
   */
  private final UserRepository userRepository;

  public SecurityUserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Verifies that the user is correct and if so creates the authenticated user
   *
   * @param s The user name we are look for
   * @return a security user detail that is now an authenticated user
   * @throws ResourceNotFoundException if the user name is not found
   */
  @Transactional
  @Override
  public UserDetails loadUserByUsername(String s)
    throws ResourceNotFoundException {
    User user = userRepository.findByPrimaryEmail(s.toLowerCase());
    if (user == null) {
      throw new ResourceNotFoundException("Invalid username or password.");
    }
    return new org.springframework.security.core.userdetails.User(
      user.getUsername(),
      user.getPassword(),
      user.getAuthority()
    );
  }
}
