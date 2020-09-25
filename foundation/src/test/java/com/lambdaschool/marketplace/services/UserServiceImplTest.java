package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.UserModelApplication;
import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Role;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.models.UserEmail;
import com.lambdaschool.marketplace.models.UserRole;
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

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

//        List<User> userList = userService.findAll();
//        for (User u : userList) {
//            System.out.println(u.getUserId() + " " + u.getUsername());
//        }

    }

    @After
    public void tearDown() throws Exception {
    }

//    @WithUserDetails("jill@anaddress.com")
    @Test
    public void A_findUserById() {
        assertEquals("Jack", userService.findUserById(2).getName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void AB_findUserByIdNotFound() {
        assertEquals("", userService.findUserById(999999).getName());
    }

    @Test
    public void B_findByNameContaining() {
        assertEquals(1, userService.findByNameContaining("jack").size());
    }

    @Test
    public void C_findAll() {
        assertEquals(3, userService.findAll().size());
    }

    @Test
    public void D_findByName() {
        List<User> userList = userService.findAll();
        for (User u : userList) {
            System.out.println(u.getUserId() + " " + "Username: " + u.getUsername() + " " + "Name: " + u.getName());
        }
        assertEquals(1, userService.findByNameContaining("Jack").size());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void DB_findByNameNotFound(){
        assertEquals("", userService.findByName("930892").getName());
    }

    @Test
    public void E_save() {
        Role role = new Role("user");
        role.setRoleId(2);


        String u4Name = "bugsbunnytest@school.lambda";
        User u4 = new User("password",
                "bugsbunnyTEST@school.lambda",
                "bugsbunnyTEST");
        u4.getRoles()
                .add(new UserRole(u4, role));
//        u4.setUserId(0);
        u4.getUserEmails()
                .add(new UserEmail(u4, "bugsbunnytest@school.lambda"));
        User addUser = userService.save(u4);
        assertNotNull(addUser);
        assertEquals(u4Name, addUser.getUserEmails().get(0).getUserEmail());
    }

    @Test
    public void EB_saveExistingUser() {
        String u4Name = "bugsbunnytest@school.lambda";
        User u4 = new User("password",
                "bugsbunnyTEST@school.lambda",
                "bugsbunnyTEST");
        Role role = new Role("turtle");
        role.setRoleId(2);
        u4.getRoles()
                .add(new UserRole(u4, role));
        u4.setUserId(2);
        User addUser = userService.save(u4);
        assertNotNull(addUser);
        assertEquals(u4Name, addUser.getPrimaryEmail());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void EBC_saveUserNotFound() {
        String u4Name = "bugsbunnytest@school.lambda";
        User u4 = new User("password",
                "bugsbunnyTEST@school.lambda",
                "bugsbunnyTEST");
        Role role = new Role("turtle");
        role.setRoleId(2);
        u4.getRoles()
                .add(new UserRole(u4, role));
        u4.setUserId(999999);
        User addUser = userService.save(u4);
        assertNotNull(addUser);
        assertEquals(u4Name, addUser.getPrimaryEmail());
    }

    @WithUserDetails("jill@anaddress.com")
    @Test
    public void F_update() {
        Role role = new Role("user");
        role.setRoleId(2);


        String u4Name = "bugstest@school.lambda";
        User u4 = new User("password",
                "bugsTEST@school.lambda",
                "bugsTEST");
        u4.getRoles()
                .add(new UserRole(u4, role));
        u4.getUserEmails()
                .add(new UserEmail(u4, "bugstest@school.lambda"));
        User updateUser = userService.update(u4, 3);
        assertNotNull(updateUser);
        assertEquals(u4Name, updateUser.getUserEmails().get(0).getUserEmail());
    }

    @WithUserDetails("tom@anaddress.com")
    @Test(expected = ResourceNotFoundException.class)
    public void FF_updateUserNotAuthorized() {
        Role role = new Role("user");
        role.setRoleId(2);


        String u4Name = "bugstest@school.lambda";
        User u4 = new User("password",
                "bugsTEST@school.lambda",
                "bugsTEST");
        u4.getRoles()
                .add(new UserRole(u4, role));
        u4.getUserEmails()
                .add(new UserEmail(u4, "bugstest@school.lambda"));
        User updateUser = userService.update(u4, 1);
        assertNotNull(updateUser);
        assertEquals(u4Name, updateUser.getUserEmails().get(0).getUserEmail());

    }

    @Test
    public void G_delete() {
        userService.delete(3);
        assertEquals(2, userService.findAll().size());

    }

    @Test
    public void H_deleteAll() {
        userService.deleteAll();
        assertEquals(0, userService.findAll().size());
    }
}