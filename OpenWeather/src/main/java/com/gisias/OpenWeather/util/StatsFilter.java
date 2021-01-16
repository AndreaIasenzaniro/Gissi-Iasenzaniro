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

/**
 * @author aiasenzaniro
 *
 */
@Service
public class StatsFilter {
    
    public String getTempFilter(TempFilter filter) throws Exception  {
    	
    	Date data1=Methods.StringToDate(filter.getInInstant());
    	Date data2=Methods.StringToDate(filter.getFinInstant());
    	Vector<Double>tempMax=new Vector<Double>();
    	Vector<Double>tempMin=new Vector<Double>();
    	Vector<Double>temp=new Vector<Double>();
    	Vector<Weather> deserialized =Deserialize.deserializeCurrent(filter.getCityName());
    	for(Weather weath: deserialized) {
    		if(data1.after(Methods.DataConverter(weath.getDt())) && data2.before(Methods.DataConverter(weath.getDt()))) {
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
    	
    	Stats stats = new Stats(tMax,tMin,avg,variance);
    	return stats.toString();
    	//JsonObject jelement = (JsonObject) new JsonParser().parse(stats.toString());
    	//return jelement.toString();
    	
    }
   
}
