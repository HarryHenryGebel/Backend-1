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
public class SubcategoryServiceImplTest {

    @Autowired
    private SubcategoryService subcategoryService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void A_findAllSubcategories() {
        assertEquals(42, subcategoryService.findAllSubcategories().size());
    }

    @Test
    public void B_findBySubcategoryId() {
        assertEquals("Livestock", subcategoryService.findBySubcategoryId(2).getName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void BB_findBySubcategoryIdNotFound(){
        assertEquals("", subcategoryService.findBySubcategoryId(999999).getName());
    }

    @Test
    public void C_delete() {
        subcategoryService.delete(1);
        assertEquals(41,subcategoryService.findAllSubcategories().size());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void CC_deleteByIdNotFound() {
        subcategoryService.delete(99999);
        assertEquals("", subcategoryService.findBySubcategoryId(999999).getName());
    }

    @Test
    public void deleteAll() {
        subcategoryService.deleteAll();
        assertEquals(0, subcategoryService.findAllSubcategories().size());
    }
}