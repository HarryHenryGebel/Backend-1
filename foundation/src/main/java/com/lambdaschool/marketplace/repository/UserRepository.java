package com.lambdaschool.marketplace.repository;

import com.lambdaschool.marketplace.models.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The CRUD repository connecting User to the rest of the application
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  /**
   * Find a user based on their primary email
   *
   * @param primaryEmail the name (String) of user you seek
   * @return the first user object with the name you seek
   */
  User findByPrimaryEmail(String primaryEmail);

  /**
   * Find all users whose primary email contains a given substring. All emails
   * are stored as lower case, so ignoring case is not necessary, and could mask
   * an error that allowed the email to be set incorrectly.
   *
   * @param primaryEmail the substring of the names (String) you seek
   * @return List of users whose primaryEmail contain the given substring ignoring case
   */
  List<User> findByPrimaryEmailContaining(String primaryEmail);

  /**
   * Find all users whose real name matches a string
   *
   * @param name The name of the user to look up
   * @return The first user with that name
   */
  User findByName(String name);

  /**
   * Find all users whose real name contains a given substring, ignoring case
   *
   * @param name the substring to look up
   * @return List of users matching search
   */
  List<User> findByNameContainingIgnoreCase(String name);
}
