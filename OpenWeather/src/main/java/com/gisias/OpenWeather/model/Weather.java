package com.gisias.OpenWeather.model;

/**
 * Class that creates weather objects, containing meteorological information of a city.
 * 
 * @author Andrea Iasenzaniro
 * @authour Carlo Gissi
 *
 */
public class Weather extends Data {

    private long dt;
    private double clouds;
    private double temp;
    private double feels_like;
    private double tempMax;
    private double tempMin;
    private double wind_speed;

    /**
     * Parameterized constructor for the Weather class
     * 
     * @param cityName   name of the city
     * @param dt         data acquisition timestamp
     * @param clouds     cloudiness percentage
     * @param temp       actual temperature
     * @param feels_like perceived temperature
     * @param tempMax    maximum temperature
     * @param tempMin    minimum temperature
     * @param wind_speed wind speed
     */
    public Weather(String cityName, long dt, double clouds, double temp, double feels_like, double tempMax,
                   double tempMin, double wind_speed) {
        super(cityName);
        this.dt = dt;
        this.clouds = clouds;
        this.temp = temp;
        this.feels_like = feels_like;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.wind_speed = wind_speed;
    }

    /**
     * Default constructor for the Weather class
     */
    public Weather() {
    }

    /**
     * @return the data acquisition timestamp (dt)
     */
    public long getDt() {
        return dt;
    }

    /**
     * @param dt the data acquisition timestamp (dt) to set
     */
    public void setDt(long dt) {
        this.dt = dt;
    }

    /**
     * @return the cloudiness percentage
     */
    public double getClouds() {
        return clouds;
    }

    /**
     * @param clouds the cloudiness percentage to set
     */
    public void setClouds(double clouds) {
        this.clouds = clouds;
    }

    /**
     * @return the actual temperature
     */
    public double getTemp() {
        return temp;
    }

    /**
     * @param temp the actual temperature to set
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * @return the perceived temperature
     */
    public double getFeels_like() {
        return feels_like;
    }

    /**
     * @param feels_like the perceived temperature to set
     */
    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    /**
     * @return the maximum temperature
     */
    public double getTempMax() {
        return tempMax;
    }

    /**
     * @param tempMax the maximum temperature to set
     */
    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    /**
     * @return the minimum temperature
     */
    public double getTempMin() {
        return tempMin;
    }

    /**
     * @param tempMin the minimum temperature to set
     */
    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    /**
     * @return the wind speed
     */
    public double getWind_speed() {
        return wind_speed;
    }

    /**
     * @param wind_speed the wind speed to set
     */
    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }
}