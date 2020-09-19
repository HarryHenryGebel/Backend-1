package com.lambdaschool.marketplace.controllers;

import com.lambdaschool.marketplace.models.UserEmail;
import com.lambdaschool.marketplace.services.UserEmailService;
import java.net.URI;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * The entry point for client to access user, email combinations
 */
@RestController
@RequestMapping("/user_emails")
public class UserEmailController {
  /**
   * Using the UserEmail service to process user, email combinations data
   */
  private final UserEmailService userEmailService;

  public UserEmailController(UserEmailService userEmailService) {
    this.userEmailService = userEmailService;
  }

  /**
   * List of all users emails
   * <br>Example: <a href="http://localhost:2019/user_emails/user_emails">http://localhost:2019/user_emails/user_emails</a>
   *
   * @return JSON list of all users emails
   */
  @GetMapping(value = "/user_emails", produces = "application/json")
  public ResponseEntity<?> listAllUserEmails() {
    List<UserEmail> allUserEmails = userEmailService.findAll();
    return new ResponseEntity<>(allUserEmails, HttpStatus.OK);
  }

  /**
   * Return the user email combination referenced by the given primary key
   * <br>Example: <a href="http://localhost:2019/user_emails/user_email/8">http://localhost:2019/user_emails/user_email/8</a>
   *
   * @param userEmailId the primary key of the user email combination you seek
   * @return JSON object of the user email combination you seek with a status of OK
   */
  @GetMapping(
    value = "/user_email/{user_email_id}",
    produces = "application/json"
  )
  public ResponseEntity<?> getUserEmailById(@PathVariable Long userEmailId) {
    UserEmail ue = userEmailService.findUserEmailById(userEmailId);
    return new ResponseEntity<>(ue, HttpStatus.OK);
  }

  /**
   * Removes the given user email combination
   * <br>Example: <a href="http://localhost:2019/user_emails/user_email/8">http://localhost:2019/user_emails/user_email/8</a>
   *
   * @param userEmailId the primary key of the user email combination you wish to remove
   * @return Status of OK
   */
  @DeleteMapping(value = "/user_email/{user_email_id}")
  public ResponseEntity<?> deleteUserEmailById(@PathVariable long userEmailId) {
    userEmailService.delete(userEmailId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Change the email associated with the given user email combination
   * <br>Example: <a href="http://localhost:2019/user_emails/user_email/9/email/favbun@hops.local">http://localhost:2019/user_emails/user_email/9/email/favbun@hops.local</a>
   *
   * @param userEmailId  The primary key of the user email combination you wish to change
   * @param emailAddress The new email (String)
   * @return Status of OK
   */
  @PutMapping("/user_email/{user_email_id}/email/{email_address}")
  public ResponseEntity<?> updateUserEmail(
    @PathVariable long userEmailId,
    @PathVariable String emailAddress
  ) {
    userEmailService.update(userEmailId, emailAddress);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Adds a new user email combination
   *
   * @param userId       the user id of the new user email combination
   * @param emailAddress the email address of the new user email combination
   * @return A location header with the URI to the newly created user email combination and a status of CREATED
   * @see UserEmailService#save(long, String) UserEmailService.save(long, String)
   */
  @PostMapping(value = "/user/{userId}/email/{email_address}")
  public ResponseEntity<?> addNewUserEmail(
    @PathVariable long userId,
    @PathVariable String emailAddress
  ) {
    UserEmail newUserEmail = userEmailService.save(userId, emailAddress);

    // set the location header for the newly created resource
    HttpHeaders responseHeaders = new HttpHeaders();
    URI newUserEmailURI = ServletUriComponentsBuilder
      .fromCurrentServletMapping()
      .path("/user_emails/user_email/{user_email_id}")
      .buildAndExpand(newUserEmail.getUserEmailId())
      .toUri();
    responseHeaders.setLocation(newUserEmailURI);

    return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
  }
}
