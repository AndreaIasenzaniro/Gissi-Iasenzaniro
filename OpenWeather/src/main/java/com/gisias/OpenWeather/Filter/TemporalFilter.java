package com.gisias.OpenWeather.Filter;

/**
 * Class that creates a temporal filter
 * 
 * @author Andrea Iasenzaniro
 * @author Carlo Gissi
 *
 */
public class TemporalFilter {
    protected String cityName;
    protected String inInstant;
    protected String finInstant;

    /**
     * Constructor for TempFilter
     * 
     * @param cityName   the name of the city
     * @param inInstant  the start date of the interval
     * @param finInstant the end date of the interval
     */
    public TemporalFilter(String cityName, String inInstant, String finInstant) {
        this.inInstant = inInstant;
        this.finInstant = finInstant;
        this.cityName = cityName;
    }

    /**
     * @return the start date of the interval (inInstant)
     */
    public String getInInstant() {
        return inInstant;
    }

    /**
     * @param inInstant the start date of the interval (inInstant) to set
     */
    public void setInInstant(String inInstant) {
        this.inInstant = inInstant;
    }

    /**
     * @return the end date of the interval (finInstant)
     */
    public String getFinInstant() {
        return finInstant;
    }

    /**
     * @param finInstant the end date of the interval (finInstant) to set
     */
    public void setFinInstant(String finInstant) {
        this.finInstant = finInstant;
    }

    /**
     * @return the name of the city (cityName)
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the name of the city (cityName) to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}