package com.lambdaschool.marketplace.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.marketplace.models.Item;
import com.lambdaschool.marketplace.models.Role;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.models.UserRole;
import com.lambdaschool.marketplace.services.ItemService;
import com.lambdaschool.marketplace.services.MarketService;
import com.lambdaschool.marketplace.services.ProductService;
import com.lambdaschool.marketplace.services.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser(username = "jill@anaddress.com", roles = { "USER", "ADMIN" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @MockBean
    private UserService userService;

    @Autowired
    private MarketService marketService;

    @Autowired
    private ProductService productService;

    private List<Item> itemList = new ArrayList<>();

    private List<User> userList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        Role r1 = new Role("admin");
        r1.setRoleId(1);
        Role r2 = new Role("user");
        r2.setRoleId(2);

        User u1 = new User("password", "jill@anaddress.com", "Jill");
        u1.getRoles().add(new UserRole(u1, r1));
        u1.getRoles().add(new UserRole(u1, r2));
        u1.setUserId(1);
        userList.add(u1);

        User u2 = new User("password", "jack@anaddress.com", "Jack");
        u2.getRoles().add(new UserRole(u2, r2));
        u2.setUserId(2);
        userList.add(u2);

        Item newItem = new Item(
                "Item name",
                "Item description",
                9.05
        );

        newItem.setUser(u1);
        newItem.setMarket(marketService.findByMarketId(1));
        newItem.setProduct(productService.findByProductId(1));

        newItem.setItemId(10);

        itemList.add(newItem);

        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

        mockMvc =
                MockMvcBuilders
                        .webAppContextSetup(webApplicationContext)
                        .apply(SecurityMockMvcConfigurers.springSecurity())
                        .build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void A_findAllItems() throws Exception {
        String apiURL = "/items";

        Mockito.when(itemService.findAllItems()).thenReturn(itemList);

        RequestBuilder rb = MockMvcRequestBuilders
                .get(apiURL)
                .accept(MediaType.APPLICATION_JSON);

        // the following actually performs a real controller call
        MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(itemList);

        System.out.println("Expect: " + er);
        System.out.println("Actual: " + tr);

        assertEquals("Rest API Returns List", er, tr);
    }

    @WithMockUser(username = "jill@anaddress.com")
    @Test
    public void B_findByUserId() throws Exception{
        String apiURL = "/user/items";

        Mockito.when(userService.findByName("jill@anaddress.com")).thenReturn(userList.get(0));
        Mockito.when(itemService.findByUserId(1)).thenReturn(itemList);

        RequestBuilder rb = MockMvcRequestBuilders
                .get(apiURL)
                .accept(MediaType.APPLICATION_JSON);

        // the following actually performs a real controller call
        MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(itemList);

        System.out.println("Expect: " + er);
        System.out.println("Actual: " + tr);

        assertEquals("Rest API Returns List", er, tr);
    }

    @Test
    public void C_getItemById() throws Exception {
        String apiURL = "/item/10";

        Mockito.when(itemService.findItemById(10)).thenReturn(itemList.get(0));

        RequestBuilder rb = MockMvcRequestBuilders
                .get(apiURL)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(itemList.get(0));

        System.out.println("Expect: " + er);
        System.out.println("Actual: " + tr);

        assertEquals("Rest API Returns List", er, tr);
    }

    @Test
    public void D_addNewItem() throws Exception {
        String apiURL = "/item";

        Item newItem = new Item();

        newItem.setUser(userList.get(0));
        newItem.setName("New Item");
        newItem.setDescription("New item description.");
        newItem.setPrice(9.05);
        newItem.setMarket(marketService.findByMarketId(1));
        newItem.setProduct(productService.findByProductId(2));
        newItem.setItemId(0);

        ObjectMapper mapper = new ObjectMapper();
        String itemString = mapper.writeValueAsString(newItem);

        Mockito.when(itemService.save(any(Item.class))).thenReturn(newItem);

        RequestBuilder rb = MockMvcRequestBuilders
                .post(apiURL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(itemString);

        mockMvc
                .perform(rb)
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @WithMockUser(username = "jill@anaddress.com")
    @Test
    public void E_updateItem() throws Exception {
        String apiURL = "/item/10";

        Mockito.when(userService.findByName("Jill")).thenReturn(userList.get(0));

        Item newItem = new Item();

        newItem.setUser(userList.get(0));
        newItem.setName("New Item");
        newItem.setDescription("New item description.");
        newItem.setPrice(9.05);
        newItem.setMarket(marketService.findByMarketId(1));
        newItem.setProduct(productService.findByProductId(2));
        newItem.setItemId(0);

        ObjectMapper mapper = new ObjectMapper();
        String itemString = mapper.writeValueAsString(newItem);

        Mockito.when(itemService.update(newItem, 10)).thenReturn(itemList.get(0));

        RequestBuilder rb = MockMvcRequestBuilders
                .patch(apiURL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(itemString);

        mockMvc
                .perform(rb)
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void F_deleteItemById() throws Exception {
        String apiURL = "/item/10";

        Mockito.when(userService.findByName("Jill")).thenReturn(userList.get(0));

        RequestBuilder rb = MockMvcRequestBuilders
                .delete(apiURL, 10)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc
                .perform(rb)
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }
}