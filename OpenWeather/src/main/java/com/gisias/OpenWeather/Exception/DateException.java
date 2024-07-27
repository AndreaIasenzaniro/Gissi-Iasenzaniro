package com.gisias.OpenWeather.Exception;

/**
 * Class that handles the exception thrown when the start date is greater than the end date in an interval
 * 
 * @author Andrea Iasenzaniro
 * @author Carlo Gissi
 *
 */
public class DateException extends Exception {

    public DateException() {
        super();
    }

    public DateException(String msg) {
        super(msg);
    }
}