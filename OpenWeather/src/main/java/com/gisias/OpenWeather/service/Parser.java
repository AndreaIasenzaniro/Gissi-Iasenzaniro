package com.gisias.OpenWeather.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.gisias.OpenWeather.model.Data;
import com.gisias.OpenWeather.util.Serialize;

/**
 * Classe che contiene metodi che effettuano il parsing Json
 * 
 * @author AndreaIasenzaniro
 * @Author CarloGissi
 *
 */
public class Parser {
	/**
	 * Metodo che effettua il parsing di Current Api 
	 * 
	 * @param cityname nome della città di cui interrogare Api
	 * @return Stringa serializzata delle informazioni della città 
	 */
	public static String currentParser(String cityname) {
		
		String APIKey = "820bf47a49c82ee50491d810263b4bd4";
		String urlString ="http://api.openweathermap.org/data/2.5/weather?q="+ cityname + "&appid=" + APIKey;
		
		try {
			URLConnection openConnection = new URL(urlString).openConnection();
		    InputStream input = openConnection.getInputStream();
		         
		    String result = "";
			String line = "";
				 
			try {
				BufferedReader bufRead = new BufferedReader(new InputStreamReader(input));
				  
				while ((line = bufRead.readLine()) != null) {
					result += line;
				}
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
			}
			return Serialize.currentSerializer(result);
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * Metodo che effettua il parsing di Forecast Api
	 * 
	 * @param cityname nome della città di cui interrogare le Api
	 * @return Stringa serializzata delle informazioni della città
	 */
	public static String forecastParser(String cityname) {
		
		Data data= new Data(cityname);
			
		String APIKey = "820bf47a49c82ee50491d810263b4bd4";
		String urlString ="https://api.openweathermap.org/data/2.5/onecall?lat="+data.getLat()+"&lon="+data.getLon()+"&exclude=minutely,current,hourly&appid=" + APIKey;
			
		try {
			URLConnection openConnection = new URL(urlString).openConnection();
			InputStream input = openConnection.getInputStream();
				
			String result = "";
			String line = "";
				
			try {
				BufferedReader bufRead = new BufferedReader(new InputStreamReader(input));
				while((line = bufRead.readLine()) != null) {
					result += line;
				}	
			}catch(IOException e) {
				e.printStackTrace();
				return null;
			}finally {
				input.close();
			}
			return Serialize.forecastSerializer(result, cityname);
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
			return null;
	}

}
