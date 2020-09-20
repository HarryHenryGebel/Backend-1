package com.lambdaschool.marketplace.repository;

import com.lambdaschool.marketplace.models.Subcategory;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository
  extends CrudRepository<Subcategory, Long> {}
