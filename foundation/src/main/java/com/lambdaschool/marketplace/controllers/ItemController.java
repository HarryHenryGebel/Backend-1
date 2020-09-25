package com.lambdaschool.marketplace.controllers;

import com.lambdaschool.marketplace.models.Item;
import com.lambdaschool.marketplace.models.User;
import com.lambdaschool.marketplace.services.HelperFunctions;
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

  /**
   * Connects this service to the HelpFunctions service
   * Used in place of @Autowire
   */
  private final HelperFunctions helperFunctions;

  public ItemController(
    ItemService itemService,
    UserService userService,
    HelperFunctions helperFunctions
  ) {
    this.itemService = itemService;
    this.userService = userService;
    this.helperFunctions = helperFunctions;
  }

  /**
   * Returns a list of all items
   * <br>Example: http://localhost:2019/users
   * @return JSON list of all items with a status of OK
   */
  @GetMapping(value = "/items", produces = { "application/json" })
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
  @GetMapping(value = "/user/items", produces = { "application/json" })
  public ResponseEntity<?> findByUserId(Authentication authentication) {
    User currentUser = helperFunctions.getCurrentUser();
    List<Item> itemList = itemService.findByUserId(currentUser.getUserId());
    return new ResponseEntity<>(itemList, HttpStatus.OK);
  }

  /**
   * Return a specific item based on a given itemId
   * <br>Example: http://localhost:2019/item/20
   * @param itemId The itemId of the item you seek
   * @return The specific item object you seek
   */
  @GetMapping(value = "/item/{itemId}", produces = { "application/json" })
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
  @PostMapping(value = "/item", consumes = { "application/json" })
  public ResponseEntity<?> addNewItem(@Valid @RequestBody Item newItem) {
    // always post as current user
    newItem.setUser(helperFunctions.getCurrentUser());

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

  /**
   * Updates the item record associated with the itemId in the request URI.
   * Only the fields in the incoming JSON object are affected.
   * <br>Example: http://localhost:2019/item/20
   * @param updateItem An object containing values for just the item fields being updated.
   * @param itemId The primary key of the item you want to update.
   * @return A status of OK.
   */
  @PatchMapping(value = "/item/{itemId}", consumes = { "application/json" })
  public ResponseEntity<?> updateItem(
    @RequestBody Item updateItem,
    @PathVariable long itemId
  ) {
    updateItem.setUser(helperFunctions.getCurrentUser());
    itemService.update(updateItem, itemId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Deletes a given item based on the itemId in the request URI.
   * <br>Example: http://localhost:2019/item/20
   * @param itemId The primary key of the item you wish to delete
   * @return A status of OK
   */
  @DeleteMapping(value = "/item/{itemId}")
  public ResponseEntity<?> deleteItemById(@PathVariable long itemId) {
    itemService.deleteItemById(itemId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
