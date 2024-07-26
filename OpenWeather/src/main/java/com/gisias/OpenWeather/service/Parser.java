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
 * Classe che contiene metodi che effettuano il parsing Json
 * 
 * @author AndreaIasenzaniro
 * @Author CarloGissi
 *
 */
@Service
public class Parser {

    @Value("${openweather.api.baseurl}")
    private String baseUrl;

    @Value("${openweather.api.key}")
    private String apiKey;

    /**
     * Metodo che effettua il parsing di Current Api 
     * 
     * @param cityname nome della città di cui interrogare Api
     * @return Stringa serializzata delle informazioni della città 
     */
    public String currentParser(String cityname) {
        String urlString = baseUrl + "weather?q=" + cityname + "&appid=" + apiKey;

        try {
            URLConnection openConnection = new URL(urlString).openConnection();
            InputStream input = openConnection.getInputStream();

            String result = "";
            String line = "";

            try {
                BufferedReader bufRead = new BufferedReader(new InputStreamReader(input));
                while ((line = bufRead.readLine()) != null) {
                    result += line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Serialize.currentSerializer(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo che effettua il parsing di Forecast Api
     * 
     * @param cityname nome della città di cui interrogare le Api
     * @return Stringa serializzata delle informazioni della città
     */
    public String forecastParser(String cityname) {
        Data data = new Data(cityname);
        String urlString = baseUrl + "onecall?lat=" + data.getLat() + "&lon=" + data.getLon() + "&exclude=minutely,current,hourly&appid=" + apiKey;

        try {
            URLConnection openConnection = new URL(urlString).openConnection();
            InputStream input = openConnection.getInputStream();

            String result = "";
            String line = "";

            try {
                BufferedReader bufRead = new BufferedReader(new InputStreamReader(input));
                while ((line = bufRead.readLine()) != null) {
                    result += line;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally {
                input.close();
            }
            return Serialize.forecastSerializer(result, cityname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}