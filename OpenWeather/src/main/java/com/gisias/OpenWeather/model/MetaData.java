/**
 * 
 */
package com.gisias.OpenWeather.model;

/**
 * Classe che permette di creare un oggetto metadata, relativo alle informazioni sui dati utilizzati
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
public class MetaData {

	String Alias;
	String sourceField;
	String type;
	/**
	 * @param alias nome della variabile utilizzata
	 * @param sourceField significato del nome della variabile
	 * @param type tipo della variabile
	 */
	public MetaData(String alias, String sourceField, String type) {
		Alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}
	
	
}
