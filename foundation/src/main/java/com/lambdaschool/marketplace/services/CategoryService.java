package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.models.Category;
import java.util.List;

public interface CategoryService {
  List<Category> findAllCategories();

  Category findByCategoryId(long categoryId);

  void delete(long categoryId);

  void deleteAll();
}
