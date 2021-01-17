/**
 * 
 */
package com.gisias.OpenWeather.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

import org.springframework.stereotype.Service;

import com.gisias.OpenWeather.Filter.TempFilter;
import com.gisias.OpenWeather.Stats.Stats;
import com.gisias.OpenWeather.model.Weather;
import com.gisias.OpenWeather.service.Methods;
import com.google.gson.Gson;

/**
 * Classe che consente di effettuare filtraggio temporale delle statistiche
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
@Service
public class StatsFilter {
    
    /**
     * Metodo che consente di ottenere statistiche di una città filtrate temporalmente
     * @param filter oggetto filter passato per ottenere statistiche
     * @return Stringa Json con le statistiche nel periodo richiesto
     * @throws Exception
     */
    public String getTempFilter(TempFilter filter) throws Exception  {
    	
    	Long data1=StringToDate(filter.getInInstant());
    	Long data2=StringToDate(filter.getFinInstant());
    	Vector<Double>tempMax=new Vector<Double>();
    	Vector<Double>tempMin=new Vector<Double>();
    	Vector<Double>realTemp=new Vector<Double>();
    	Vector<Double>feelTemp=new Vector<Double>();
    	Vector<Weather> deserialized =Deserialize.deserializeCurrent(filter.getCityName());
    	for(Weather weath: deserialized) {
    		if(data1<weath.getDt() && data2>weath.getDt()) {
    			realTemp.add(weath.getTemp());
    			tempMax.add(weath.getTempMax());
    			tempMin.add(weath.getTempMin());
    			feelTemp.add(weath.getFeels_like());
    		}
    		else {
    			//Lancia eccezione per inserimento sbagliato delle date
    		}
    	}
    	Double tMax=Stats.getMaxVal(tempMax);
    	Double tMin=Stats.getMinVal(tempMin);
    	Double realAvg=Stats.avgCalculate(realTemp);
    	Double realVariance=Stats.varianceCalculate(realTemp);
    	Double feelAvg=Stats.avgCalculate(feelTemp);
    	Double feelVariance=Stats.varianceCalculate(feelTemp);
    	
    	Gson gson = new Gson();
    	Stats stats = new Stats(tMax,tMin,realAvg,realVariance,feelAvg,feelVariance);
    	String StatsSetJson = gson.toJson(stats);
    	return StatsSetJson;
    	
    }
    /**
     * Metodo che consente di trasformare una stringa in data
     * @param date data in formato stringa da convertire
     * @return long della data inserita
     * @throws ParseException
     */
    public static Long StringToDate(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Instant data = df.parse(date).toInstant();
		long epoch = data.getEpochSecond();
		return epoch;
   }
   
}
