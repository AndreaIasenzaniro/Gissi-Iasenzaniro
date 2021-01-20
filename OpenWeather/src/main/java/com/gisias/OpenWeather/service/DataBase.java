/**
 * 
 */
package com.gisias.OpenWeather.service;

/**
 * Classe astratta con metodi che consentono di ottenere MetaData
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
public interface DataBase {
	
	/**
	 * Dichiarazione metodo astratto che restituisce MetaDEata
	 * 
	 * @return vettore di tipo Metadata
	 */
	public String getMetaData();
}
