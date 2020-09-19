package com.lambdaschool.marketplace.repository;

import com.lambdaschool.marketplace.models.UserEmail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The CRUD Repository connecting UserEmail to the rest of the application
 */
@Repository
public interface UserEmailRepository extends CrudRepository<UserEmail, Long> {}
