package com.lambdaschool.marketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

/**
 * The entity allowing interaction with the user_emails table
 * <p>
 * requires each combination of user and user_email to be unique. The same email cannot be assigned to the same user more than once.
 */
@Entity
@Table(name = "user_emails")
public class UserEmail extends Auditable {
  /**
   * The primary key (long) of the user_emails table
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long userEmailId;

  /**
   * Email (String) for this user. Cannot be nullable.
   * Must be in the format userid@domain.upperLevelDomain
   */
  @Column(nullable = false)
  @Email
  private String userEmail;

  /**
   * The userid of the user assigned to this email is what is stored in the database.
   * This is the entire user object!
   * <p>
   * Forms a Many to One relationship between user_emails and users.
   * A user can have many emails.
   */
  @ManyToOne
  @JoinColumn(name = "userid", nullable = false)
  @JsonIgnoreProperties(value = "userEmails", allowSetters = true)
  private User user;

  /**
   * The default controller is required by JPA
   */
  public UserEmail() {}

  /**
   * Given the parameters, create a new user_email object
   *
   * @param user      the user assigned to the email
   * @param userEmail primary email for the given user
   */
  public UserEmail(User user, String userEmail) {
    this.userEmail = userEmail;
    this.user = user;
  }

  /**
   * Getter for userEmailId
   *
   * @return the primary key of this userEmail object
   */
  public long getUserEmailId() {
    return userEmailId;
  }

  /**
   * Setter for userEmailId. Used for seeding data
   *
   * @param userEmailId the new primary key (long) of this userEmail object
   */
  public void setUserEmailId(long userEmailId) {
    this.userEmailId = userEmailId;
  }

  /**
   * Getter for userEmail
   *
   * @return the email (String) associated with this userEmail object in lowercase
   */
  public String getUserEmail() {
    return userEmail;
  }

  /**
   * Setter for userEmail
   *
   * @param userEmail the email (String) to replace the one currently assigned to this userEmail object, in lowercase
   */
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail.toLowerCase();
  }

  /**
   * Getter for user
   *
   * @return the user object associated with this userEmail.
   */
  public User getUser() {
    return user;
  }

  /**
   * Setter for user
   *
   * @param user the user object to replace the one currently assigned to this userEmail object
   */
  public void setUser(User user) {
    this.user = user;
  }
}
