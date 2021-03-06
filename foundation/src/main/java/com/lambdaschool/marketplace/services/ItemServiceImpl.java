package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Item;
import com.lambdaschool.marketplace.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements ItemService Interface
 */
@Transactional
@Service(value = "itemService")
public class ItemServiceImpl implements ItemService {
  /**
   * Connects this service to the Item table
   * Used in place of @Autowire
   */
  private final ItemRepository itemRepository;

  /**
   * Connects this service to the HelpFunctions service
   * Used in place of @Autowire
   */
  private final HelperFunctions helperFunctions;

  public ItemServiceImpl(
    ItemRepository itemRepository,
    HelperFunctions helperFunctions
  ) {
    this.itemRepository = itemRepository;
    this.helperFunctions = helperFunctions;
  }

  /**
   * Finds a list of items associated with a specific user
   *
   * @param userId the userId of the user who's items you're looking for
   * @return returns a list of all items associated with the specified user
   */
  @Override
  public List<Item> findByUserId(long userId) {
    List<Item> returnList = new ArrayList<>();
    itemRepository
      .findByUserUserId(userId)
      .iterator()
      .forEachRemaining(returnList::add);
    return returnList;
  }

  /**
   * Finds a list of all items in the database
   * @return returns a list of all items in the database
   */
  @Override
  public List<Item> findAllItems() {
    List<Item> returnList = new ArrayList<>();
    itemRepository.findAll().iterator().forEachRemaining(returnList::add);
    return returnList;
  }

  /**
   * Finds the specified item based on the itemId provided
   * @param itemId the itemId associated with the object you seek
   * @return returns the item object associated with the provided itemId
   */
  @Override
  public Item findItemById(long itemId) {
    return itemRepository
      .findById(itemId)
      .orElseThrow(
        () -> new ResourceNotFoundException("Item ID " + itemId + " not found!")
      );
  }

  /**
   * Saves a new item to the database
   * @param item the item object to be saved
   * @return returns the saved item
   */
  @Transactional
  @Override
  public Item save(Item item) {
    // Create a new item object
    Item newItem = new Item();

    // Set local fields
    newItem.setName(item.getName());
    newItem.setDescription(item.getDescription());
    newItem.setPrice(item.getPrice());

    // Set joins
    newItem.setUser(item.getUser());
    newItem.setMarket(item.getMarket());
    newItem.setProduct(item.getProduct());

    return itemRepository.save(newItem);
  }

  /**
   * Updates and existing item in the database with new information
   * @param item just the item fields to be updated.
   * @param itemId   The primary key (long) of the item to update
   * @return returns the updated item
   */
  @Transactional
  @Override
  public Item update(Item item, long itemId) {
    // Get the current item object from the database
    Item currentItem = findItemById(itemId);

    // Check if the current user is authorized to make the change
    if (
      helperFunctions.isAuthorizedToMakeChange(item.getUser().getUsername())
    ) {
      // Check if the incoming object has a name and update if yes
      if (item.getName() != null) {
        currentItem.setName(item.getName());
      }

      // Check if the incoming object has a description and update if yes
      if (item.getDescription() != null) {
        currentItem.setDescription(item.getDescription());
      }

      // Check if the incoming object has a price and update if yes
      if (item.getPrice() != 0) {
        currentItem.setPrice(item.getPrice());
      }

      // Check if the incoming object has a market and update if yes
      if (item.getMarket() != null) {
        currentItem.setMarket(item.getMarket());
      }

      // Check if the incoming object has a product and update if yes
      if (item.getProduct() != null) {
        currentItem.setProduct(item.getProduct());
      }

      // Save the updated item to database
      return itemRepository.save(currentItem);
    } else {
      // note we should never get to this line but is needed for the compiler
      // to recognize that this exception can be thrown
      throw new ResourceNotFoundException(
        "This user is not authorized to make change"
      );
    }
  }

  /**
   * Removes an item from the database based on the itemId provided
   * @param itemId The primary key (long) of the item to be removed
   */
  @Transactional
  @Override
  public void deleteItemById(long itemId) {
    Item item = itemRepository
      .findById(itemId)
      .orElseThrow(
        () ->
          new ResourceNotFoundException("Item number " + itemId + " not found!")
      );
    // Check if the current user is authorized to make the change
    if (
      helperFunctions.isAuthorizedToMakeChange(item.getUser().getUsername())
    ) {
      // Remove the item
      itemRepository.deleteById(itemId);
    } else {
      // note we should never get to this line but is needed for the compiler
      // to recognize that this exception can be thrown
      throw new ResourceNotFoundException(
        "This user is not authorized to make change"
      );
    }
  }

  /**
   * Deletes all records from the items table
   * Used primarily to clear the table before seeding with test data
   */
  @Transactional
  @Override
  public void deleteAll() {
    itemRepository.deleteAll();
  }
}
