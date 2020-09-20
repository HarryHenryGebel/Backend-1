package com.lambdaschool.marketplace.controllers;

import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.models.UserMinimum;
import com.lambdaschool.marketplace.models.UserRole;
import com.lambdaschool.marketplace.services.RoleService;
import com.lambdaschool.marketplace.services.UserService;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;

/**
 * The class allows access to endpoints that are open to all users regardless of authentication status.
 * Its most important function is to allow a person to create their own username
 */
@RestController
public class OpenController {
  /**
   * A method in this controller adds a new user to the application so needs access to User Services to do this.
   */
  private final UserService userService;

  /**
   * A method in this controller adds a new user to the application with the role User so needs access to Role Services to do this.
   */
  private final RoleService roleService;

  public OpenController(UserService userService, RoleService roleService) {
    this.userService = userService;
    this.roleService = roleService;
  }

  /**
   * This endpoint always anyone to create an account with the default role of USER. That role is hardcoded in this method.
   *
   * @param httpServletRequest the request that comes in for creating the new user
   * @param userMinimum         A special minimum set of data that is needed to create a new user
   * @return The token access and other relevant data to token access. Status of CREATED. The location header to look up the new user.
   */
  @SuppressWarnings("SpellCheckingInspection")
  @PostMapping(
    value = "/createnewuser",
    consumes = { "application/json" },
    produces = { "application/json" }
  )
  public ResponseEntity<?> addSelf(
    HttpServletRequest httpServletRequest,
    @Valid @RequestBody UserMinimum userMinimum
  ) {
    // Create the user
    User newUser = new User();

    newUser.setPassword(userMinimum.getPassword());
    newUser.setPrimaryEmail(userMinimum.getPrimaryEmail());

    // add the default role of user
    Set<UserRole> newRoles = new HashSet<>();
    newRoles.add(new UserRole(newUser, roleService.findByName("user")));
    newUser.setRoles(newRoles);

    newUser = userService.save(newUser);

    // set the location header for the newly created resource
    // The location comes from a different controller!
    HttpHeaders responseHeaders = new HttpHeaders();
    URI newUserURI = ServletUriComponentsBuilder
      .fromUriString(
        httpServletRequest.getServerName() +
        ":" +
        httpServletRequest.getLocalPort() +
        "/users/user/{userId}"
      )
      .buildAndExpand(newUser.getUserId())
      .toUri();
    responseHeaders.setLocation(newUserURI);

    // return the access token
    // To get the access token, surf to the endpoint /login just as if a client had done this.
    RestTemplate restTemplate = new RestTemplate();
    String requestURI =
      "http://" +
      httpServletRequest.getServerName() +
      ":" +
      httpServletRequest.getLocalPort() +
      "/login";

    List<MediaType> acceptableMediaTypes = new ArrayList<>();
    acceptableMediaTypes.add(MediaType.APPLICATION_JSON);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.setAccept(acceptableMediaTypes);
    headers.setBasicAuth(
      System.getenv("CLIENT_ID"),
      System.getenv("CLIENT_SECRET")
    );

    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("grant_type", "password");
    map.add("scope", "read write trust");
    map.add("username", userMinimum.getUsername());
    map.add("password", userMinimum.getPassword());

    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(
      map,
      headers
    );

    String theToken = restTemplate.postForObject(
      requestURI,
      request,
      String.class
    );

    return new ResponseEntity<>(theToken, responseHeaders, HttpStatus.CREATED);
  }

  /**
   * Prevents no favicon.ico warning from appearing in the logs. @ApiIgnore tells Swagger to ignore documenting this as an endpoint.
   */
  @ApiIgnore
  @GetMapping("favicon.ico")
  public void returnNoFavicon() {}
}
