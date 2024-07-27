package com.gisias.OpenWeather.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

import com.gisias.OpenWeather.Filter.IndexTemporalFilter;
import com.gisias.OpenWeather.Filter.TemporalFilter;
import com.gisias.OpenWeather.model.Weather;

/**
 * Abstract class containing declarations of filtering methods
 * 
 * @authour Andrea Iasenzaniro
 * @authour Carlo Gissi
 *
 */
public abstract class StatsFilter {
    
    /**
     * Method that converts a string to a date
     * 
     * @param date date in string format to convert
     * @return long representation of the input date
     * @throws ParseException if the date string is not in the expected format
     */
    public static Long StringToDate(String date) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Instant data = df.parse(date).toInstant();
        long epoch = data.getEpochSecond();
        return epoch;
    }

    /**
     * Method that converts a long (Unix timestamp) to a Date object
     * 
     * @param unixDate date in Unix timestamp format
     * @return Date object representation of the input Unix timestamp
     */
    public static Date unixToDate(long unixDate) {
        long unixSeconds = unixDate;
        Date date = new Date(unixSeconds * 1000L);
        return date;
    }

    /**
     * Method that converts a long (Unix timestamp) to a string
     * 
     * @param millis date in Unix timestamp format
     * @return string representation of the input Unix timestamp
     */
    protected static String unixToString(long millis) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis * 1000L);
        return format.format(cal.getTime());
    }

    /**
     * Method that compares two dates based on the day of the year only
     * 
     * @param date1 date in Date format
     * @param date2 date in Date format
     * @return boolean true if the dates have the same day of the year
     */
    public static boolean matchDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                          cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        return sameDay;
    }

    /**
     * Method that reads a vector of type Weather and returns a vector of the same type containing only one record for each day
     * 
     * @param current vector of type Weather from which to extract the forecasts
     * @return vector of type Weather
     */
    public static Vector<Weather> oneForDay(Vector<Weather> current) {
        
        Vector<Weather> oneFor = new Vector<Weather>();
        Date date = new Date();
        for (Weather weather : current) {
            Date tempDate = unixToDate(weather.getDt());
            if (matchDate(date, tempDate)) {
                date = tempDate;                
            } else {
                oneFor.add(weather);
                date = tempDate;
            }
        }
        return oneFor;
    }

    /**
     * Declaration of an abstract method to obtain temporal statistics
     * 
     * @param filter object of type TemporalFilter
     * @return JSON string of the Stats object
     */
    public abstract String getTempStats(TemporalFilter filter) throws Exception;

    /**
     * Declaration of an abstract method to apply temporal filters
     * 
     * @param filter object of type TemporalFilter
     * @return JSON string of the Weather object
     */
    public abstract String getTempFilter(TemporalFilter filter) throws Exception;

    /**
     * Declaration of an abstract method to apply a filter based on error margin
     * 
     * @param filter object of type IndexTemporalFilter
     * @return JSON string of the IndexFilter object
     */
    public abstract String getIndexFilter(IndexTemporalFilter filter) throws Exception;
}