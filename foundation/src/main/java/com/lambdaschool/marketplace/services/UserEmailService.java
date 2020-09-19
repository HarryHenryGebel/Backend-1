package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.models.UserEmail;
import java.util.List;

/**
 * The Service that works with the UserEmail Model
 * <p>
 * Note: Emails are added through the add user process
 */
public interface UserEmailService {
  /**
   * Returns a list of all users and their emails
   *
   * @return List of users and their emails
   */
  List<UserEmail> findAll();

  /**
   * Returns the user email combination associated with the given id
   *
   * @param id The primary key (long) of the user email combination you seek
   * @return The user email combination (UserEmail) you seek
   */
  UserEmail findUserEmailById(long id);

  /**
   * Remove the user email combination referenced by the given id
   *
   * @param id The primary key (long) of the user email combination you seek
   */
  void delete(long id);

  /**
   * Replaces the email of the user email combination you seek
   *
   * @param userEmailId  The primary key (long) of the user email combination you seek
   * @param emailAddress The new email address (String) for this user email combination
   * @return The UserEmail object that you updated including the new email address
   */
  UserEmail update(long userEmailId, String emailAddress);

  /**
   * Add a new User Email combination
   *
   * @param userid       the userid of the new user email combination
   * @param emailAddress the email address of the new user email combination
   * @return the new user email combination
   */
  UserEmail save(long userid, String emailAddress);
}
