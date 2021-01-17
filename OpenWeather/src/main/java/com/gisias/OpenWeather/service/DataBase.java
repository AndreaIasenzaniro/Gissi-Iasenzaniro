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
public abstract class DataBase {
	
	public abstract Vector<MetaData> getMetaData();
	public abstract String parsMetaData(Vector<MetaData> metadata);

}
