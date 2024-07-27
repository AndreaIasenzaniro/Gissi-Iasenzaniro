package com.gisias.OpenWeather.service;

import java.io.*;

import java.util.Vector;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Class containing methods necessary for the implementation of the project
 * 
 * @authour Andrea Iasenzaniro
 * @authour Carlo Gissi
 *
 */
@SuppressWarnings("unused")
@Service
public class Methods {
	
    /**
     * Method that reads the cities from a file to populate the dataset
     * 
     * @return Vector of strings representing city names
     */
    public static Vector<String> getCities() {
        Vector<String> citta = new Vector<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("citta.txt"));

            String city = reader.readLine();
            while (city != null) {
                citta.add(city);
                city = reader.readLine();
            }
            reader.close();
            return citta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Method used to append to a file
     * 
     * @param weather   string passed as a parameter
     * @param path      file path
     * @param nomefile  name of the file
     */
    protected static void fileWriter(String weather, String path, String nomefile) {
        try {
            FileWriter output = new FileWriter(path + "/" + nomefile + ".txt", true);
            output.write(weather);
            output.write("\n");
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that writes the current weather forecasts to a file on an hourly basis
     */
    // @Scheduled(cron="0 0 * * * *")
    public static void writeCurrent() {
        for (String c : getCities()) {
            // fileWriter(Parser.currentParser(c), "correnti", c);
        }
    }

    /**
     * Method that writes weekly future forecasts to a file
     */
    // @Scheduled(fixedRate=10080*60*1000)
    public static void writeForecast() {
        for (String c : getCities()) {
            // fileWriter(Parser.forecastParser(c), "previsionali", c);
        }
    }
}