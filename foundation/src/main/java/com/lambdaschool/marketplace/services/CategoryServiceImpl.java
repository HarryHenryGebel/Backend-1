package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Category;
import com.lambdaschool.marketplace.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

    /**
     * Connects this service to the categories table
     * Used in place of @Autowired
     */
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Finds a list of all categories in the database
     * @return a list of all categories in the database
     */
    @Override
    public List<Category> findAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findAll().iterator().forEachRemaining(categoryList::add);
        return categoryList;
    }

    /**
     * Finds the specified category based on the categoryId provided
     * @param categoryId the categoryId associated with the object you seek
     * @return returns the category object associated with the provided categoryId
     */
    @Override
    public Category findByCategoryId(long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Category ID " + categoryId + " not found!")
                );
    }

    /**
     * Removes a category from the database based on the categoryId provided
     * @param categoryId The primary key (long) of the category to be removed
     */
    @Transactional
    @Override
    public void delete(long categoryId) {
        categoryRepository.findById(categoryId)
                .orElseThrow(
                        () -> new RuntimeException("Category ID " + categoryId + " not found!")
                );
        categoryRepository.deleteById(categoryId);
    }

    /**
     * Deletes all records from the categories table
     * Used primarily to clear the table before seeding with test data
     */
    @Transactional
    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
