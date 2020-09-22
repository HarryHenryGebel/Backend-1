package com.lambdaschool.marketplace.repository;

import com.lambdaschool.marketplace.models.Product;
import com.lambdaschool.marketplace.views.ProductCategoryList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT p.product_id, p.name AS product_name, s.subcategory_id, s.name AS subcategory_name, c" +
            ".category_id, c.name AS category_name " +
            "FROM products p " +
            "LEFT JOIN subcategories s ON p.subcategory_id = s.subcategory_id " +
            "LEFT JOIN categories c ON s.category_id = c.category_id " +
            "ORDER BY p.product_id", nativeQuery = true)
    List<ProductCategoryList> getProductCategoryList();
}
