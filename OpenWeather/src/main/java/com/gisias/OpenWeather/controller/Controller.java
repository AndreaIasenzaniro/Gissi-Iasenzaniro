/**
 * 
 */
package com.gisias.OpenWeather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gisias.OpenWeather.service.DataBaseImpl;

/**
 * @author aiasenzaniro
 *
 */
@RestController
public class Controller {

	@Autowired
	DataBaseImpl databaseimpl;
	
	/**
	 * Rotta che consente di interpretare il tipo dati forniti come risposta dal programma
	 * @return oggetti di tipo MetaData in formato Json
	 */
	@GetMapping("/metadata")
	public ResponseEntity<Object> getMetaData(){
		return new ResponseEntity<>(databaseimpl.parsMetaData(databaseimpl.getMetaData()), HttpStatus.OK);
	}

}
