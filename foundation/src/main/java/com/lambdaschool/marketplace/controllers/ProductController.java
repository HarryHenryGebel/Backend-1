package com.lambdaschool.marketplace.controllers;

import com.lambdaschool.marketplace.services.ProductService;
import com.lambdaschool.marketplace.views.ProductCategoryList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(value = "/products", produces = { "application/json" })
  public ResponseEntity<?> getProductCategoryList() {
    List<ProductCategoryList> returnList = productService.getProductCategoryList();
    return new ResponseEntity<>(returnList, HttpStatus.OK);
  }
}
