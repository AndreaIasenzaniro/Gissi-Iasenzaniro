package com.gisias.OpenWeather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Classe di bootstrap dell'applicativo
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
@SpringBootApplication
/*
 * annotazione che abilita la capacità di esecuzione delle attività pianificate di Spring
 */
@EnableScheduling
public class OpenWeatherApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OpenWeatherApplication.class, args);
				
	}

}
