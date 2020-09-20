package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Subcategory;
import com.lambdaschool.marketplace.repository.SubcategoryRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "subcategoryService")
public class SubcategoryServiceImpl implements SubcategoryService {
  /**
   * Connects this service to the subcategories table
   * Used in place of @Autowired
   */
  private final SubcategoryRepository subcategoryRepository;

  public SubcategoryServiceImpl(SubcategoryRepository subcategoryRepository) {
    this.subcategoryRepository = subcategoryRepository;
  }

  /**
   * Finds a list of all subcategories in the database
   * @return a list of all subcategories in the database
   */
  @Override
  public Set<Subcategory> findAllSubcategories() {
    Set<Subcategory> subcategoryList = new HashSet<>();
    subcategoryRepository
      .findAll()
      .iterator()
      .forEachRemaining(subcategoryList::add);
    return subcategoryList;
  }

  /**
   * Finds the specified subcategory based on the subcategoryId provided
   * @param subcategoryId the subcategoryId associated with the object you seek
   * @return returns the subcategory object associated with the provided subcategoryId
   */
  @Override
  public Subcategory findBySubcategoryId(long subcategoryId) {
    return subcategoryRepository
      .findById(subcategoryId)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            "Subcategory ID " + subcategoryId + " not found!"
          )
      );
  }

  /**
   * Removes a subcategory from the database based on the subcategoryId provided
   * @param subcategoryId The primary key (long) of the subcategory to be removed
   */
  @Override
  public void delete(long subcategoryId) {
    subcategoryRepository
      .findById(subcategoryId)
      .orElseThrow(
        () ->
          new RuntimeException(
            "Subcategory ID " + subcategoryId + " not found!"
          )
      );
    subcategoryRepository.deleteById(subcategoryId);
  }

  /**
   * Deletes all records from the subcategories table
   * Used primarily to clear the table before seeding with test data
   */
  @Override
  public void deleteAll() {
    subcategoryRepository.deleteAll();
  }
}
