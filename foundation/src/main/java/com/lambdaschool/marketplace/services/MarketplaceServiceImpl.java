package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Marketplace;
import com.lambdaschool.marketplace.repository.MarketplaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "marketplaceService")
public class MarketplaceServiceImpl implements MarketplaceService {

    /**
     * Connects this service to the marketplaces table
     * Used in place of @Autowired
     */
    private final MarketplaceRepository marketplaceRepository;

    public MarketplaceServiceImpl(MarketplaceRepository marketplaceRepository) {
        this.marketplaceRepository = marketplaceRepository;
    }

    /**
     * Finds a list of all marketplaces in the database
     * @return a list of all marketplaces in the database
     */
    @Override
    public List<Marketplace> findAllMarketplaces() {
        List<Marketplace> marketplaceList = new ArrayList<>();
        marketplaceRepository.findAll().iterator().forEachRemaining(marketplaceList::add);
        return marketplaceList;
    }

    /**
     * Finds the specified marketplace based on the marketplaceId provided
     * @param marketplaceId the marketplaceId associated with the object you seek
     * @return returns the marketplace object associated with the provided marketplaceId
     */
    @Override
    public Marketplace findByMarketplaceId(long marketplaceId) {
        return marketplaceRepository.findById(marketplaceId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Marketplace ID " + marketplaceId + " not found!")
                );
    }

    /**
     * Removes a marketplace from the database based on the marketplaceId provided
     * @param marketplaceId The primary key (long) of the marketplace to be removed
     */
    @Transactional
    @Override
    public void delete(long marketplaceId) {
      Marketplace marketplace = findByMarketplaceId(marketplaceId);
      marketplaceRepository.delete(marketplace);
    }

    /**
     * Deletes all records from the marketplaces table
     * Used primarily to clear the table before seeding with test data
     */
    @Transactional
    @Override
    public void deleteAll() {
        marketplaceRepository.deleteAll();
    }
}