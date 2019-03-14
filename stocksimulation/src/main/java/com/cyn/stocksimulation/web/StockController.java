package com.cyn.stocksimulation.web;


import com.cyn.stocksimulation.pojo.StockCollection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class StockController {


  @GetMapping("/stock")
  public String stockInput() {
    System.out.println("here");
    String URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=5min&apikey=185ZHT9W4VEHYT56";
    RestTemplate restTemplate = new RestTemplate();
    StockCollection stockCollection = restTemplate.getForObject(URL, StockCollection.class);
    System.out.println(stockCollection.getStockMap());
    return "login";
  }
}
