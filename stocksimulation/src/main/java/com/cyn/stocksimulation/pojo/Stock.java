package com.cyn.stocksimulation.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock {
  @JsonProperty("1. open")
  private String open;

  public Stock() {
  }

  public String getOpen() {
    return open;
  }

  public void setOpen(String open) {
    this.open = open;
  }

  @Override
  public String toString() {
    return "Stock{" +
            "open=" + open +
            '}';
  }
}
