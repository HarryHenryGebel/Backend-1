package com.lambdaschool.marketplace.repository;

import com.lambdaschool.marketplace.models.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
  /**
   * Find a list of all categories
   * @return a list of all categories
   */
  List<Category> findAllCategories();
}
