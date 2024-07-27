package com.gisias.OpenWeather.Exception;

/**
 * Class that handles the exception thrown when a city is not present in the dataset
 * 
 * @author Andrea Iasenzaniro
 * @authour Carlo Gissi
 *
 */
public class CityNameException extends Exception {

    public CityNameException() {
        super();
    }

    public CityNameException(String msg) {
        super(msg);
    }
}