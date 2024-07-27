package com.gisias.OpenWeather.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gisias.OpenWeather.model.MetaData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * Implementation of the abstract class DataBase
 * 
 * @authour Andrea Iasenzaniro
 * @authour Carlo Gissi
 *
 */
@Service
public class DataBaseImpl implements DataBase {

    // Path to the metadata file, injected from application properties
    @Value("${openweather.metadata.list}")
    private String metadataFile;

    /**
     * Method that reads data from a metadata.json file and returns a list of type MetaData
     */
    @Override
    public List<MetaData> getMetaData() {
        List<MetaData> metadata = null;
        Gson gson = new Gson();
        Type metadataListType = new TypeToken<List<MetaData>>() {}.getType();

        // Try-with-resources to ensure the BufferedReader is closed properly
        try (BufferedReader reader = new BufferedReader(new FileReader(metadataFile))) {
            // Deserialize JSON from the file into a list of MetaData objects
            metadata = gson.fromJson(reader, metadataListType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return metadata;
    }
}