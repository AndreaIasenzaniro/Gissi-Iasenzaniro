package com.gisias.OpenWeather.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import org.json.simple.parser.JSONParser;

import com.gisias.OpenWeather.model.Data;
import com.gisias.OpenWeather.model.Weather;
import com.gisias.OpenWeather.util.Serializer;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Parser {
	/**
	 * @param cityname
	 * @return
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
			return Serializer.currentSerializer(result);
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public static String forecastParser(String cityname) {
		
		Data data= new Data(cityname);
			
		String APIKey = "820bf47a49c82ee50491d810263b4bd4";
		String urlString ="https://api.openweathermap.org/data/2.5/onecall?lat="+data.getLat()+"&lon="+data.getLon()+"&exclude=minutely,current,hourly&appid=" + APIKey;
		JSONParser parser = new JSONParser();
			
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
			return Serializer.forecastSerializer(result, cityname);
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
			return null;
	}

}
