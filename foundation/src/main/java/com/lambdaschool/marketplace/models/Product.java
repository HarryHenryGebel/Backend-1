package com.lambdaschool.marketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * The entity allowing interaction with the categories table
 */
@Entity
@Table(name = "products")
public class Product extends Auditable {
  /**
   * The primary key (long) of the items table.
   */
  @Id
  @GeneratedValue
  private long productId;

  /**
   * Item name. Cannot be null.
   */
  @Column(nullable = false)
  private String name;

  /**
   * Item's wholesale price.
   */
  private double wholesalePrice;

  @OneToMany(
    mappedBy = "product",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  @JsonIgnoreProperties(value = "product", allowSetters = true)
  private Set<Item> items = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "subcategory_id", nullable = false)
  @JsonIgnoreProperties(value = "products", allowSetters = true)
  private Subcategory subcategory;

  /**
   * Default constructor used primarily by the JPA.
   */
  public Product() {}

  public Product(String name, double wholesalePrice) {
    this.name = name;
    this.wholesalePrice = wholesalePrice;
  }

  public double getWholesalePrice() {
    return wholesalePrice;
  }

  public void setWholesalePrice(double wholesalePrice) {
    this.wholesalePrice = wholesalePrice;
  }

  public Set<Item> getItems() {
    return items;
  }

  public void setItems(Set<Item> items) {
    this.items = items;
  }

  public Subcategory getSubcategory() {
    return subcategory;
  }

  public void setSubcategory(Subcategory subcategory) {
    this.subcategory = subcategory;
  }

  /**
   * Getter for productId
   *
   * @return the productId (long) of the product
   */
  public long getProductId() {
    return productId;
  }

  /**
   * Setter for productId. Used primary for seeding data
   *
   * @param productId the new productId (long) of the product
   */
  public void setProductId(long productId) {
    this.productId = productId;
  }

  /**
   * Getter for name
   *
   * @return the name (String) of the product
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for item name
   *
   * @param name (string) of the product
   */
  public void setName(String name) {
    this.name = name;
  }
}
