package com.gisias.OpenWeather.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import org.json.simple.JSONObject;
import com.gisias.OpenWeather.model.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class Deserialize extends StatsFilter{
	
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
}
