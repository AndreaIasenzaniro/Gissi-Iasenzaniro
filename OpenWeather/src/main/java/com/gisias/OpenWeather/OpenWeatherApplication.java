package com.gisias.OpenWeather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * Classe di bootstrap del nostro applicativo
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
@SpringBootApplication
@EnableScheduling
public class OpenWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherApplication.class, args);
		/*
		 * Metodo che ci ha permesso di effettuare chiamate, a cadenza oraria, delle Current ApiRest
		 */
		//Methods.writeCurrent();
		/*
		 * Metodo che ci ha permesso di effettuare chiamate a Forecast ApiRest
		 */
		//Methods.writeForecast();	
		
	}

}
