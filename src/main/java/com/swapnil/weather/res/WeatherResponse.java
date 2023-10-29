package com.swapnil.weather.res;

import java.util.List;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
	private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private long id;
    private String name;
    private int cod;
    private String weatherCondition;
    
    
    @PostConstruct
    public void init() {
        setWeatherConditionFromMain();
    }

    public void setWeatherConditionFromMain() {
        if (this.weather != null && !this.weather.isEmpty()) {
            this.weatherCondition = this.weather.get(0).getMain();
        }
    }
    
    
    
}
