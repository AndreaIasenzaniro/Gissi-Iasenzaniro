/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.gisias.OpenWeather.Filter.TempFilter;
import com.gisias.OpenWeather.Stats.Stats;
import com.gisias.OpenWeather.model.Weather;
import com.gisias.OpenWeather.util.Deserialize;
import com.google.gson.Gson;

/**
 * Classe che consente di effettuare filtraggio temporale delle statistiche
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
@Service
public class StatsFilterImpl extends StatsFilter{
    
    /**
     * Metodo che consente di ottenere statistiche di una città filtrate temporalmente
     * 
     * @param filter oggetto filter passato per ottenere statistiche
     * @return Stringa Json con le statistiche nel periodo richiesto
     * @throws Exception
     */
    public String getTempStats(TempFilter filter) throws Exception  {
    	
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
    			//Lancia eccezione per inserimento sbagliato delle date(try catch)
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
    	String statsJson = gson.toJson(stats);
    	return statsJson;
    	
    }
    /**
     * Metodo che consente di filtrare storico dati per città e data
     * 
     * @param filter oggetto filter passato per ottenere storico dati filtrato
     * @return Stringa Json con lo storico nel periodo richiesto
     * @throws Exception
     */
    public String getTempFilter(TempFilter filter) throws Exception  {
    	
    	Long data1=StringToDate(filter.getInInstant());
    	Long data2=StringToDate(filter.getFinInstant());
    	
    	Vector<Weather> deserialized =Deserialize.deserializeCurrent(filter.getCityName());
    	Vector<Weather> trovati=new Vector<Weather>();
    	for(Weather weath: deserialized) {
    		 {
    			
    			trovati.add(weath);
    		}
    		else {
    			//Lancia eccezione per inserimento sbagliato delle date
    		}
    	}
    	String filterJson = new Gson().toJson(trovati);
    	return filterJson;
    	
    }
	@Override
	public String getIndexFilter(TempFilter filter) throws Exception {
		
		Long data1=StringToDate(filter.getInInstant());
    	Long data2=StringToDate(filter.getFinInstant());
    	
    	Vector<Double>temp=new Vector<Double>();
    	
    	
    	Vector<Weather> deserializeCur =Deserialize.deserializeCurrent(filter.getCityName());
    	Vector<Weather> deserializeFor =Deserialize.deserializeForecast(filter.getCityName());
    	
    	for(Weather weathCur : deserializeCur) {
    		if(data1<weathCur.getDt() && data2>weathCur.getDt()) {
    			for(Weather weathFor : deserializeFor) {
    				if(data1<weathFor.getDt() && data2>weathFor.getDt()) {
    					
    					temp.add(weathCur.getTemp());
    					Double tMax=Stats.getMaxVal(temp);
    				}
    			}
    		}
    	}
    	
    	
    	
	}
    
    
    
   
}
