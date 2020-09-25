package com.lambdaschool.marketplace.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.marketplace.services.ProductService;
import com.lambdaschool.marketplace.views.ProductCategoryList;
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
public class ProductControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private List<ProductCategoryList> productCategoryList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

//        ProductCategoryList m1 = new ProductCategoryList();
//        m1.setMarketId(10);
//        productCategoryList.add(m1);

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
    public void getProductCategoryList() throws Exception {
//        this.mockMvc.perform(get("/products"))
        String apiURL = "/products";

        Mockito.when(productService.getProductCategoryList()).thenReturn(productCategoryList);

        RequestBuilder rb = MockMvcRequestBuilders
                .get(apiURL)
                .accept(MediaType.APPLICATION_JSON);

        // the following actually performs a real controller call
        MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(productCategoryList);

        System.out.println("Expect: " + er);
        System.out.println("Actual: " + tr);

        assertEquals("Rest API Returns List", er, tr);
    }
}