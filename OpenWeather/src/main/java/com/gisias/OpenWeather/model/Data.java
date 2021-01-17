/**
 * 
 */
package com.gisias.OpenWeather.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Classe ausiliaria che permette di ottenere coordinate di una città, dato il suo nome
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
public class Data {
	
	String cityName;
	double lat;
	double lon;
	/**
	 * @param cityName nome della città
	 */
	public Data(String cityName) {
		this.cityName = cityName;
		getCoord();
	}
	/**
	 * Costruttore vuoto della classe Data
	 */
	public Data(){
		
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	/**
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}
	/**
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}
	/**
	 * Metodo che permette di popolare automaticamente le coordinate della città, dato il nome, nel costruttore della classe
	 */
	void getCoord() {
		String APIKey = "820bf47a49c82ee50491d810263b4bd4";
		String urlString ="http://api.openweathermap.org/data/2.5/weather?q="+ getCityName() + "&appid=" + APIKey;
		JSONParser parser = new JSONParser();
		
		try {
			 URLConnection openConnection = new URL(urlString).openConnection();
	    
	         InputStream in = openConnection.getInputStream();
	         
			 String result = "";
			 String line = "";
			 try {
				 InputStreamReader inR = new InputStreamReader(in);
				 BufferedReader buf = new BufferedReader(inR);
			  
				 while ((line = buf.readLine()) != null) {
					 result += line;
				 }
			 } catch (IOException e) {
				 e.printStackTrace();
			 }finally {
				 in.close();
			 }
			
			 JSONObject jo = (JSONObject) parser.parse(result);

	         JSONObject coord = (JSONObject) jo.get("coord");
	         Double lat = Double.parseDouble(coord.get("lat").toString());
	         Double lon = Double.parseDouble(coord.get("lon").toString());
	         
	         this.setLat(lat);
	         this.setLon(lon);
	        

			 } catch(Exception e){
				 e.printStackTrace();
			 }
	}

}
