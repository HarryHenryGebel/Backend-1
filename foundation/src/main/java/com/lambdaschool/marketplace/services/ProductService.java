package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.models.Product;
import com.lambdaschool.marketplace.views.ProductCategoryList;
import java.util.List;

public interface ProductService {
  List<Product> findAllProducts();

  List<ProductCategoryList> getProductCategoryList();

  Product findByProductId(long productId);

  void delete(long productId);

  void deleteAll();
}
