package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.models.Subcategory;
import java.util.Set;

public interface SubcategoryService {
  Set<Subcategory> findAllSubcategories();

  Subcategory findBySubcategoryId(long subcategoryId);

  void delete(long subcategoryId);

  void deleteAll();
}
