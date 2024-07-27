package com.gisias.OpenWeather.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gisias.OpenWeather.model.Data;
import com.gisias.OpenWeather.util.Serialize;

/**
 * Class containing methods for parsing JSON data
 * 
 * @authour Andrea Iasenzaniro
 * @authour Carlo Gissi
 *
 */
@Service
public class Parser {

    // Base URL for the OpenWeather API, injected from application properties
    @Value("${openweather.api.baseurl}")
    private String baseUrl;

    // API key for the OpenWeather API, injected from application properties
    @Value("${openweather.api.key}")
    private String apiKey;

    /**
     * Method that parses the current weather data from the OpenWeather API
     * 
     * @param cityname name of the city to query the API for
     * @return Serialized string of the city's weather information
     */
    public String currentParser(String cityname) {
        String urlString = baseUrl + "weather?q=" + cityname + "&appid=" + apiKey;

        try {
            URLConnection openConnection = new URL(urlString).openConnection();
            InputStream input = openConnection.getInputStream();

            StringBuilder result = new StringBuilder();
            String line;

            try (BufferedReader bufRead = new BufferedReader(new InputStreamReader(input))) {
                while ((line = bufRead.readLine()) != null) {
                    result.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Serialize.currentSerializer(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method that parses the weather forecast data from the OpenWeather API
     * 
     * @param cityname name of the city to query the API for
     * @return Serialized string of the city's weather forecast information
     */
    public String forecastParser(String cityname) {
        Data data = new Data(cityname);
        String urlString = baseUrl + "onecall?lat=" + data.getLat() + "&lon=" + data.getLon() + "&exclude=minutely,current,hourly&appid=" + apiKey;

        try {
            URLConnection openConnection = new URL(urlString).openConnection();
            InputStream input = openConnection.getInputStream();

            StringBuilder result = new StringBuilder();
            String line;

            try (BufferedReader bufRead = new BufferedReader(new InputStreamReader(input))) {
                while ((line = bufRead.readLine()) != null) {
                    result.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally {
                input.close();
            }
            return Serialize.forecastSerializer(result.toString(), cityname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}