/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.io.*;
import java.util.Vector;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.gisias.OpenWeather.model.Weather;
/**
 * Classe che contiene metodi necessari all'implementazione del progetto
 * 
 * @author AndreaIasenzaniro
 * @author carloGissi
 *
 */
@Service
public class Methods {
	
	protected static Vector<String> getCities(){
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
	
	protected static void fileWriter(String weather, String path, String nomefile) {
		try {
			FileWriter output = new FileWriter(path+"/"+nomefile+".txt",true);
				output.write(weather);
				output.write("\n");
			output.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void fileWriter2(String stringa, String nomefile) {
		try {
			FileWriter output = new FileWriter("prova/"+nomefile+".txt");
				output.write(stringa);
			output.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Scheduled(cron="0 0 * * * *")
	public static void writeCurrent() {
		for(String c : getCities()) {
			fileWriter(Parser.currentParser(c), "correnti", c);
		}
	}
	public static void writeForecast() {
		for(String c : getCities()) {
			fileWriter(Parser.forecastParser(c), "previsionali", c);
		}
	}
	
}
