package com.swapnil.weather.service;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swapnil.weather.res.WeatherResponse;

@Service
public class WeatherService {
	
    private final String API_KEY;
    private final String apiUrl;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public WeatherService(RestTemplate restTemplate, ObjectMapper objectMapper, Environment environment) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.API_KEY = environment.getProperty("openweathermap.api.key");
        this.apiUrl = environment.getProperty("openweathermap.api.url");
    }

    // req from lat and lon
    public WeatherResponse getCurrentWeather(double lat, double lon) {
        String url = apiUrl + "?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY;
        return getWeatherResponse(url);
    }
    public WeatherResponse getCurrentWeatherByCityId(long cityId) {
        String url = apiUrl + "?id=" + cityId + "&appid=" + API_KEY;
        return getWeatherResponse(url);
    }

    public WeatherResponse getCurrentWeatherByZipCode(Integer zipCode) {
        String countryCode = "IN"; 
        String url = apiUrl + "?zip=" + zipCode + "," + countryCode + "&appid=" + API_KEY;
        return getWeatherResponse(url);
    }

    public WeatherResponse getCurrentWeatherByCityName(String cityName, String countryCode) {
        String url = apiUrl+"?q=" + cityName + "," + countryCode + "&appid=" + API_KEY;
        return getWeatherResponse(url);
    }

    public WeatherResponse getCurrentWeatherWithUnits(double lat, double lon, String units) {
        String url = apiUrl+ "?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY + "&units=" + units;
        return getWeatherResponse(url);
    }

    public WeatherResponse getCurrentWeatherWithLanguage(double lat, double lon, String lang) {
        String url = apiUrl+"?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY + "&lang=" + lang;
        return getWeatherResponse(url);
    }
    
    

  

    private WeatherResponse getWeatherResponse(String url) {
        String response = restTemplate.getForObject(url, String.class);

        try {
            return objectMapper.readValue(response, WeatherResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}