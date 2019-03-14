package com.weather.web;


import com.weather.pojo.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import com.weather.pojo.WeatherResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class CityController {

  @Autowired
  private RestTemplate restTemplate;

  private static final String api = "https://api.openweathermap.org/data/2.5/weather?q=";
  private static final String appid = "&units=metric&appid=6abe3ad24b2f23b171a8c3b02825f66b";
  private static final String forecastApi = "https://api.openweathermap.org/data/2.5/forecast?q=";

  @PostMapping("/search")
  public String output(Model model, @RequestParam String city) {
    String uri = api + city + appid;
    String forecastUri = forecastApi + city + appid;
//    RestTemplate restTemplate = new RestTemplate();
    WeatherResponse result = restTemplate.getForObject(uri, WeatherResponse.class);
    Forecast forecast = restTemplate.getForObject(forecastUri, Forecast.class);


    forecast.processDate();
    forecast.setMaxAndMin();
    model.addAttribute("forecasts", forecast.getList());
    model.addAttribute("WeatherResponse", result);

    return "city";
  }
}
