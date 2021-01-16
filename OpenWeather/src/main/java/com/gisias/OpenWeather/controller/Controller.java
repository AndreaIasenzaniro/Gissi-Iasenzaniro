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
import org.springframework.web.bind.annotation.RestController;
import com.gisias.OpenWeather.Filter.TempFilter;
import com.gisias.OpenWeather.service.DataBaseImpl;
import com.gisias.OpenWeather.util.StatsFilter;

/**
 * @author aiasenzaniro
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
	
	@PostMapping("/stats")
	public String getTempFilter(@RequestBody TempFilter filter) throws Exception{
		return statsfilter.getTempFilter(filter);
	}

}
