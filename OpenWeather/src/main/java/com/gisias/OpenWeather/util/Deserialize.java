package com.gisias.OpenWeather.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import com.gisias.OpenWeather.model.Weather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Class that performs deserialization of a JSON file
 * 
 * @authour Andrea Iasenzaniro
 * @authour Carlo Gissi
 *
 */
public class Deserialize {
    
    /**
     * Method that deserializes a file containing data related to Current API
     * 
     * @param cityName name of the city file to deserialize
     * @return vector of Weather type related to the deserialized city
     */
    @SuppressWarnings("resource")
    public static Vector<Weather> deserializeCurrent(String cityName) {
        String result = "";
        String line = "";
        String path = "OpenweatherApp/OpenWeather/correnti";
        Vector<Weather> wth = new Vector<Weather>();
        try {
            BufferedReader bufRead = new BufferedReader(new FileReader(path + "/" + cityName + ".txt"));
            while ((line = bufRead.readLine()) != null) {
                Gson gson = new Gson();
                result = line;
                Weather weather = gson.fromJson(result, Weather.class);
                wth.add(weather);
            }
            return wth;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method that deserializes a file containing data related to Forecast API
     * 
     * @param cityName name of the city file to deserialize
     * @return vector of Weather type related to the deserialized city
     */
    public static Vector<Weather> deserializeForecast(String cityName) {
        String path = "OpenweatherApp/OpenWeather/previsionali";
        try {
            BufferedReader bufRead = new BufferedReader(new FileReader(path + "/" + cityName + ".txt"));
        
            Vector<Weather> wth = new Gson().fromJson(bufRead, new TypeToken<Vector<Weather>>() {}.getType());
            bufRead.close();
                
            return wth;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}