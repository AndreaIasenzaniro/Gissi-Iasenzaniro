package com.gisias.OpenWeather.Exception;

/**
 * @author AndreaIasenzaniro
 * @author CarloGissi
 * 
 * Classe che gestisce l'eccezione lanciata in caso di prima data maggiore della seconda in un intervallo
 *
 */
@SuppressWarnings("serial")
public class DateException extends Exception{
	
	public DateException() {
		 super();
	}
	 
	public DateException(String msg){
		 super(msg);
	 }

}
