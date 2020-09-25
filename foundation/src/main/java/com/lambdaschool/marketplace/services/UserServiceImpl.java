package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Role;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.models.UserEmail;
import com.lambdaschool.marketplace.models.UserRole;
import com.lambdaschool.marketplace.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.lambdaschool.marketplace.Utility.optionallyReplace;

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

  public UserServiceImpl(
    UserRepository userRepository,
    RoleService roleService,
    HelperFunctions helperFunctions
  ) {
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
    return userRepository.findByPrimaryEmailContaining(username.toLowerCase());
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
    findUserById(id); // check for id existence
    userRepository.deleteById(id);
  }

  @Override
  public User findByName(String name) {
    User uu = userRepository.findByName(name.toLowerCase());
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

    newUser.setPasswordNoEncrypt(user.getPassword());
    newUser.setPrimaryEmail(user.getPrimaryEmail());
    newUser.setName(user.getName());

    Set<UserRole> roles = newUser.getRoles();
    for (UserRole role : user.getRoles()) {
      Role addRole = roleService.findRoleById(role.getRole().getRoleId());
      roles.add(new UserRole(newUser, addRole));
    }

    newUser.getUserEmails().clear();
    for (UserEmail userEmail : user.getUserEmails()) {
      newUser
        .getUserEmails()
        .add(new UserEmail(newUser, userEmail.getUserEmail()));
    }

    return userRepository.save(newUser);
  }

  @Transactional
  @Override
  public User update(User user, long id) {
    User currentUser = findUserById(id);

    // TODO Test this method call!!!!
    if (
      !helperFunctions.isAuthorizedToMakeChange(currentUser.getUsername())
    ) throw new ResourceNotFoundException( // to recognize that this exception can be thrown // note we should never get to this line but is needed for the compiler
      "This user is not authorized to make change"
    );

    if (user.getPassword() != null) {
      currentUser.setPasswordNoEncrypt(user.getPassword());
    }

    currentUser.setPrimaryEmail(
      (String) optionallyReplace(
        currentUser.getPrimaryEmail(),
        user.getPrimaryEmail()
      )
    );

    if (user.getRoles().size() > 0) {
      currentUser.getRoles().clear();
      for (UserRole role : user.getRoles()) {
        Role addRole = roleService.findRoleById(role.getRole().getRoleId());
        currentUser.getRoles().add(new UserRole(currentUser, addRole));
      }
    }

    if (user.getUserEmails().size() > 0) {
      currentUser.getUserEmails().clear();
      for (UserEmail userEmail : user.getUserEmails()) {
        currentUser
          .getUserEmails()
          .add(new UserEmail(currentUser, userEmail.getUserEmail()));
      }
    }

    return userRepository.save(currentUser);
  }

  @Transactional
  @Override
  public void deleteAll() {
    userRepository.deleteAll();
  }
}
