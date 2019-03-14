package com.weather.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherList implements Serializable {
  //@JsonProperty("weather")
  private List<Weather> weathers;

  public WeatherList() {
    this.weathers = new ArrayList<>();
  }

  public List<Weather> getWeathers() {
    return weathers;
  }

  public int getCode() {
    weathers.get(0).calculateCode();
    return weathers.get(0).getCode();
  }

  public void setWeathers(List<Weather> weathers) {
    this.weathers = weathers;
  }
}
