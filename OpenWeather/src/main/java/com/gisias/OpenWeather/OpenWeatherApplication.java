package com.gisias.OpenWeather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Bootstrap class for the application
 * 
 * @authour Andrea Iasenzaniro
 * @authour Carlo Gissi
 *
 */
@SpringBootApplication
/*
 * Annotation that enables Spring's scheduled task execution capability
 */
@EnableScheduling
public class OpenWeatherApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(OpenWeatherApplication.class, args);
    }
}