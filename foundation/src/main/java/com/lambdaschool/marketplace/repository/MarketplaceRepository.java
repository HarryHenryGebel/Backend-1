package com.lambdaschool.marketplace.repository;

import com.lambdaschool.marketplace.models.Marketplace;
import org.springframework.data.repository.CrudRepository;

public interface MarketplaceRepository
  extends CrudRepository<Marketplace, Long> {}
