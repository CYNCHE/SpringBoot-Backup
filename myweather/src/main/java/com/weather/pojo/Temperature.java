package com.weather.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

  private static final double Kelvin2Celsius = 273.15;
  private Long temp;
  private Long temp_min;
  private Long temp_max;

  public Temperature() {
  }

  public Long getTemp() {
    return temp;
  }

  public void setTemp(Long temp) {
    this.temp = temp;
  }

  public Long getTemp_min() {
    return temp_min;
  }

  public void setTemp_min(Long temp_min) {
    this.temp_min = temp_min;
  }

  public Long getTemp_max() {
    return temp_max;
  }

  public void setTemp_max(Long temp_max) {
    this.temp_max = temp_max;
  }


}
