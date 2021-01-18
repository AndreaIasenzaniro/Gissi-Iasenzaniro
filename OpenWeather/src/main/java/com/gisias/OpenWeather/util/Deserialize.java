package com.gisias.OpenWeather.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import com.gisias.OpenWeather.Filter.ProvaWeatherFilter;
import com.gisias.OpenWeather.Stats.Stats;
import com.gisias.OpenWeather.model.Weather;
import com.gisias.OpenWeather.service.StatsFilter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Classe che effettua la deserializzazione di un file in formato Json
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
public class Deserialize {
	/**
	 * Metodo che deserializza file contenente dati relativi alle Current Api
	 * @param cityName nome del file della città da deserializzare
	 * @return vettore di tipo weather relativo alla città deserializzata
	 */
	@SuppressWarnings("resource")
	public static Vector<Weather> deserializeCurrent(String cityName) {
		String result="";
		String line="";
		String path="correnti";
		Vector<Weather>wth= new Vector<Weather>();
		try {
			BufferedReader bufRead = new BufferedReader(new FileReader(path+"/"+cityName+".txt"));
			while((line=bufRead.readLine())!=null) {
				Gson gson = new Gson();
				result=line;
				Weather weather = gson.fromJson(result, Weather.class);
				wth.add(weather);
			}
			return wth;
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String oneForDay(Vector<Weather> current){
		
		
		Vector<ProvaWeatherFilter> filter = new Vector<ProvaWeatherFilter>();
		
		Vector<Double>realTemp=new Vector<Double>();
		
		for(int i=0; i<current.size(); i++) {
			while(StatsFilter.matchDate(StatsFilter.unixToDate(current.get(i).getDt()), StatsFilter.unixToDate(current.get(i+1).getDt()))){
				realTemp.add(current.get(i).getTemp());
			}
			long dt = current.get(i).getDt();
			Double realtemp = Stats.avgCalculate(realTemp);
			
			ProvaWeatherFilter prova = new ProvaWeatherFilter(dt,realtemp);
			filter.add(prova);
		}
		String stringa = new Gson().toJson(filter);
		return stringa;
	}
	/**
	 * Metodo che deserializza file contenente dati relativi alle Current Api
	 * @param cityName nome del file della città da deserializzare
	 * @return vettore di tipo weather relativo alla città deserializzata
	 */
	public static Vector<Weather> deserializeForecast(String cityName) {
		String path="previsionali";
		try {
			BufferedReader bufRead = new BufferedReader(new FileReader(path+"/"+cityName+".txt"));
		
			Vector<Weather> wth = new Gson().fromJson(bufRead, new TypeToken<Vector<Weather>>() {}.getType());
			bufRead.close();
			    
			return wth;
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
