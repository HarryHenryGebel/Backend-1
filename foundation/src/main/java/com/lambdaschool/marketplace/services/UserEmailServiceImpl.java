package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.models.UserEmail;
import com.lambdaschool.marketplace.repository.UserEmailRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements the UserEmailService Interface
 */
@Transactional
@Service(value = "userEmailService")
public class UserEmailServiceImpl implements UserEmailService {
  /**
   * Connects this service to the UserEmail model
   */
  private final UserEmailRepository userEmailRepository;

  /**
   * Connects this service to the User Service
   */
  private final UserService userService;

  private final HelperFunctions helperFunctions;

  public UserEmailServiceImpl(UserEmailRepository userEmailRepository, UserService userService, HelperFunctions helperFunctions) {
    this.userEmailRepository = userEmailRepository;
    this.userService = userService;
    this.helperFunctions = helperFunctions;
  }

  @Override
  public List<UserEmail> findAll() {
    List<UserEmail> list = new ArrayList<>();
    /*
     * findAll returns an iterator set.
     * iterate over the iterator set and add each element to an array list.
     */
    userEmailRepository.findAll().iterator().forEachRemaining(list::add);
    return list;
  }

  @Override
  public UserEmail findUserEmailById(long id) {
    return userEmailRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            "UserEmail with id " + id + " Not Found!"
          )
      );
  }

  @Transactional
  @Override
  public void delete(long id) {
    if (userEmailRepository.findById(id).isPresent()) {
      if (
        helperFunctions.isAuthorizedToMakeChange(
          userEmailRepository.findById(id).get().getUser().getUsername()
        )
      ) {
        userEmailRepository.deleteById(id);
      }
    } else {
      throw new ResourceNotFoundException(
        "UserEmail with id " + id + " Not Found!"
      );
    }
  }

  @Transactional
  @Override
  public UserEmail update(long userEmailId, String emailAddress) {
    if (userEmailRepository.findById(userEmailId).isPresent()) {
      if (
        helperFunctions.isAuthorizedToMakeChange(
          userEmailRepository.findById(userEmailId).get().getUser().getUsername()
        )
      ) {
        UserEmail useremail = findUserEmailById(userEmailId);
        useremail.setUserEmail(emailAddress.toLowerCase());
        return userEmailRepository.save(useremail);
      } else {
        // note we should never get to this line but is needed for the compiler
        // to recognize that this exception can be thrown
        throw new ResourceNotFoundException(
          "This user is not authorized to make change"
        );
      }
    } else {
      throw new ResourceNotFoundException(
        "UserEmail with id " + userEmailId + " Not Found!"
      );
    }
  }

  @Transactional
  @Override
  public UserEmail save(long userid, String emailAddress) {
    User currentUser = userService.findUserById(userid);

    if (helperFunctions.isAuthorizedToMakeChange(currentUser.getUsername())) {
      UserEmail newUserEmail = new UserEmail(currentUser, emailAddress);
      return userEmailRepository.save(newUserEmail);
    } else {
      // note we should never get to this line but is needed for the compiler
      // to recognize that this exception can be thrown
      throw new ResourceNotFoundException(
        "This user is not authorized to make change"
      );
    }
  }
}
