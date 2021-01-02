/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.io.*;
import java.util.Vector;

import com.gisias.OpenWeather.model.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * Interfaccia che contiene metodi necessari all'implementazione del progetto
 * 
 * @author aiasenzaniro
 *
 */
public interface Methods {
	
	static Vector<String> getCities(){
		Vector<String> citta = new Vector<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("citta.txt"));
			
			String city = reader.readLine();
			while(city != null){
				citta.add(city);
				city = reader.readLine();
			}
			reader.close();
			return citta;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static void fileWriter(String weather, String path, String nomefile) {
		try {
			FileWriter output = new FileWriter(path+"/"+nomefile+".txt",true);
				output.write(weather);
			output.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void writeCurrent() {
		for(String c : getCities()) {
			fileWriter(Parser.currentParser(c), "correnti", c+"cur");
		}
	}
	
	static void writeForecast() {
		for(String c : getCities()) {
			fileWriter(Parser.forecastParser(c), "previsionali", c+"forec");
		}
	}
}
