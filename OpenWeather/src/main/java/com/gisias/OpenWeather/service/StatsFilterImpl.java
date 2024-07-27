package com.gisias.OpenWeather.service;

import java.text.ParseException;
import java.util.*;

import org.springframework.stereotype.Service;

import com.gisias.OpenWeather.Exception.CityNameException;
import com.gisias.OpenWeather.Exception.DateException;
import com.gisias.OpenWeather.Filter.IndexFilter;
import com.gisias.OpenWeather.Filter.IndexTemporalFilter;
import com.gisias.OpenWeather.Filter.TemporalFilter;
import com.gisias.OpenWeather.Stats.Stats;
import com.gisias.OpenWeather.model.Weather;
import com.gisias.OpenWeather.util.Deserialize;
import com.google.gson.Gson;

/**
 * Class that allows filtering of statistics based on time intervals
 * 
 * @authour Andrea Iasenzaniro
 * @authour Carlo Gissi
 *
 */
@Service
public class StatsFilterImpl extends StatsFilter {
    
    /**
     * Method that retrieves statistics for a city filtered by time interval
     * 
     * @throws ParseException if date parsing fails
     * @throws CityNameException if the city name is invalid or not present in the dataset
     */
    public String getTempStats(TemporalFilter filter) throws DateException, ParseException, CityNameException {
        
        if (StringToDate(filter.getInInstant()) < StringToDate(filter.getFinInstant())) {
            Vector<Double> tempMax = new Vector<Double>();
            Vector<Double> tempMin = new Vector<Double>();
            Vector<Double> realTemp = new Vector<Double>();
            Vector<Double> feelTemp = new Vector<Double>();
            try {
                Vector<Weather> deserialized = Deserialize.deserializeCurrent(filter.getCityName());
                for (Weather weath : deserialized) {
                    if (StringToDate(filter.getInInstant()) < weath.getDt() && StringToDate(filter.getFinInstant()) > weath.getDt()) {
                        realTemp.add(weath.getTemp());
                        tempMax.add(weath.getTempMax());
                        tempMin.add(weath.getTempMin());
                        feelTemp.add(weath.getFeels_like());
                    }
                }

                Stats stats = new Stats(
					Stats.getMaxVal(tempMax), 
					Stats.getMinVal(tempMin), 
					Stats.avgCalculate(realTemp), 
					Stats.varianceCalculate(realTemp), 
					Stats.avgCalculate(feelTemp), 
					Stats.varianceCalculate(feelTemp));
                String statsJson = new Gson().toJson(stats);

                return statsJson;

            } catch (Exception e) {
                throw new CityNameException("City name is incorrect or not present in the dataset");
            }
        } else {
            throw new DateException("Invalid interval, the first date must precede the second");
        }
    }

    /**
     * Method that filters historical data for a city and date
     */
    public String getTempFilter(TemporalFilter filter) throws DateException, ParseException, CityNameException {
        
        if (StringToDate(filter.getInInstant()) < StringToDate(filter.getFinInstant())) {
            Long data1 = StringToDate(filter.getInInstant());
            Long data2 = StringToDate(filter.getFinInstant());
            
            try {
                Vector<Weather> deserialized = Deserialize.deserializeCurrent(filter.getCityName());
                Vector<Weather> found = new Vector<Weather>();
                for (Weather weath : deserialized) {
                    if (data1 < weath.getDt() && data2 > weath.getDt()) {
                        found.add(weath);
                    }
                }
                String filterJson = new Gson().toJson(found);
                return filterJson;
            } catch (Exception e) {
                throw new CityNameException("City name is incorrect or not present in the dataset");
            }
        } else {
            throw new DateException("Invalid interval, the first date must precede the second");
        }
    }

    /**
     * Method that performs comparison between actual and forecasted temperatures on the same day
     */
    @Override
    public String getIndexFilter(IndexTemporalFilter filter) throws DateException, ParseException, CityNameException {
        
        // Throws exception on invalid date
        if (StringToDate(filter.getInInstant()) < StringToDate(filter.getFinInstant())) {
            Long data1 = StringToDate(filter.getInInstant());
            Long data2 = StringToDate(filter.getFinInstant());
            
            // Throws exception on invalid city name
            try {
                Vector<Double> temp = new Vector<Double>();
                int count = 0;
                
                for (Weather weathcur : oneForDay(Deserialize.deserializeCurrent(filter.getCityName()))) {
                    for (Weather weathfor : Deserialize.deserializeForecast(filter.getCityName())) {
						
                        if (data1 < weathcur.getDt() && data2 > weathcur.getDt()) {
                            if (matchDate(unixToDate(weathcur.getDt()), unixToDate(weathfor.getDt()))) {
                                double diff = weathcur.getTemp() - weathfor.getTemp();
                                double round = (double)Math.round(diff * 100d) / 100d;
                                if (round < 0) {
                                    round *= -1;
                                }
                                if (filter.getErrorMarg() > round) {
                                    count++;
                                } else if (round > filter.getErrorMarg()) {
                                    temp.add(round);
                                }
                            }
                        }
                    }
                }
                IndexFilter index = new IndexFilter(unixToString(data1), unixToString(data2), count, temp);
                String result = new Gson().toJson(index);
                return result;
            } catch (Exception e) {
                throw new CityNameException("City name is incorrect or not present in the dataset");
            }
        } else {
            throw new DateException("Invalid interval, the first date must precede the second");
        }
    }
}