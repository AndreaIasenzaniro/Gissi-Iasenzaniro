package com.gisias.OpenWeather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gisias.OpenWeather.service.Methods;
import com.gisias.OpenWeather.service.Parser;

@SpringBootApplication
public class OpenWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherApplication.class, args);
		
		//Methods.writeCurrent();
		//Methods.writeForecast();
		Methods.fileWriter(Parser.forecastParser("Termoli"), "previsionali", "Termoli"+"forec");
		
	}

}
