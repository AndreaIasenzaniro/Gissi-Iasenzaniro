/**
 * 
 */
package com.gisias.OpenWeather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gisias.OpenWeather.Filter.TempFilter;
import com.gisias.OpenWeather.Filter.IndexTempFilter;
import com.gisias.OpenWeather.service.DataBase;
import com.gisias.OpenWeather.service.DataBaseImpl;
import com.gisias.OpenWeather.service.Parser;
import com.gisias.OpenWeather.service.StatsFilterImpl;
import com.gisias.OpenWeather.util.Deserialize;
import com.google.gson.Gson;

/**
 * Controller dell'applicativo OpenWeather
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
@RestController
public class Controller {

	@Autowired
	DataBase database;
	@Autowired
	StatsFilterImpl statsfilter;
	/**
	 * Rotta che consente di interpretare tipo e significato dei dati forniti come risposta dal programma
	 * 
	 * @return vettore di Metadata in formato Json 
	 */
	@GetMapping("/metadata")
	public ResponseEntity<Object> getMetaData(){
		return new ResponseEntity<>(database.getMetaData(), HttpStatus.OK);
	}
	/**
	 * Rotta che consente di visualizzare previsioni attuali di una città, interrogando le API OpenWeather
	 * 
	 * @param name nome della città da ricercare
	 * @return Stringa dell'oggetto Weather in formato Json
	 */
	@GetMapping("/current")
	public ResponseEntity<Object> currentParser(@RequestParam(value="city") String city){
		return new ResponseEntity<>(Parser.currentParser(city), HttpStatus.OK);
	}
	/**
	 * Rotta che permette di ottenere statistiche filtrate, per intervallo di tempo, di una città scelta
	 * 
	 * @param filter oggetto di tipo Filter che contiene città e intervallo di ricerca
	 * @return Stringa Json con i dati relativi alla temperatura(percepita e reale) massima e minima, media e varianza
	 */
	@PostMapping("/currentstats")
	public String getTempStats(@RequestBody TempFilter filter) throws Exception{
		return statsfilter.getTempStats(filter);
	}
	/**
	 * Rotta che restituisce previsioni orarie storiche di una data città, in un arco temporale definito dall'utente
	 * 
	 * @param filter oggetto di tipo Filter che contiene città e intervallo di ricerca
	 * @return Stringa Json di Vector di tipo Weather
	 */
	@PostMapping("/currentfilter")
	public String getTempFilter(@RequestBody TempFilter filter) throws Exception{
		if(!(filter.getInInstant()=="") && !(filter.getFinInstant()=="")) {
			return statsfilter.getTempFilter(filter);
		}
		else {
			String stringa = new Gson().toJson(Deserialize.deserializeCurrent(filter.getCityName()));
			return stringa;
		}
	}
	/**
	 * Rotta che consente di filtrare lo storico in base all'esattezza della previsione effettuata su un dato margine di errore
	 * 
	 * @param filter oggetto di tipo Filter che contiene città, intervallo di ricerca e errore marginale
	 * @return Stringa Json dell'oggetto di tipo IndexFilter
	 */
	@PostMapping("/index")
	public String getIndexFilter(@RequestBody IndexTempFilter filter) throws Exception{
		return statsfilter.getIndexFilter(filter);
	}
}
