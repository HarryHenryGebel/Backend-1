package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.models.Market;
import java.util.List;

public interface MarketService {
  List<Market> findAllMarkets();

  Market findByMarketId(long marketId);

  void delete(long marketId);

  void deleteAll();
}
