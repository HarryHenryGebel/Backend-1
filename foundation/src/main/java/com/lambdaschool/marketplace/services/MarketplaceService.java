package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.models.Marketplace;

import java.util.List;

public interface MarketplaceService {

    List<Marketplace> findAllMarketplaces();

    Marketplace findByMarketplaceId(long marketplaceId);

    void delete(long marketplaceId);

    void deleteAll();
}