/**
 * 
 */
package com.gisias.OpenWeather.util;

import java.util.*;

import org.springframework.stereotype.Service;

import com.gisias.OpenWeather.Filter.TempFilter;
import com.gisias.OpenWeather.Stats.Stats;
import com.gisias.OpenWeather.model.Weather;
import com.gisias.OpenWeather.service.Methods;
import com.google.gson.Gson;

/**
 * @author aiasenzaniro
 *
 */
@Service
public class StatsFilter {
    
    public String getTempFilter(TempFilter filter) throws Exception  {
    	
    	Long data1=Methods.StringToDate(filter.getInInstant());
    	Long data2=Methods.StringToDate(filter.getFinInstant());
    	Vector<Double>tempMax=new Vector<Double>();
    	Vector<Double>tempMin=new Vector<Double>();
    	Vector<Double>temp=new Vector<Double>();
    	Vector<Weather> deserialized =Deserialize.deserializeCurrent(filter.getCityName());
    	for(Weather weath: deserialized) {
    		if(data1<weath.getDt() && data2>weath.getDt()) {
    			temp.add(weath.getTemp());
    			tempMax.add(weath.getTempMax());
    			tempMin.add(weath.getTempMin());
    		}
    		else {
    			//Lancia eccezione per inserimento sbagliato delle date
    		}
    	}
    	Double tMax=Stats.getMaxVal(tempMax);
    	Double tMin=Stats.getMinVal(tempMin);
    	Double avg=Stats.avgCalculate(temp);
    	Double variance=Stats.varianceCalculate(temp);
    	
    	Gson gson = new Gson();
    	Stats stats = new Stats(tMax,tMin,avg,variance);
    	String StatsSetJson = gson.toJson(stats);
    	return StatsSetJson;
    	
    }
   
}
