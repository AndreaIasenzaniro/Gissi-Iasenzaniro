/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.util.Vector;

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
	public Vector<MetaData> getMetaData();
	/**
	 * Dichiarazione metodo astratto che effettua parsing del vettore di MetaData
	 * 
	 * @param metadata vettore di cui si effettua il parsing
	 * @return Stringa Json del vettore passato come parametro
	 */
	public String parsMetaData(Vector<MetaData> metadata);

}
