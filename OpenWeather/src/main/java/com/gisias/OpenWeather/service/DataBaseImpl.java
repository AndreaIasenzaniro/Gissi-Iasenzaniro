/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.util.Vector;

import org.springframework.stereotype.Service;

import com.gisias.OpenWeather.model.MetaData;
import com.google.gson.Gson;

/**
 * @author aiasenzaniro
 *
 */
@Service
public class DataBaseImpl extends DataBase {

	static Vector<MetaData> metadata = new Vector<MetaData>();
	@Override
	public Vector<MetaData> getMetaData(){
		metadata.add(new MetaData("cityName", "Nome della citta","String"));
		metadata.add(new MetaData("dt", "Periodo di riferimento","String"));
		metadata.add(new MetaData("clouds", "Nuvolosità della città nel periodo considerato","String"));
		metadata.add(new MetaData("temp", "Temperatura della città nel periodo considerato","String"));
		metadata.add(new MetaData("feels_like", "Temperatura percepita della città nel periodo considerato","String"));
		metadata.add(new MetaData("tempMax", "Temperatura massima della città nel periodo considerato","String"));
		metadata.add(new MetaData("tempMin", "Temperatura minima della città nel periodo considerato","String"));
		metadata.add(new MetaData("wind_speed", "Ventosità della città nel periodo considerato","String"));
		return metadata;
	}
	@Override
	public String parsMetaData(Vector<MetaData> metadata) {
		Gson gson = new Gson();
		String stringa = gson.toJson(metadata);
		return stringa;
	}
}
