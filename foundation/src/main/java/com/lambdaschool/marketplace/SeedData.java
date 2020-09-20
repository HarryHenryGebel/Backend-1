package com.lambdaschool.marketplace;

import com.lambdaschool.marketplace.models.Role;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.models.UserEmail;
import com.lambdaschool.marketplace.models.UserRole;
import com.lambdaschool.marketplace.services.RoleService;
import com.lambdaschool.marketplace.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * SeedData puts both known and random data into the database. It implements CommandLineRunner.
 * <p>
 * CommandLineRunner: Spring Boot automatically runs the run method once and only once
 * after the application context has been loaded.
 */
@Transactional
@Component
public class SeedData implements CommandLineRunner {
  /**
   * Connects the Role Service to this process
   */
  final RoleService roleService;

  /**
   * Connects the user service to this process
   */
  final UserService userService;

  public SeedData(RoleService roleService, UserService userService) {
    this.roleService = roleService;
    this.userService = userService;
  }

  /**
   * Generates test, seed data for our application
   * First a set of known data is seeded into our database.
   * Second a random set of data using Java Faker is seeded into our database.
   * Note this process does not remove data from the database. So if data exists in the database
   * prior to running this process, that data remains in the database.
   *
   * @param args The parameter is required by the parent interface but is not used in this process.
   */
  @Transactional
  @Override
  public void run(String[] args) {
    userService.deleteAll();
    roleService.deleteAll();
    Role r1 = new Role("admin");
    Role r2 = new Role("user");
    Role r3 = new Role("data");

    r1 = roleService.save(r1);
    r2 = roleService.save(r2);
    r3 = roleService.save(r3);

    // admin, data, user
    User u1 = new User("password", "admin@lambdaschool.local", "Admin");
    u1.getRoles().add(new UserRole(u1, r1));
    u1.getRoles().add(new UserRole(u1, r2));
    u1.getRoles().add(new UserRole(u1, r3));
    u1.getUserEmails().add(new UserEmail(u1, "admin@email.local"));
    u1.getUserEmails().add(new UserEmail(u1, "admin@mymail.local"));

    userService.save(u1);

    // data, user
    User u2 = new User("1234567", "cinnamon@lambdaschool.local", "Cinnamon");
    u2.getRoles().add(new UserRole(u2, r2));
    u2.getRoles().add(new UserRole(u2, r3));
    u2.getUserEmails().add(new UserEmail(u2, "cinnamon@mymail.local"));
    u2.getUserEmails().add(new UserEmail(u2, "hops@mymail.local"));
    u2.getUserEmails().add(new UserEmail(u2, "bunny@email.local"));
    userService.save(u2);

    // user
    User u3 = new User("ILuvM4th!", "barnbarn@lambdaschool.local", "Barn Barn");
    u3.getRoles().add(new UserRole(u3, r2));
    u3.getUserEmails().add(new UserEmail(u3, "barnbarn@email.local"));
    userService.save(u3);

    User u4 = new User("password", "puttat@school.lambda", "P. Uttat");
    u4.getRoles().add(new UserRole(u4, r2));
    userService.save(u4);

    User u5 = new User("password", "misskitty@school.lambda", "Miss Kitty");
    u5.getRoles().add(new UserRole(u5, r2));
    userService.save(u5);
  }
}
