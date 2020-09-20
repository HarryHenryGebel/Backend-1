package com.lambdaschool.marketplace.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.marketplace.models.Role;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.models.UserEmail;
import com.lambdaschool.marketplace.models.UserRoles;
import com.lambdaschool.marketplace.services.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// mocking service to test controller

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser(username = "admin", roles = { "USER", "ADMIN" })
public class UserControllerUnitTest {
  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  private List<User> userList;

  @Before
  public void setUp() {
    userList = new ArrayList<>();

    Role r1 = new Role("admin");
    r1.setRoleId(1);
    Role r2 = new Role("user");
    r2.setRoleId(2);
    Role r3 = new Role("data");
    r3.setRoleId(3);

    // admin, data, user
    User u1 = new User("ILuvM4th!", "admin@lambdaschool.local", "Adimn");
    u1.getRoles().add(new UserRoles(u1, r1));
    u1.getRoles().add(new UserRoles(u1, r2));
    u1.getRoles().add(new UserRoles(u1, r3));

    u1.getUserEmails().add(new UserEmail(u1, "admin@email.local"));
    u1.getUserEmails().get(0).setUserEmailId(10);

    u1.getUserEmails().add(new UserEmail(u1, "admin@mymail.local"));
    u1.getUserEmails().get(1).setUserEmailId(11);

    u1.setUserId(101);
    userList.add(u1);

    // data, user
    User u2 = new User("1234567", "cinnamon@lambdaschool.local", "Cinnamon");
    u1.getRoles().add(new UserRoles(u2, r2));
    u1.getRoles().add(new UserRoles(u2, r3));

    u2.getUserEmails().add(new UserEmail(u2, "cinnamon@mymail.local"));
    u2.getUserEmails().get(0).setUserEmailId(20);

    u2.getUserEmails().add(new UserEmail(u2, "hops@mymail.local"));
    u2.getUserEmails().get(1).setUserEmailId(21);

    u2.getUserEmails().add(new UserEmail(u2, "bunny@email.local"));
    u2.getUserEmails().get(2).setUserEmailId(22);

    u2.setUserId(102);
    userList.add(u2);

    // user
    User u3 = new User("ILuvM4th!", "testingbarn@school.lambda", "Test I. Barn");
    u3.getRoles().add(new UserRoles(u3, r1));

    u3.getUserEmails().add(new UserEmail(u3, "barnbarn@email.local"));
    u3.getUserEmails().get(0).setUserEmailId(30);

    u3.setUserId(103);
    userList.add(u3);

    User u4 = new User("password", "testingcat@school.lambda", "Mrs. T. Cat");
    u4.getRoles().add(new UserRoles(u4, r2));

    u4.setUserId(104);
    userList.add(u4);

    User u5 = new User("password", "testingdog@school.lambda", "Mr. T. I. Dog");
    u4.getRoles().add(new UserRoles(u5, r2));

    u5.setUserId(105);
    userList.add(u5);

    System.out.println("\n*** Seed Data ***");
    for (User u : userList) {
      System.out.println(u);
    }
    System.out.println("*** Seed Data ***\n");

    RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

    mockMvc =
      MockMvcBuilders
        .webAppContextSetup(webApplicationContext)
        .apply(SecurityMockMvcConfigurers.springSecurity())
        .build();
  }

  @After
  public void tearDown() {}

  @Test
  public void listAllUsers() throws Exception {
    String apiUrl = "/users/users";

    Mockito.when(userService.findAll()).thenReturn(userList);

    RequestBuilder rb = MockMvcRequestBuilders
      .get(apiUrl)
      .accept(MediaType.APPLICATION_JSON);

    // the following actually performs a real controller call
    MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
    String tr = r.getResponse().getContentAsString();

    ObjectMapper mapper = new ObjectMapper();
    String er = mapper.writeValueAsString(userList);

    System.out.println("Expect: " + er);
    System.out.println("Actual: " + tr);

    assertEquals("Rest API Returns List", er, tr);
  }

  @Test
  public void listUsersNameContaining() throws Exception {
    String apiUrl = "/users/user/name/like/cin";

    Mockito
      .when(userService.findByNameContaining(any(String.class)))
      .thenReturn(userList);

    RequestBuilder rb = MockMvcRequestBuilders
      .get(apiUrl)
      .accept(MediaType.APPLICATION_JSON);

    // the following actually performs a real controller call
    MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
    String tr = r.getResponse().getContentAsString();

    ObjectMapper mapper = new ObjectMapper();
    String er = mapper.writeValueAsString(userList);

    System.out.println("Expect: " + er);
    System.out.println("Actual: " + tr);

    assertEquals("Rest API Returns List", er, tr);
  }

