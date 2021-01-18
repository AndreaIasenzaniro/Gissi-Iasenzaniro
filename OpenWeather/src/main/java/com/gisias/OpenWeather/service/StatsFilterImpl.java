/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.gisias.OpenWeather.Filter.IndexFilter;
import com.gisias.OpenWeather.Filter.TempFilter;
import com.gisias.OpenWeather.Filter.xxxxxx;
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
    			//Lancia eccezione per inserimento sbagliato delle date(try cat
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
    		if(data1<weath.getDt() && data2>weath.getDt()) {
    			
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
	public String getIndexFilter(xxxxxx filter) throws Exception {
		
		Long data1=StringToDate(filter.getInInstant());
    	Long data2=StringToDate(filter.getFinInstant());
    	
    	Vector<Weather> forec = Deserialize.deserializeForecast(filter.getCityName());
    	Vector<Weather> curr = oneForDay(Deserialize.deserializeCurrent(filter.getCityName()));
    	
    	Vector<IndexFilter> temp = new Vector<IndexFilter>();
    	
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
        					IndexFilter index = new IndexFilter(unixToString(weathcur.getDt()),round);
            				temp.add(index);
        				}
        			}
    			}
    		}
    	}
    	String indice = new Gson().toJson(temp);
		return indice;
    	
	}
}
