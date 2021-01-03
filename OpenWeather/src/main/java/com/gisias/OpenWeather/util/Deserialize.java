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
			line = bufRead.readLine();
			while(line != null) {
				JSONParser parser = new JSONParser();
				if(!"".equals(line)){
					Gson gson = new Gson();
					Weather weather = gson.fromJson(line, Weather.class);
					JSONObject jo = new JSONObject();				
					if(weather!=null) {
						if(weather.getDt()==dt) {
							jo.put("cityName", weather.getCityName());
							jo.put("tempMax",weather.getTempMax());
							jo.put("tempMin",weather.getTempMin());
							jo.put("feels_like",weather.getFeels_like());
							return jo;
						}
						else {
							line = bufRead.readLine();
						}
					}
					else {
						line=bufRead.readLine();
					}
				}
				else {
					line = bufRead.readLine();
				}
			}
			bufRead.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
