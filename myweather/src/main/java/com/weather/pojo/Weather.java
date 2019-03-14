package com.weather.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
  private Long id;
  private String main;
  private String icon;
  private int code;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public void calculateCode() {
    if (id < 300) setCode(0); // thunderstorm
    else if (id < 500) setCode(1); // Drizzle
    else if (id < 600) setCode(2); // Rain
    else if (id < 700) setCode(3); // Snow
    else if (id < 800) setCode(4); // Atmosphere
    else if (id == 800) setCode(5); // Clear
    else setCode(6); // Cloudy
  }

  public Weather() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMain() {
    return main;
  }

  public void setMain(String main) {
    this.main = main;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }


  @Override
  public String toString() {
    return "Weather{" +
            "id=" + id +
            ", main='" + main + '\'' +
            ", icon='" + icon + '\'' +
            '}';
  }
}
