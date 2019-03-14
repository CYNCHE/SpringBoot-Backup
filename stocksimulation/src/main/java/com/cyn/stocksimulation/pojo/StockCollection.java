package com.cyn.stocksimulation.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockCollection {
  @JsonProperty("Time Series (5min)")
  private Map<String, Stock> stockMap;

  public StockCollection() {
  }

  public Map<String, Stock> getStockMap() {
    return stockMap;
  }

  public void setStockMap(Map<String, Stock> stockMap) {
    this.stockMap = stockMap;
  }
}
