package com.gisias.OpenWeather.service;

import java.util.List;

import com.gisias.OpenWeather.model.MetaData;

/**
 * Abstract class with methods that allow obtaining MetaData
 * 
 * @authour Andrea Iasenzaniro
 * @authour Carlo Gissi
 *
 */
public interface DataBase {
	
    /**
     * Declaration of an abstract method that returns MetaData
     * 
     * @return list of type MetaData
     */
    public List<MetaData> getMetaData();
}