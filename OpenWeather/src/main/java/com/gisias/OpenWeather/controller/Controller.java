package com.gisias.OpenWeather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gisias.OpenWeather.Exception.DateException;
import com.gisias.OpenWeather.Filter.IndexTemporalFilter;
import com.gisias.OpenWeather.Filter.TemporalFilter;
import com.gisias.OpenWeather.service.DataBase;
import com.gisias.OpenWeather.service.Parser;
import com.gisias.OpenWeather.service.StatsFilterImpl;
import com.gisias.OpenWeather.util.Deserialize;
import com.google.gson.Gson;

/**
 * Controller for the OpenWeather application
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
@RestController
public class Controller {

    @Autowired
    private DataBase database;
    @Autowired
    private StatsFilterImpl statsfilter;
    @Autowired
    private Parser parser;

    /**
     * Endpoint that provides metadata interpretation and meaning of the data
     * 
     * @return JSON vector of Metadata
     */
    @GetMapping("/metadata")
    public ResponseEntity<Object> getMetaData() {
        return new ResponseEntity<>(database.getMetaData(), HttpStatus.OK);
    }

    /**
     * Endpoint that displays current weather forecasts for a city by querying the OpenWeather API
     * 
     * @param city the name of the city to search for
     * @return JSON string of the Weather object
     */
    @GetMapping("/current")
    public ResponseEntity<Object> currentParser(@RequestParam(value = "city") String city) {
        return new ResponseEntity<>(parser.currentParser(city), HttpStatus.OK);
    }

    /**
     * Endpoint to obtain filtered statistics for a selected city over a specified time interval
     * 
     * @param filter a Filter object containing the city and search interval
     * @return JSON string with data on the maximum and minimum temperatures (real and perceived), average, and variance
     * @throws Exception if an error occurs during processing
     */
    @GetMapping("/currentstats")
    public String getTempStats(@RequestBody TemporalFilter filter) throws Exception {
        return statsfilter.getTempStats(filter);
    }

    /**
     * Endpoint that returns historical hourly forecasts for a specified city over a user-defined time period
     * 
     * @param filter a Filter object containing the city and search interval
     * @return JSON string of a Vector of Weather objects
     * @throws Exception if an error occurs during processing
     */
    @GetMapping("/currentfilter")
    public String getTempFilter(@RequestBody TemporalFilter filter) throws Exception {
        if ((filter.getInInstant() == "") && (filter.getFinInstant() == "")) {
            String stringa = new Gson().toJson(Deserialize.deserializeCurrent(filter.getCityName()));
            return stringa;
        }
        if ((filter.getInInstant() == "") || (filter.getFinInstant() == "")) {
            throw new DateException("Invalid interval");
        } else {
            return statsfilter.getTempFilter(filter);
        }
    }

    /**
     * Endpoint that filters historical data based on the accuracy of the forecast within a given margin of error
     * 
     * @param filter a Filter object containing the city, search interval, and margin of error
     * @return JSON string of an IndexFilter object
     * @throws Exception if an error occurs during processing
     */
    @GetMapping("/index")
    public String getIndexFilter(@RequestBody IndexTemporalFilter filter) throws Exception {
        return statsfilter.getIndexFilter(filter);
    }
}