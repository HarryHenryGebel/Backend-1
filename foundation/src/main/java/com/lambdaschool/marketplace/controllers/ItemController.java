package com.lambdaschool.marketplace.controllers;

import com.lambdaschool.marketplace.models.Item;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.services.ItemService;
import com.lambdaschool.marketplace.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    /**
     * Using the Item Service to process item data
     * Used in place of @Autowired
     */
    private final ItemService itemService;

    /**
     * Using the UserService to get user data
     * Used in place of @Autowired
     */
    private final UserService userService;

    public ItemController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }


    /**
     * Returns a list of all items
     * <br>Example: http://localhost:2019/users
     * @return JSON list of all items with a status of OK
     */
    @GetMapping(value = "/items", produces = {"application/json"})
    public ResponseEntity<?> findAllItems() {
        List<Item> itemList = itemService.findAllItems();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    /**
     * Returns a list of items belonging to the currently authenticated user
     * @param authentication Grabs the authentication info for the current auth token
     * @return JSON list of items belonging to the current user
     */
    @GetMapping(value = "/user/items", produces = {"application/json"})
    public ResponseEntity<?> findByUserId(Authentication authentication) {
        User currentUser = userService.findByName(authentication.getName());
        List<Item> itemList = itemService.findByUserId(currentUser.getUserId());
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

}
