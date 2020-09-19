package com.lambdaschool.marketplace.services;

import static junit.framework.TestCase.assertEquals;

import com.lambdaschool.marketplace.UserModelApplication;
import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Role;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.models.UserEmail;
import com.lambdaschool.marketplace.models.UserRoles;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {
  @Autowired
  private UserService userService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @After
  public void tearDown() {}

  @Test
  public void B_findUserById() {
    assertEquals("admin", userService.findUserById(4).getUsername());
  }

  @Test(expected = ResourceNotFoundException.class)
  public void BA_findUserByIdNotFound() {
    assertEquals("admin", userService.findUserById(10).getUsername());
  }

  @Test
  public void C_findAll() {
    assertEquals(5, userService.findAll().size());
  }

  @Test
  public void D_delete() {
    userService.delete(13);
    assertEquals(4, userService.findAll().size());
  }

  @Test(expected = ResourceNotFoundException.class)
  public void DA_notFoundDelete() {
    userService.delete(100);
    assertEquals(4, userService.findAll().size());
  }

  @Test
  public void E_findByUsername() {
    assertEquals("admin", userService.findByName("admin").getUsername());
  }

  @Test(expected = ResourceNotFoundException.class)
  public void AA_findByUsernameNotFound() {
    assertEquals("admin", userService.findByName("turtle").getUsername());
  }

  @Test
  public void AB_findByNameContaining() {
    assertEquals(4, userService.findByNameContaining("a").size());
  }

  @Test
  public void F_save() {
    Role r2 = new Role("user");
    r2.setRoleId(2);

    User u2 = new User("ILuvMath!", "tiger@school.lambda");
    u2.getRoles().add(new UserRoles(u2, r2));
    u2.getUserEmails().add(new UserEmail(u2, "tiger@tiger.local"));

    User saveU2 = userService.save(u2);

    System.out.println("*** DATA ***");
    System.out.println(saveU2);
    System.out.println("*** DATA ***");

    assertEquals(
      "tiger@tiger.local",
      saveU2.getUserEmails().get(0).getUserEmail()
    );
  }

  @Transactional
  @WithUserDetails("cinnamon")
  @Test
  public void G_update() {
    Role r2 = new Role("user");
    r2.setRoleId(2);

    User u2 = new User("password", "cinnamon@school.lambda");
    u2.getRoles().add(new UserRoles(u2, r2));

    u2.getUserEmails().add(new UserEmail(u2, "cinnamon@mymail.thump"));
    u2.getUserEmails().add(new UserEmail(u2, "hops@mymail.thump"));
    u2.getUserEmails().add(new UserEmail(u2, "bunny@email.thump"));

    User updatedU2 = userService.update(u2, 7);

    System.out.println("*** DATA ***");
    System.out.println(updatedU2);
    System.out.println("*** DATA ***");

    int checking = updatedU2.getUserEmails().size() - 1;
    assertEquals(
      "bunny@email.thump",
      updatedU2.getUserEmails().get(checking).getUserEmail()
    );
  }

  @Transactional
  @WithUserDetails("cinnamon")
  @Test(expected = ResourceNotFoundException.class)
  public void GB_updateNotCurrentUserNorAdmin() {
    Role r2 = new Role("user");
    r2.setRoleId(2);

    User u2 = new User("password", "cinnamon@school.lambda");
    u2.getRoles().add(new UserRoles(u2, r2));
    u2.getUserEmails().add(new UserEmail(u2, "cinnamon@mymail.thump"));
    u2.getUserEmails().add(new UserEmail(u2, "hops@mymail.thump"));
    u2.getUserEmails().add(new UserEmail(u2, "bunny@email.thump"));

    User updatedU2 = userService.update(u2, 8);

    System.out.println("*** DATA ***");
    System.out.println(updatedU2);
    System.out.println("*** DATA ***");

    int checking = updatedU2.getUserEmails().size() - 1;
    assertEquals(
      "bunny@email.thump",
      updatedU2.getUserEmails().get(checking).getUserEmail()
    );
  }
}
