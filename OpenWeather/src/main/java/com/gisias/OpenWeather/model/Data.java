package com.gisias.OpenWeather.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;

/**
 * Auxiliary class that retrieves the coordinates of a city given its name
 * 
 * @author Andrea Iasenzaniro
 * @author Carlo Gissi
 *
 */
public class Data {

	@Value("${openweather.api.baseurl}")
    private String baseUrl;

    @Value("${openweather.api.key}")
    private String apiKey;

    String cityName;
    /**
     * Latitude of the city
     */
    double lat;
    /**
     * Longitude of the city
     */
    double lon;

    /**
     * Constructor that initializes Data with the city's name and retrieves its coordinates
     * 
     * @param cityName name of the city
     */
    public Data(String cityName) {
        this.cityName = cityName;
        getCoord();
    }

    /**
     * Default constructor for the Data class
     */
    public Data() {
    }

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return the latitude
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the latitude to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the longitude
     */
    public double getLon() {
        return lon;
    }

    /**
     * @param lon the longitude to set
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * Method that automatically populates the city's coordinates based on its name in the constructor
     */
    void getCoord() {
        // Using the baseUrl and apiKey properties
        String urlString = baseUrl + "?q=" + getCityName() + "&appid=" + apiKey;
        JSONParser parser = new JSONParser();

        try {
            URLConnection openConnection = new URL(urlString).openConnection();

            InputStream in = openConnection.getInputStream();

            String result = "";
            String line = "";
            try {
                InputStreamReader inR = new InputStreamReader(in);
                BufferedReader buf = new BufferedReader(inR);

                while ((line = buf.readLine()) != null) {
                    result += line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                in.close();
            }

            JSONObject jo = (JSONObject) parser.parse(result);

            JSONObject coord = (JSONObject) jo.get("coord");
            Double lat = Double.parseDouble(coord.get("lat").toString());
            Double lon = Double.parseDouble(coord.get("lon").toString());

            this.setLat(lat);
            this.setLon(lon);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}