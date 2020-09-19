package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Item;
import com.lambdaschool.marketplace.repository.ItemRepository;
import com.lambdaschool.marketplace.repository.UserRepository;
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
     * Connects this service to the Users table
     * Used in place of @Autowire
     */
    private final UserRepository userRepository;

    /**
     * Connects this service to the HelpFunctions service
     * Used in place of @Autowire
     */
    private final HelperFunctions helperFunctions;

    public ItemServiceImpl(ItemRepository itemRepository, HelperFunctions helperFunctions, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.helperFunctions = helperFunctions;
        this.userRepository = userRepository;
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
        itemRepository.findByUserId(userId).iterator().forEachRemaining(returnList::add);
        return returnList;
    }

    /**
     * Finds a list of all items in the database
     * @return returns a list of all items in the database
     */
    @Override
    public List<Item> findAllItems() {
        List<Item> returnList = new ArrayList<>();
        itemRepository.findAllItems().iterator().forEachRemaining(returnList::add);
        return returnList;
    }

    @Transactional
    @Override
    public Item save(Item item) {
        // Create a new item object
        Item newItem = new Item();

        // Find the User associated with the new item
        if (item.getUser() != null) {
            userRepository.findById(item.getUser().getUserId())
                    .orElseThrow(
                            () -> new ResourceNotFoundException("User id " + item.getUser().getUserId() + " not " +
                                    "found!")
                    );
            newItem.setUser(item.getUser());
        }

        // Set the item's name, description and price
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        newItem.setPrice(item.getPrice());

        // Set the item's market
        newItem.setMarket(item.getMarket());

        // Set the item's product (category
        newItem.setProduct(item.getProduct());

        return itemRepository.save(newItem);
    }

    @Override
    public Item update(Item item, long itemId) {
        return null;
    }

    @Override
    public void deleteItemById(long itemId) {

    }

    @Override
    public void deleteAll() {

    }
}
