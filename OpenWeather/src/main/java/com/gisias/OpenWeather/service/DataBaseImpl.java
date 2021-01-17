/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.util.Vector;

import org.springframework.stereotype.Service;

import com.gisias.OpenWeather.model.MetaData;
import com.google.gson.Gson;

/**
 * Implementazione della classe astratta DataBase
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
@Service
public class DataBaseImpl extends DataBase {

	static Vector<MetaData> metadata = new Vector<MetaData>();
	/**
	 *Metodo che popola un Vettore di tipo Metadata con le relative informazioni
	 */
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
		metadata.add(new MetaData("inInstant", "Inizio intervallo di ricerca nel formato dd/MM/yy HH:mm:ss", "String"));
		metadata.add(new MetaData("finInstant", "Fine intervallo di ricerca nel formato dd/MM/yy HH:mm:ss", "String"));
		metadata.add(new MetaData("max", "temperatura massima nell'intervallo richiesto", "double"));
		metadata.add(new MetaData("min", "temperatura minima nell'intervallo richiesto", "double"));
		metadata.add(new MetaData("avg", "media delle temperature nell'intervallo richiesto", "double"));
		metadata.add(new MetaData("variance", "varianza delle temperature nell'intervallo richiesto", "double"));
		return metadata;
	}
	/**
	 *Metodo che effettua il parsing di un Vector di MetaData e restituisce una Stringa in formato Json
	 */
	@Override
	public String parsMetaData(Vector<MetaData> metadata) {
		Gson gson = new Gson();
		String stringa = gson.toJson(metadata);
		return stringa;
	}
}
