package com.lambdaschool.marketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * The entity allowing interaction with the categories table
 */
@Entity
@Table(name = "categories")
public class Category extends Auditable {
  /**
   * The primary key (long) of the items table.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long categoryId;

  /**
   * Item name. Cannot be null.
   */
  @Column(nullable = false)
  private String name;

  @OneToMany(
    mappedBy = "category",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  @JsonIgnoreProperties(value = "category", allowSetters = true)
  private Set<Subcategory> subcategories = new HashSet<>();

  /**
   * Default constructor used primarily by the JPA.
   */
  public Category() {}

  /**
   * Getter for categoryId
   *
   * @return the categoryId (long) of the category
   */
  public long getCategoryId() {
    return categoryId;
  }

  /**
   * Setter for categoryId. Used primary for seeding data
   *
   * @param categoryId the new categoryId (long) of the category
   */
  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

  /**
   * Getter for name
   *
   * @return the name (String) of the category
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for item name
   *
   * @param name (string) of the category
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for the list of subcategories associated with this category
   *
   * @return the list of subcategories (List<Subcategory>) for this category
   */
  public Set<Subcategory> getSubcategories() {
    return subcategories;
  }

  /**
   * Setter for list of subcategories for this category
   *
   * @param subcategories the new list of subcategories (List<Subcategory>) for
   * this category
   */
  @SuppressWarnings({ "unused", "RedundantSuppression" })
  public void setSubcategories(Set<Subcategory> subcategories) {
    this.subcategories = subcategories;
  }
}
