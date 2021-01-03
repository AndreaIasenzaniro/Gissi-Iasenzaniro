package com.gisias.OpenWeather.util;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class ForStats extends Deserialize {

	protected static String DataConverter(Long milliseconds) {
		Date date = new Date(milliseconds*1000L);
	    SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    String dateText = date_format.format(date);
	    return dateText;
	}
}
