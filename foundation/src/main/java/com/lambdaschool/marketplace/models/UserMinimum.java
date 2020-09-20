package com.lambdaschool.marketplace.models;

import javax.validation.constraints.Email;

/**
 * A model used to create a new user. The minimum information needed to create a user.
 * Note the role will default to USER.
 */
public class UserMinimum {
  /**
   * The user's password (String)
   */
  private String password;

  /**
   * The user's primary email address (String)
   */
  @Email
  private String primaryEmail;

  /**
   * Return username - username is synonymous with email, so return email
   * @return the user's email, which functions as their email
   */
  public String getUsername() {
    return primaryEmail;
  }

  /**
   * Getter for the password of this user
   *
   * @return the password (String) for this user
   */
  public String getPassword() {
    return password;
  }

  /**
   * Setter for the password of this user. This object is a temporary model used to create a new user.
   * The password must remain in clear text until saved into the database.
   *
   * @param password the new password (String in clear texts) for this user
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Getter for email for this user
   *
   * @return the email address (String) for this user
   */
  public String getPrimaryEmail() {
    return primaryEmail;
  }

  /**
   * Setter for email for this user
   *
   * @param primaryEmail the new email address (String) for this user.
   */
  public void setPrimaryEmail(String primaryEmail) {
    this.primaryEmail = primaryEmail;
  }
}
