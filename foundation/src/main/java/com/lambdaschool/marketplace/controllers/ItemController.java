package com.lambdaschool.marketplace.controllers;

import com.lambdaschool.marketplace.models.Item;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.services.ItemService;
import com.lambdaschool.marketplace.services.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
     * <br>Example: http://localhost:2019/user/items
     * @param authentication Grabs the authentication info for the current auth token
     * @return JSON list of items belonging to the current user
     */
    @GetMapping(value = "/user/items", produces = {"application/json"})
    public ResponseEntity<?> findByUserId(Authentication authentication) {
        User currentUser = userService.findByName(authentication.getName());
        List<Item> itemList = itemService.findByUserId(currentUser.getUserId());
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    /**
     * Return a specific item based on a given itemId
     * <br>Example: http://localhost:2019/item/20
     * @param itemId The itemId of the item you seek
     * @return The specific item object you seek
     */
    @GetMapping(value = "/item/{itemId}", produces = {"application/json"})
    public ResponseEntity<?> getItemById(@PathVariable long itemId) {
        Item item = itemService.findItemById(itemId);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    /**
     * Given a complete item object, create a new Item object
     * <br>Example: http://localhost:2019/item
     * @param newItem A complete item object including user, market, category, subcategory and product.
     *                User, market, category, subcategory and product must already exist.
     * @return A location head with the URI to the newly created item and a status of CREATED
     */
    @PostMapping(value = "/item", consumes = {"application/json"})
    public ResponseEntity<?> addNewItem(@Valid @RequestBody Item newItem) {
        newItem.setItemId(0);
        newItem = itemService.save(newItem);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newItemURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{itemId}")
                .buildAndExpand(newItem.getItemId())
                .toUri();
        responseHeaders.setLocation(newItemURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

}
