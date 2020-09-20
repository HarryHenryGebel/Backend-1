package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> findAllCategories() {
        return null;
    }

    @Override
    public Category findByCategoryId(long categoryId) {
        return null;
    }

    @Override
    public void delete(long categoryId) {

    }

    @Override
    public void deleteAll() {

    }
}
