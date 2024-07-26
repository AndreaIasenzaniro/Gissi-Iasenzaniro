/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.util.List;

import com.gisias.OpenWeather.model.MetaData;

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
	public List<MetaData> getMetaData();
}
