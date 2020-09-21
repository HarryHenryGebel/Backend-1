package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Product;
import com.lambdaschool.marketplace.repository.ProductRepository;
import com.lambdaschool.marketplace.views.ProductCategoryList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
  /**
   * Connects this service to the products table
   * Used in place of @Autowired
   */
  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<ProductCategoryList> getProductCategoryList() {
    List<ProductCategoryList> returnList = productRepository.getProductCategoryList();
    return returnList;
  }

  /**
   * Finds a list of all products in the database
   * @return a list of all products in the database
   */
  @Override
  public List<Product> findAllProducts() {
    List<Product> productList = new ArrayList<>();
    productRepository.findAll().iterator().forEachRemaining(productList::add);
    return productList;
  }

  /**
   * Finds the specified product based on the productId provided
   * @param productId the productId associated with the object you seek
   * @return returns the product object associated with the provided productId
   */
  @Override
  public Product findByProductId(long productId) {
    return productRepository
      .findById(productId)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            "Product ID " + productId + " not found!"
          )
      );
  }

  /**
   * Removes a product from the database based on the productId provided
   * @param productId The primary key (long) of the product to be removed
   */
  @Transactional
  @Override
  public void delete(long productId) {
    Product product = findByProductId(productId);
    productRepository.delete(product);
  }

  /**
   * Deletes all records from the products table
   * Used primarily to clear the table before seeding with test data
   */
  @Transactional
  @Override
  public void deleteAll() {
    productRepository.deleteAll();
  }
}
