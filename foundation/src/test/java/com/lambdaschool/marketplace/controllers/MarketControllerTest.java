package com.lambdaschool.marketplace.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.marketplace.models.Market;
import com.lambdaschool.marketplace.services.MarketService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser(username = "jill@anaddress.com", roles = { "USER", "ADMIN" })
public class MarketControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private MarketService marketService;

    private List<Market> marketList = new ArrayList<>();

//    private List<User> userList = new ArrayList<>();


    @Before
    public void setUp() throws Exception {
//        Role r1 = new Role("admin");
//        r1.setRoleId(1);
//        Role r2 = new Role("user");
//        r2.setRoleId(2);
//
//        User u1 = new User("password", "jill@anaddress.com", "Jill");
//        u1.getRoles().add(new UserRole(u1, r1));
//        u1.getRoles().add(new UserRole(u1, r2));
//        u1.setUserId(1);
//        userList.add(u1);
//
//        User u2 = new User("password", "jack@anaddress.com", "Jack");
//        u2.getRoles().add(new UserRole(u2, r2));
//        u2.setUserId(2);
//        userList.add(u2);

        Market m1 = new Market("Bujumbura");
        m1.setMarketId(10);
        marketList.add(m1);

        Market m2 = new Market("Gitega");
        m1.setMarketId(20);
        marketList.add(m2);

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

//    @WithMockUser(username = "jill@anaddress.com")
    @Test
    public void listAllMarkets() throws Exception {
        String apiURL = "/markets";

        Mockito.when(marketService.findAllMarkets()).thenReturn(marketList);

        RequestBuilder rb = MockMvcRequestBuilders
                .get(apiURL)
                .accept(MediaType.APPLICATION_JSON);

        // the following actually performs a real controller call
        MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(marketList);

        System.out.println("Expect: " + er);
        System.out.println("Actual: " + tr);

        assertEquals("Rest API Returns List", er, tr);
    }
}