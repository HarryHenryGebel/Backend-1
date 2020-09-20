package com.lambdaschool.marketplace.repository;

import com.lambdaschool.marketplace.models.Item;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The CRUD repository connecting Item to the rest of the application
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
  /**
   * Find a list of items associated with a specific user
   *
   * @param userId the userId of the user assigned to each item
   * @return a list of items assigned to the user
   */
  List<Item> findByUserId(long userId);
}
