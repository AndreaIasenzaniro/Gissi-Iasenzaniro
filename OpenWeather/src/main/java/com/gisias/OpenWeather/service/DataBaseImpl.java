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
 * Implementazione della classe astratta DataBase
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
@Service
public class DataBaseImpl implements DataBase {

	@Value("${openweather.metadata.list}")
    private String metadataFile;

	/**
     * Metodo che legge i dati da un file metadata.json e restituisce una lista di tipo MetaData
     */
    @Override
    public List<MetaData> getMetaData() {
        List<MetaData> metadata = null;
        Gson gson = new Gson();
        Type metadataListType = new TypeToken<List<MetaData>>() {}.getType();

        try (BufferedReader reader = new BufferedReader(new FileReader(metadataFile))) {
            metadata = gson.fromJson(reader, metadataListType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return metadata;
    }
}