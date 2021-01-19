package com.gisias.OpenWeather.Exception;

/**
 * @author AndreaIasenzaniro
 * @author CarloGissi
 * 
 * Classe che gestisce l'eccezione lanciata in caso di città non presente nel dataset
 *
 */
@SuppressWarnings("serial")
public class CityNameException extends Exception {
	 
	public CityNameException() {
		 super();
	}
	 
	 public CityNameException(String msg){
		 super(msg);
	 }

}
