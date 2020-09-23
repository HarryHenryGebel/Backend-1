package com.lambdaschool.marketplace.controllers;

import com.lambdaschool.marketplace.models.Market;
import com.lambdaschool.marketplace.services.MarketService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketController {
  private final MarketService marketService;

  public MarketController(MarketService marketService) {
    this.marketService = marketService;
  }

  @GetMapping(value = "/markets", produces = { "application/json" })
  public ResponseEntity<?> listAllMarkets() {
    List<Market> marketList = marketService.findAllMarkets();
    return new ResponseEntity<>(marketList, HttpStatus.OK);
  }
}
