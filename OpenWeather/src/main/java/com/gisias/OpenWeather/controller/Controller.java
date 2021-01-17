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
import com.gisias.OpenWeather.service.DataBaseImpl;
import com.gisias.OpenWeather.service.Parser;
import com.gisias.OpenWeather.util.StatsFilter;

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
	DataBaseImpl databaseimpl;
	@Autowired
	StatsFilter statsfilter;
	
	/**
	 * Rotta che consente di interpretare il tipo dati forniti come risposta dal programma
	 * @return oggetti di tipo MetaData in formato Json
	 */
	@GetMapping("/metadata")
	public ResponseEntity<Object> getMetaData(){
		return new ResponseEntity<>(databaseimpl.parsMetaData(databaseimpl.getMetaData()), HttpStatus.OK);
	}
	/**
	 * Rotta che consente di visualizzare previsione attuale di una città
	 * @param name nome della città da ricercare
	 * @return Stringa dell'oggetto Weather in formato Json
	 */
	@GetMapping("/current")
	public ResponseEntity<Object> currentParser(@RequestParam(value="name") String name){
		return new ResponseEntity<>(Parser.currentParser(name), HttpStatus.OK);
	}
	/**
	 * Rotta che permette di ottenere statistiche filtrate per durata, di una città scelta
	 * @param filter oggetto di tipo filter che contiene città e intervallo di ricerca
	 * @return Stringa Json con i dati relativi alla temperatura massima, minima, media e varianza
	 * @throws Exception
	 */
	@PostMapping("/stats")
	public String getTempFilter(@RequestBody TempFilter filter) throws Exception{
		return statsfilter.getTempFilter(filter);
	}

}
