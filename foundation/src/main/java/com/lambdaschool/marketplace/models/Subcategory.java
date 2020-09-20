package com.lambdaschool.marketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * The entity allowing interaction with the subcategory table
 */
@Entity
@Table(name = "subcategories")
public class Subcategory extends Auditable {
  /**
   * The primary key (long) of the items table.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long subcategoryId;

  /**
   * Item name. Cannot be null.
   */
  @Column(nullable = false)
  private String name;

  @OneToMany(
    mappedBy = "subcategory",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  @JsonIgnoreProperties(value = "product", allowSetters = true)
  private Set<Product> products = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  @JsonIgnoreProperties(value = "subcategoryList", allowSetters = true)
  private Category category;

  /**
   * Default constructor used primarily by the JPA.
   */
  @SuppressWarnings({ "unused", "RedundantSuppression" })
  public Subcategory() {}

  /**
   * Create a new Subcategory with provided name
   * @param name The name of the new Subcategory
   */
  public Subcategory(String name) {
    this.name = name;
  }

  /**
   * Getter for subcategoryId
   *
   * @return the subcategoryId (long) of the subcategory
   */
  public long getSubcategoryId() {
    return subcategoryId;
  }

  /**
   * Setter for subcategoryId. Used primary for seeding data
   *
   * @param subcategoryId the new subcategoryId (long) of the subcategory
   */
  public void setSubcategoryId(long subcategoryId) {
    this.subcategoryId = subcategoryId;
  }

  /**
   * Getter for name
   *
   * @return the name (String) of the subcategory
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for item name
   *
   * @param name (string) of the subcategory
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for the list of products associated with this subcategory
   *
   * @return the list of products for this subcategory
   */
  public Set<Product> getProducts() {
    return products;
  }

  /**
   * Setter for list of products for this category
   *
   * @param products the new list of subcategories for this subcategory
   */
  public void setProducts(Set<Product> products) {
    this.products = products;
  }

  /**
   * Getter for category
   * @return returns to category associated with this subcategory
   */
  public Category getCategory() {
    return category;
  }

  /**
   * Setter for category
   * @param category the category object associated with this subcategory
   */
  public void setCategory(Category category) {
    this.category = category;
  }
}
