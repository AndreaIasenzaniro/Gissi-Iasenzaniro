/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.io.*;

import java.util.Vector;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Classe che contiene metodi necessari all'implementazione del progetto
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
@SuppressWarnings("unused")
@Service
public class Methods {
	
	/**
	 * Metodo che legge da file le città da utilizzare per popolare il dataset
	 * 
	 * @return Vettore di tipo stringa
	 */
	public static Vector<String> getCities(){
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
	
	/**
	 * Metodo utilizzato per scrivere in append su file 
	 * 
	 * @param weather stringa passata come parametro
	 * @param path percorso del file
	 * @param nomefile nome da assegnare al file
	 */
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
	/**
	 * Metodo che scrive su file a cadenza oraria le previsioni correnti
	 */
	//@Scheduled(cron="0 0 * * * *")
	public static void writeCurrent() {
		for(String c : getCities()) {
			fileWriter(Parser.currentParser(c), "correnti", c);
		}
	}
	/**
	 * Metodo che scrive su file le previsioni future settimanali
	 */
	//@Scheduled(fixedRate=10080*60*1000)
	public static void writeForecast() {
		for(String c : getCities()) {
			fileWriter(Parser.forecastParser(c), "previsionali", c);
		}
	}
	
}
