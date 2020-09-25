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

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void A_findAllCategories() {
        assertEquals(11, categoryService.findAllCategories().size());
    }

    @Test
    public void B_findByCategoryId() {
        assertEquals("Beans", categoryService.findByCategoryId(2).getName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void BB_findByCategoryIdNotFound() {
        assertEquals("", categoryService.findByCategoryId(999999).getName());
    }

    @Test
    public void C_save() {
    }

    @Test
    public void D_delete() {
        categoryService.delete(1);
        assertEquals(10, categoryService.findAllCategories().size());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void DD_deleteByIdNotFound() {
        categoryService.delete(999999);
        assertEquals("", categoryService.findByCategoryId(999999).getName());
    }

    @Test
    public void E_deleteAll() {
        categoryService.deleteAll();
        assertEquals(0,categoryService.findAllCategories().size());
    }
}