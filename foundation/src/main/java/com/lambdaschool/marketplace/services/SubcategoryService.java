package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.models.Subcategory;
import java.util.List;

public interface SubcategoryService {
  List<Subcategory> findAllSubcategories();

  Subcategory findBySubcategoryId(long subcategoryId);

  void delete(long subcategoryId);

  void deleteAll();
}
