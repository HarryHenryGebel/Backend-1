package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.models.Product;
import java.util.List;

public interface ProductService {
  List<Product> findAllProducts();

  Product findByProductId(long productId);

  void delete(long productId);

  void deleteAll();
}