  @Test
  public void getUserById() throws Exception {
    String apiUrl = "/users/user/12";

    Mockito.when(userService.findUserById(12)).thenReturn(userList.get(1));

    RequestBuilder rb = MockMvcRequestBuilders
      .get(apiUrl)
      .accept(MediaType.APPLICATION_JSON);
    MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
    String tr = r.getResponse().getContentAsString();

    ObjectMapper mapper = new ObjectMapper();
    String er = mapper.writeValueAsString(userList.get(1));

    System.out.println("Expect: " + er);
    System.out.println("Actual: " + tr);

    assertEquals("Rest API Returns List", er, tr);
  }

  @Test
  public void getUserByIdNotFound() throws Exception {
    String apiUrl = "/users/user/77";

    Mockito.when(userService.findUserById(77)).thenReturn(null);

    RequestBuilder rb = MockMvcRequestBuilders
      .get(apiUrl)
      .accept(MediaType.APPLICATION_JSON);
    MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
    String tr = r.getResponse().getContentAsString();

    String er = "";

    System.out.println("Expect: " + er);
    System.out.println("Actual: " + tr);

    assertEquals("Rest API Returns List", er, tr);
  }

  @Test
  public void getUserByName() throws Exception {
    String apiUrl = "/users/user/name/testing";

    Mockito.when(userService.findByName("testing")).thenReturn(userList.get(0));

    RequestBuilder rb = MockMvcRequestBuilders
      .get(apiUrl)
      .accept(MediaType.APPLICATION_JSON);
    MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
    String tr = r.getResponse().getContentAsString();

    ObjectMapper mapper = new ObjectMapper();
    String er = mapper.writeValueAsString(userList.get(0));

    System.out.println("Expect: " + er);
    System.out.println("Actual: " + tr);

    assertEquals("Rest API Returns List", er, tr);
  }

  @Test
  public void getUserInfo() throws Exception {
    String apiUrl = "/users/get_user_info";

    Mockito
      .when(userService.findByName(anyString()))
      .thenReturn(userList.get(0));

    RequestBuilder rb = MockMvcRequestBuilders
      .get(apiUrl)
      .accept(MediaType.APPLICATION_JSON);
    MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
    String tr = r.getResponse().getContentAsString();

    ObjectMapper mapper = new ObjectMapper();
    String er = mapper.writeValueAsString(userList.get(0));

    System.out.println("Expect: " + er);
    System.out.println("Actual: " + tr);

    assertEquals("Rest API Returns List", er, tr);
  }

  @Test
  public void addNewUser() throws Exception {
    String apiUrl = "/users/user";

    // build a user
    User u1 = new User();
    u1.setUserId(100);
    u1.setPassword("ILuvM4th!");
    u1.setPrimaryEmail("tiger@home.local");

    ObjectMapper mapper = new ObjectMapper();
    String userString = mapper.writeValueAsString(u1);

    Mockito.when(userService.save(any(User.class))).thenReturn(u1);

    RequestBuilder rb = MockMvcRequestBuilders
      .post(apiUrl)
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON)
      .content(userString);

    mockMvc
      .perform(rb)
      .andExpect(status().isCreated())
      .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void updateUser() throws Exception {
    String apiUrl = "/users/user/{userid}";

    // build a user
    User u1 = new User();
    u1.setUserId(100);
    u1.setPrimaryEmail("home@local.home");
    u1.setPassword("ILuvM4th!");

    Mockito.when(userService.update(u1, 100)).thenReturn(userList.get(0));

    ObjectMapper mapper = new ObjectMapper();
    String userString = mapper.writeValueAsString(u1);

    RequestBuilder rb = MockMvcRequestBuilders
      .put(apiUrl, 100L)
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON)
      .content(userString);

    mockMvc
      .perform(rb)
      .andExpect(status().is2xxSuccessful())
      .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void deleteUserById() throws Exception {
    String apiUrl = "/users/user/{userid}";

    RequestBuilder rb = MockMvcRequestBuilders
      .delete(apiUrl, "3")
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON);
    mockMvc
      .perform(rb)
      .andExpect(status().is2xxSuccessful())
      .andDo(MockMvcResultHandlers.print());
  }
}
