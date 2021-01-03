package com.gisias.OpenWeather.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.gisias.OpenWeather.model.Weather;
import com.google.gson.Gson;

public class Deserialize {

	@SuppressWarnings("unchecked")
	public static  JSONObject deserialize(String cityName, Long dt) {
		String result = "";
		String line = "";
		String path= "correnti";
		
		try {
			BufferedReader bufRead = new BufferedReader( new FileReader(path+"/"+cityName+".txt"));
			while((line = bufRead.readLine()) != null) {
				Gson gson = new Gson();
				Weather weather = gson.fromJson(line, Weather.class);
				JSONObject jo = new JSONObject();
				JSONParser parser = new JSONParser();
				if(!"".equals(line)){
				if(weather!=null) {
					if(weather.getDt()==dt) {
						jo.put("tempMax",weather.getTempMax());
						jo.put("tempMin",weather.getTempMin());
						jo.put("feels_like",weather.getFeels_like());
						return jo;
					}
					else {
						result+=line;
						JSONObject obj =(JSONObject)parser.parse(result);
						return obj;
					}
				}
				else {
					result+=line;
					parser.parse(result);
					JSONObject obj =(JSONObject)parser.parse(result);
					return obj;
				}
			}
			}
			bufRead.close();
		}catch(IOException | ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
