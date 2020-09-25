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
public class MarketServiceImplTest {

    @Autowired
    private MarketService marketService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void A_findAllMarkets() {
        assertEquals(124, marketService.findAllMarkets().size());
    }

    @Test
    public void B_findByMarketId() {
        assertEquals("Bujumbura, Burundi", marketService.findByMarketId(1).getName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void BB_findByMarketIdNotFound() {
        assertEquals("", marketService.findByMarketId(999999).getName());
    }

    @Test
    public void C_delete() {
        marketService.delete(1);
        assertEquals(123, marketService.findAllMarkets().size());
    }

    @Test
    public void D_deleteAll() {
        marketService.deleteAll();
        assertEquals(0, marketService.findAllMarkets().size());
    }
}