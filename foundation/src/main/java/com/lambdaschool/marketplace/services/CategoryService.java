package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.models.Category;
import java.util.Set;

public interface CategoryService {
  Set<Category> findAllCategories();

  Category findByCategoryId(long categoryId);

  Category save(Category category);

  void delete(long categoryId);

  void deleteAll();
}
