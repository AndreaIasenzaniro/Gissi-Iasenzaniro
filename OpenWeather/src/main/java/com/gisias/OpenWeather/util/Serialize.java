/**
 * 
 */
package com.gisias.OpenWeather.util;

import java.util.Vector;

import com.gisias.OpenWeather.model.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Classe che contiene metodi che permettono di effettuare la serializzazione
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
public class Serialize {
	/**
	 * Metodo che serializza un JsonObject popolando un oggetto di tipo Weather
	 * 
	 * @param toSerialize Stringa in ingresso da cui estrarre i campi da assegnare
	 * @return Stringa in formato Json dell'oggetto serializzato
	 */
	public static String currentSerializer(String toSerialize) {
		Weather weather = new Weather();
		JsonElement jelement = new JsonParser().parse(toSerialize);
	    JsonObject  wth = jelement.getAsJsonObject();
	    weather.setCityName(wth.get("name").toString());
	    weather.setDt(wth.get("dt").getAsLong());
	    JsonObject clouds = wth.getAsJsonObject("clouds");
	    weather.setClouds(clouds.get("all").getAsDouble());
	    JsonObject main = wth.getAsJsonObject("main");
	    weather.setFeels_like(main.get("feels_like").getAsDouble());
	    weather.setTemp(main.get("temp").getAsDouble());
	    weather.setTempMax(main.get("temp_max").getAsDouble());
	    weather.setTempMin(main.get("temp_min").getAsDouble());
	    JsonObject wind = wth.getAsJsonObject("wind");
	    weather.setWind_speed(wind.get("speed").getAsDouble());
	    JsonObject coord = wth.getAsJsonObject("coord");
	    weather.setLat(coord.get("lat").getAsDouble());
	    weather.setLon(coord.get("lon").getAsDouble());
	    
		
	    
	    Gson gson = new Gson();
		String weath = gson.toJson(weather);
		return weath;
	}
	/**
	 * @param toSerialize
	 * @param cityname
	 * @return
	 */
	public static String forecastSerializer(String toSerialize,String cityname) {
		
		Vector<Weather> weathers = new Vector<Weather>();
		
		JsonElement jelement =new JsonParser().parse(toSerialize);
	    JsonObject  wth = jelement.getAsJsonObject();
	    
	    Double lat = (wth.get("lat").getAsDouble());
		Double lon = (wth.get("lon").getAsDouble());
	    
	    JsonArray daily = wth.getAsJsonArray("daily");
	    for(JsonElement o: daily) {
	    	if(o instanceof JsonObject) {
	    		Weather weather = new Weather();
	    		weather.setCityName(cityname);
	    		JsonObject obj = (JsonObject) o;
	    		weather.setDt(obj.get("dt").getAsLong());
	    		weather.setClouds(obj.get("clouds").getAsDouble());
	    		weather.setWind_speed(obj.get("wind_speed").getAsDouble());
	    		JsonObject feels = (JsonObject) obj.get("feels_like");
	    		weather.setFeels_like(feels.get("day").getAsDouble());
	    		JsonObject temp = (JsonObject) obj.get("temp");
	    		weather.setTemp(temp.get("day").getAsDouble());
	    		weather.setTempMax(temp.get("max").getAsDouble());
	    		weather.setTempMin(temp.get("min").getAsDouble());
	    		weather.setLat(lat);
	    		weather.setLon(lon);
	    		
	    		weathers.add(weather);
	    	}
	    }
	    Gson gson = new Gson();
		String weath = gson.toJsonTree(weathers).toString();
		return weath;
	}

}
