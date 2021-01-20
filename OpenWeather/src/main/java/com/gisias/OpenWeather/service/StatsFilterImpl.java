/**
 * 
 */
package com.gisias.OpenWeather.service;
import java.text.ParseException;

import java.util.*;

import org.springframework.stereotype.Service;

import com.gisias.OpenWeather.Exception.CityNameException;
import com.gisias.OpenWeather.Exception.DateException;
import com.gisias.OpenWeather.Filter.IndexFilter;
import com.gisias.OpenWeather.Filter.TempFilter;
import com.gisias.OpenWeather.Filter.IndexTempFilter;
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
     * @throws ParseException 
     * @throws CityNameException 
     */
    public String getTempStats(TempFilter filter) throws DateException, ParseException, CityNameException {
    	
    	if(StringToDate(filter.getInInstant())<StringToDate(filter.getFinInstant())) {
    		Long data1=StringToDate(filter.getInInstant());
        	Long data2=StringToDate(filter.getFinInstant());
        	Vector<Double>tempMax=new Vector<Double>();
        	Vector<Double>tempMin=new Vector<Double>();
        	Vector<Double>realTemp=new Vector<Double>();
        	Vector<Double>feelTemp=new Vector<Double>();
        	try {
        		Vector<Weather> deserialized =Deserialize.deserializeCurrent(filter.getCityName());
            	for(Weather weath: deserialized) {
            		
            		if(data1<weath.getDt() && data2>weath.getDt()) {
            			realTemp.add(weath.getTemp());
            			tempMax.add(weath.getTempMax());
            			tempMin.add(weath.getTempMin());
            			feelTemp.add(weath.getFeels_like());
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
        	
        		
        	}catch(Exception e) {
        		throw new CityNameException("Città inserita erratamente o non presente nel dataset");
        	}
    	}else {
    		throw new DateException("Intervallo non valido, la prima data deve precedere la seconda");
    	}
    }
    /**
     * Metodo che consente di filtrare storico dati per città e data
     */
    public String getTempFilter(TempFilter filter) throws DateException, ParseException, CityNameException {
    	
    	if(StringToDate(filter.getInInstant())<StringToDate(filter.getFinInstant())) {
    		Long data1=StringToDate(filter.getInInstant());
            Long data2=StringToDate(filter.getFinInstant());
            
            try {
            	Vector<Weather> deserialized =Deserialize.deserializeCurrent(filter.getCityName());
            	Vector<Weather> trovati=new Vector<Weather>();
            	for(Weather weath: deserialized) {
            		if(data1<weath.getDt() && data2>weath.getDt()) {
            			trovati.add(weath);
            		}
            	}
            	String filterJson = new Gson().toJson(trovati);
            	return filterJson;
            }catch(Exception e) {
            	throw new CityNameException("Città inserita erratamente o non presente nel dataset");
            }
    	}else {
    		throw new DateException("Intervallo non valido, la prima data deve precedere la seconda");
    	}
    }
	/**
	 *Metodo che consente di effettuare il confronto tra le temperature reali e previsionali di uno stesso giorno
	 */
	@Override
	public String getIndexFilter(IndexTempFilter filter) throws DateException, ParseException, CityNameException {
		
		// Lancia eccezione sulla data
		if(StringToDate(filter.getInInstant())<StringToDate(filter.getFinInstant())) {
			Long data1=StringToDate(filter.getInInstant());
	    	Long data2=StringToDate(filter.getFinInstant());
	    	// Lancia eccezione sul nome della città
	    	try {
	    		Vector<Weather> forec = Deserialize.deserializeForecast(filter.getCityName());
	        	Vector<Weather> curr = oneForDay(Deserialize.deserializeCurrent(filter.getCityName()));
	        	
	        	Vector<Double> temp = new Vector<Double>();
	        	
	        	int cont=0;
	        	
	        	for(Weather weathcur : curr) {
	        		for(Weather weathfor : forec) {
	        			if(data1<weathcur.getDt() && data2>weathcur.getDt()) {
	        				if(matchDate(unixToDate(weathcur.getDt()), unixToDate(weathfor.getDt()))) {
	            				double diff = weathcur.getTemp()-weathfor.getTemp();
	            				double round=(double)Math.round(diff*100d)/100d;
	            				if(round < 0) {
	            					round*=-1;
	            				}
	            				if(filter.getErrorMarg()>round) {
	            					cont++;
		            			}
	            				else if(round>filter.getErrorMarg()) {
	            					temp.add(round);
	            				}
	            				
	            			}
	        			}
	        		}
	        	}
	        	IndexFilter index = new IndexFilter(unixToString(data1),unixToString(data2),cont,temp);
	        	String result = new Gson().toJson(index);
	    		return result;
	    	}catch(Exception e) {
	    		throw new CityNameException("Città inserita erratamente o non presente nel dataset");
	    	}
		}else {
			throw new DateException("Intervallo non valido, la prima data deve precedere la seconda");
		}
	}
}
