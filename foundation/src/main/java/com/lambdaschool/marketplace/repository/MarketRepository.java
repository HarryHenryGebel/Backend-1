package com.lambdaschool.marketplace.repository;

import com.lambdaschool.marketplace.models.Market;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository
  extends CrudRepository<Market, Long> {}
