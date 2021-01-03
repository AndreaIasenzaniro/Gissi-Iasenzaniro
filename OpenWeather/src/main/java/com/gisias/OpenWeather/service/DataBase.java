/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.util.Vector;

import com.gisias.OpenWeather.model.MetaData;
/**
 * @author aiasenzaniro
 *
 */
public abstract class DataBase {
	
	public abstract Vector<MetaData> getMetaData();
	public abstract String parsMetaData(Vector<MetaData> metadata);

}
