package com.weather.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
  private List<WeatherResponse> list;

  public Forecast() {
    list = new ArrayList<>();
  }

  public List<WeatherResponse> getList() {
    return list;
  }

  public void setList(List<WeatherResponse> list) {
    this.list = list;
  }

  public void processDate() {
    for (int i = 8; i < list.size(); i += 8) {
      WeatherResponse weatherResponse = list.get(i);
//      System.out.println(weatherResponse.getDt());
//      Date date = new Date(weatherResponse.getDt() * 1000);
//      DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//      format.setTimeZone(TimeZone.getDefault());
//      System.out.println(weatherResponse.getDt());

//      System.out.println(format.format(date).toString());

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd");
      LocalDateTime date = LocalDateTime.ofEpochSecond(weatherResponse.getDt(), 0, ZoneOffset.ofHours(-5));
      String time = date.format(formatter);
      DayOfWeek dow = date.getDayOfWeek();
      weatherResponse.setDate(time);
      weatherResponse.setDayOfWeek(dow.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
//      System.out.println(dow.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
//      System.out.println(time);
    }
  }

  // since the min_temp and max_temp provided by API is only within three hours,
  // we need to calculate daily high and low temp roughly
  public void setMaxAndMin() {
    Long min = 200L, max = -200L;
    for (int i = 0; i < list.size(); ++i) {
      Temperature temperature = list.get(i).getTemperature();
      min = Math.min(min, temperature.getTemp_min());
      max = Math.max(max, temperature.getTemp_max());
      if (i % 8 == 0) {
        temperature.setTemp_min(min);
        temperature.setTemp_max(max);
        min = 200L;
        max = -200L;
      }
    }
  }
}
