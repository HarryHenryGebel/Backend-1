package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.UserModelApplication;
import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Item;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemServiceImplTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private MarketService marketService;

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
    public void A_findByUserId() {
        assertEquals(1, itemService.findByUserId(1).size());
    }

    @Test
    public void B_findAllItems() {
        assertEquals(3, itemService.findAllItems().size());
    }

    @Test
    public void C_findItemById() {
        assertEquals("Egg Sale!", itemService.findItemById(1).getName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void CB_findItemByIdNotFound() {
        assertEquals("", itemService.findItemById(999999).getName());
    }

    @Test
    public void D_save() {
        Item newItem = new Item(
                "Item name",
                "Item description",
                9.05
        );

        newItem.setUser(userService.findUserById(1));
        newItem.setMarket(marketService.findByMarketId(1));
        newItem.setProduct(productService.findByProductId(1));

        Item addItem = itemService.save(newItem);
        assertNotNull(addItem);
        assertEquals(newItem.getName(), addItem.getName());
    }

    @WithUserDetails("jill@anaddress.com")
    @Test
    public void E_update() {
        Item newItem = new Item(
                "Item name",
                "Item description",
                9.05
        );

        newItem.setUser(userService.findUserById(1));
        newItem.setMarket(marketService.findByMarketId(1));
        newItem.setProduct(productService.findByProductId(1));

        Item updateItem = itemService.update(newItem, 1);
        assertNotNull(updateItem);
        assertEquals(newItem.getName(), updateItem.getName());
    }

    @WithUserDetails("tom@anaddress.com")
    @Test
    public void F_deleteItemById() {
        itemService.deleteItemById(3);
        assertEquals(3, itemService.findAllItems().size());
    }

    @WithUserDetails("jill@anaddress.com")
    @Test(expected = ResourceNotFoundException.class)
    public void F2_deleteItemByIdNotFound() {
        itemService.deleteItemById(999999);
        assertEquals(3, itemService.findAllItems().size());
    }

    @WithUserDetails("tom@anaddress.com")
    @Test(expected = ResourceNotFoundException.class)
    public void F23_deleteItemByIdNotAuthorized() {
        itemService.deleteItemById(1);
    }

    @Test
    public void G_deleteAll() {
        itemService.deleteAll();
        assertEquals(0, itemService.findAllItems().size());
    }
}