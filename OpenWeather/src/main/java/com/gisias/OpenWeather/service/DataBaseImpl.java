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
public class DataBaseImpl implements DataBase {

	
	/**
	 *Metodo che popola un Vettore di tipo Metadata con le relative informazioni
	 */
	@Override
	public String getMetaData(){
		
		Vector<MetaData> metadata = new Vector<MetaData>();
		
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
		metadata.add(new MetaData("realAvg", "media delle temperature reali nell'intervallo richiesto", "double"));
		metadata.add(new MetaData("realVariance", "varianza delle temperature reali nell'intervallo richiesto", "double"));
		metadata.add(new MetaData("feelAvg", "media delle temperature percepite nell'intervallo richiesto", "double"));
		metadata.add(new MetaData("feelVariance", "varianza delle temperature percepite nell'intervallo richiesto", "double"));
		metadata.add(new MetaData("errorMarg", "errore marginale nel calcolo delle previsioni rispetto alla realtà", "double"));
		metadata.add(new MetaData("dateIn", "Inizio intervallo di ricerca nel formato dd/MM/yy", "String"));
		metadata.add(new MetaData("dateFin", "Fine intervallo di ricerca nel formato dd/MM/yy", "String"));
		metadata.add(new MetaData("correct", "Quantità di previsioni azzeccate nell'intervallo richiesto", "int"));
		metadata.add(new MetaData("uncorrectTemp", "Vettore di temperature non azzeccate in base all'errore dato", "Vector<Double>"));
		
		String stringa = new Gson().toJson(metadata);
		return stringa;
	}
}
