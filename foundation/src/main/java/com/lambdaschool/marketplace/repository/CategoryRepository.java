package com.lambdaschool.marketplace.repository;

import com.lambdaschool.marketplace.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    /**
     * Find a list of all categories
     * @return a list of all categories
     */
    List<Category> findAllCategories();
}
