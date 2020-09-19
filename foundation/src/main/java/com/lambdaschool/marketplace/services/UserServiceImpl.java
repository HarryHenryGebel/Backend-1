package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Role;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.models.UserRoles;
import com.lambdaschool.marketplace.models.UserEmail;
import com.lambdaschool.marketplace.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements UserService Interface
 */
@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {
  /**
   * Connects this service to the User table.
   */
  private final UserRepository userRepository;

  /**
   * Connects this service to the Role table
   */
  private final RoleService roleService;

  private final HelperFunctions helperFunctions;

  public UserServiceImpl(UserRepository userRepository, RoleService roleService, HelperFunctions helperFunctions) {
    this.userRepository = userRepository;
    this.roleService = roleService;
    this.helperFunctions = helperFunctions;
  }

  public User findUserById(long id) throws ResourceNotFoundException {
    return userRepository
      .findById(id)
      .orElseThrow(
        () -> new ResourceNotFoundException("User id " + id + " not found!")
      );
  }

  @Override
  public List<User> findByNameContaining(String username) {
    return userRepository.findByUsernameContainingIgnoreCase(username.toLowerCase());
  }

  @Override
  public List<User> findAll() {
    List<User> list = new ArrayList<>();
    /*
     * findAll returns an iterator set.
     * iterate over the iterator set and add each element to an array list.
     */
    userRepository.findAll().iterator().forEachRemaining(list::add);
    return list;
  }

  @Transactional
  @Override
  public void delete(long id) {
    userRepository
      .findById(id)
      .orElseThrow(
        () -> new ResourceNotFoundException("User id " + id + " not found!")
      );
    userRepository.deleteById(id);
  }

  @Override
  public User findByName(String name) {
    User uu = userRepository.findByUsername(name.toLowerCase());
    if (uu == null) {
      throw new ResourceNotFoundException("User name " + name + " not found!");
    }
    return uu;
  }

  @Transactional
  @Override
  public User save(User user) {
    User newUser = new User();

    if (user.getUserId() != 0) {
      userRepository
        .findById(user.getUserId())
        .orElseThrow(
          () ->
            new ResourceNotFoundException(
              "User id " + user.getUserId() + " not found!"
            )
        );
      newUser.setUserId(user.getUserId());
    }

    newUser.setUsername(user.getUsername().toLowerCase());
    newUser.setPasswordNoEncrypt(user.getPassword());
    newUser.setPrimaryEmail(user.getPrimaryEmail().toLowerCase());

    newUser.getRoles().clear();
    for (UserRoles ur : user.getRoles()) {
      Role addRole = roleService.findRoleById(ur.getRole().getRoleId());
      newUser.getRoles().add(new UserRoles(newUser, addRole));
    }

    newUser.getUserEmails().clear();
    for (UserEmail ue : user.getUserEmails()) {
      newUser.getUserEmails().add(new UserEmail(newUser, ue.getUserEmail()));
    }

    return userRepository.save(newUser);
  }

  @Transactional
  @Override
  public User update(User user, long id) {
    User currentUser = findUserById(id);

    if (helperFunctions.isAuthorizedToMakeChange(currentUser.getUsername())) {
      if (user.getUsername() != null) {
        currentUser.setUsername(user.getUsername().toLowerCase());
      }

      if (user.getPassword() != null) {
        currentUser.setPasswordNoEncrypt(user.getPassword());
      }

      if (user.getPrimaryEmail() != null) {
        currentUser.setPrimaryEmail(user.getPrimaryEmail().toLowerCase());
      }

      if (user.getRoles().size() > 0) {
        currentUser.getRoles().clear();
        for (UserRoles ur : user.getRoles()) {
          Role addRole = roleService.findRoleById(ur.getRole().getRoleId());

          currentUser.getRoles().add(new UserRoles(currentUser, addRole));
        }
      }

      if (user.getUserEmails().size() > 0) {
        currentUser.getUserEmails().clear();
        for (UserEmail ue : user.getUserEmails()) {
          currentUser
            .getUserEmails()
            .add(new UserEmail(currentUser, ue.getUserEmail()));
        }
      }

      return userRepository.save(currentUser);
    } else {
      // note we should never get to this line but is needed for the compiler
      // to recognize that this exception can be thrown
      throw new ResourceNotFoundException(
        "This user is not authorized to make change"
      );
    }
  }

  @Transactional
  @Override
  public void deleteAll() {
    userRepository.deleteAll();
  }
}
