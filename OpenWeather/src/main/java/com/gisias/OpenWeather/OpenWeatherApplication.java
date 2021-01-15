package com.gisias.OpenWeather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.gisias.OpenWeather.service.Methods;

@SpringBootApplication
@EnableScheduling
public class OpenWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherApplication.class, args);
		/*
		 * Metodo che ci ha permesso di effettuare chiamate, ad intervalli di un ora, a Current ApiRest
		 */
		//Methods.writeCurrent();
		/*
		 * Metodo che ci ha permesso di effettuare chiamate a Forecast ApiRest
		 */
		//Methods.writeForecast();	
		Methods.writeprova();
	}

}
