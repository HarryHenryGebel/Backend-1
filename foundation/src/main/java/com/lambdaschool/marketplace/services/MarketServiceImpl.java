package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Market;
import com.lambdaschool.marketplace.repository.MarketRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "marketService")
public class MarketServiceImpl implements MarketService {
  /**
   * Connects this service to the markets table
   * Used in place of @Autowired
   */
  private final MarketRepository marketRepository;

  public MarketServiceImpl(MarketRepository marketRepository) {
    this.marketRepository = marketRepository;
  }

  /**
   * Finds a list of all markets in the database
   * @return a list of all markets in the database
   */
  @Override
  public List<Market> findAllMarkets() {
    List<Market> marketList = new ArrayList<>();
    marketRepository.findAll().iterator().forEachRemaining(marketList::add);
    return marketList;
  }

  /**
   * Finds the specified market based on the marketId provided
   * @param marketId the marketId associated with the object you seek
   * @return returns the market object associated with the provided marketId
   */
  @Override
  public Market findByMarketId(long marketId) {
    return marketRepository
      .findById(marketId)
      .orElseThrow(
        () ->
          new ResourceNotFoundException("Market ID " + marketId + " not found!")
      );
  }

  /**
   * Removes a market from the database based on the marketId provided
   * @param marketId The primary key (long) of the market to be removed
   */
  @Transactional
  @Override
  public void delete(long marketId) {
    Market market = findByMarketId(marketId);
    marketRepository.delete(market);
  }

  /**
   * Deletes all records from the markets table
   * Used primarily to clear the table before seeding with test data
   */
  @Transactional
  @Override
  public void deleteAll() {
    marketRepository.deleteAll();
  }
}
