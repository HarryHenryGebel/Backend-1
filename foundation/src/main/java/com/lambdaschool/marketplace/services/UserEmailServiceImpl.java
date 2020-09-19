package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.models.UserEmail;
import com.lambdaschool.marketplace.repository.UserEmailRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements the UseremailService Interface
 */
@Transactional
@Service(value = "useremailService")
public class UseremailServiceImpl implements UseremailService {
  /**
   * Connects this service to the UserEmail model
   */
  @Autowired
  private UserEmailRepository useremailrepos;

  /**
   * Connects this servive to the User Service
   */
  @Autowired
  private UserService userService;

  @Autowired
  private HelperFunctions helperFunctions;

  @Override
  public List<UserEmail> findAll() {
    List<UserEmail> list = new ArrayList<>();
    /*
     * findAll returns an iterator set.
     * iterate over the iterator set and add each element to an array list.
     */
    useremailrepos.findAll().iterator().forEachRemaining(list::add);
    return list;
  }

  @Override
  public UserEmail findUseremailById(long id) {
    return useremailrepos
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
    if (useremailrepos.findById(id).isPresent()) {
      if (
        helperFunctions.isAuthorizedToMakeChange(
          useremailrepos.findById(id).get().getUser().getUsername()
        )
      ) {
        useremailrepos.deleteById(id);
      }
    } else {
      throw new ResourceNotFoundException(
        "UserEmail with id " + id + " Not Found!"
      );
    }
  }

  @Transactional
  @Override
  public UserEmail update(long useremailid, String emailaddress) {
    if (useremailrepos.findById(useremailid).isPresent()) {
      if (
        helperFunctions.isAuthorizedToMakeChange(
          useremailrepos.findById(useremailid).get().getUser().getUsername()
        )
      ) {
        UserEmail useremail = findUseremailById(useremailid);
        useremail.setUserEmail(emailaddress.toLowerCase());
        return useremailrepos.save(useremail);
      } else {
        // note we should never get to this line but is needed for the compiler
        // to recognize that this exception can be thrown
        throw new ResourceNotFoundException(
          "This user is not authorized to make change"
        );
      }
    } else {
      throw new ResourceNotFoundException(
        "UserEmail with id " + useremailid + " Not Found!"
      );
    }
  }

  @Transactional
  @Override
  public UserEmail save(long userid, String emailaddress) {
    User currentUser = userService.findUserById(userid);

    if (helperFunctions.isAuthorizedToMakeChange(currentUser.getUsername())) {
      UserEmail newUserEmail = new UserEmail(currentUser, emailaddress);
      return useremailrepos.save(newUserEmail);
    } else {
      // note we should never get to this line but is needed for the compiler
      // to recognize that this exception can be thrown
      throw new ResourceNotFoundException(
        "This user is not authorized to make change"
      );
    }
  }
}
