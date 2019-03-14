package com.weather.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
  private Long id;
  private String name;
  private String cod;
  @JsonProperty("main")
  private Temperature temperature;
  @JsonProperty("weather")
  private List<Weather> weathers;
  private long dt;
  private String date;
  private String dayOfWeek;

  public String getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(String dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }
//@JsonProperty("weather")

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public long getDt() {
    return dt;
  }

  public void setDt(long dt) {
    this.dt = dt;
  }

  //private WeatherList weatherList;

//  public int test() {
//    return weatherList.getCode();
//  }


  public WeatherResponse() {
    weathers = new ArrayList<>();
  }

  public Temperature getTemperature() {
    return temperature;
  }

  public void setTemperature(Temperature temperature) {
    this.temperature = temperature;
  }

  public List<Weather> getWeathers() {
    return weathers;
  }

  public void setWeathers(List<Weather> weathers) {
    this.weathers = weathers;
  }

  public Long getId() {
    return id;
  }

  public int getCode() {
    weathers.get(0).calculateCode();
    return weathers.get(0).getCode();
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCod() {
    return cod;
  }

  public void setCod(String cod) {
    this.cod = cod;
  }

//  public WeatherList getWeatherList() {
//    return weatherList;
//  }
//
//  public void setWeatherList(WeatherList weatherList) {
//    this.weatherList = weatherList;
//  }


  @Override
  public String toString() {
    return "WeatherResponse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", cod='" + cod + '\'' +
            '}';
  }
}