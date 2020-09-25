package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.UserModelApplication;
import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void A_getProductCategoryList() {
        assertEquals(118, productService.getProductCategoryList().size());
    }

    @Test
    public void B_findAllProducts() {
        assertEquals(118, productService.findAllProducts().size());
    }

    @Test
    public void C_findByProductId() {
        assertEquals("Eggs", productService.findByProductId(1).getName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void CC_findByProductIdNotFound() {
        assertEquals("", productService.findByProductId(999999).getName());
    }

    @Test
    public void D_delete() {
        productService.delete(1);
        assertEquals(117, productService.findAllProducts().size());
    }

    @Test
    public void E_deleteAll() {
        productService.deleteAll();
        assertEquals(0, productService.findAllProducts().size());
    }
}