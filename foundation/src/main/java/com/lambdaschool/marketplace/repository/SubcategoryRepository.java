package com.lambdaschool.marketplace.repository;

import com.lambdaschool.marketplace.models.Subcategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository  extends CrudRepository<Subcategory, Long> {
    /**
     * Find a list of all subcategories
     * @return a list of all subcategories
     */
    List<Subcategory> findAllSubcategories();
}
