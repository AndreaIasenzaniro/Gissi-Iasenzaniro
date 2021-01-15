/**
 * 
 */
package com.gisias.OpenWeather.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.google.gson.JsonObject;

/**
 * @author aiasenzaniro
 *
 */
public class Stats_Filter {
	
	protected static String DataConverter(Long milliseconds) {
		Date date = new Date(milliseconds*1000L);
	    SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    String dateText = date_format.format(date);
	    return dateText;
	}
	
	//protected JsonObject object=new JsonObject();
	
	protected static void getPeriod(JsonObject object) {
		//String inInstantString = object.
		//String finInstant;
		
	}

}
