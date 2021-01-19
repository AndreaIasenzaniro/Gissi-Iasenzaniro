/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

import com.gisias.OpenWeather.Filter.TempFilter;
import com.gisias.OpenWeather.Filter.IndexTempFilter;
import com.gisias.OpenWeather.model.Weather;

/**
 * Classe astratta che contiene dichiarazioni di metodi di filtraggio 
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
public abstract class StatsFilter {
	
	/**
     * Metodo che consente di trasformare una stringa in data
     * 
     * @param date data in formato stringa da convertire
     * @return long della data inserita
     * @throws ParseException
     */
    public static Long StringToDate(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Instant data = df.parse(date).toInstant();
		long epoch = data.getEpochSecond();
		return epoch;
    }
    /**
     * Metodo che consente di trasformare un long in Date
     * 
     * @param unixDate data in formato Unix 
     * @return data in formato Date
     */
    public static Date unixToDate(long unixDate) {
    	long unixSeconds = unixDate;
    	Date date = new Date(unixSeconds*1000L); 
    	return date;
    }
    /**
     * Metodo che consente di trasformare un long in stringa 
     * 
     * @param millis data in formato Unix
     * @return data in formato String
     */
    protected static String unixToString(long millis) {
    	DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    	Calendar cal = Calendar.getInstance();
    	cal.setTimeInMillis(millis*1000L);
    	return formato.format(cal.getTime());
    }
    /**
     * Metodo che consente di confrontare due date in base al solo giorno dell'anno
     * 
     * @param date1 data in formato Date
     * @param date2 data in formato Date
     * @return boolean true se le date hanno lo stesso giorno dell'anno
     */
    public static boolean matchDate(Date date1, Date date2) {
	   Calendar cal1 = Calendar.getInstance();
	   Calendar cal2 = Calendar.getInstance();
	   cal1.setTime(date1);
	   cal2.setTime(date2);
	   boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
	                     cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
	   return sameDay;
   }
   /**
    * Metodo che legge vettore di tipo weather e ne restituisce uno dello stesso tipo contenente una sola revisione per ogni giorno
    * 
    * @param current vettore di tipo weather da cui si estraggono le previsioni
    * @return vettore di tipo weathear 
    */
    public static Vector<Weather> oneForDay(Vector<Weather> current) {
		
		Vector<Weather> onefor = new Vector<Weather>();
		Date date=new Date();
		for(Weather weather : current) {
			Date appoggio = unixToDate(weather.getDt());
			if(matchDate(date,appoggio)) {
				date=appoggio;				
			}else {
				onefor.add(weather);
				date=appoggio;
			}
		}
		return onefor;
	}
   /**
    * Dichiarazione metodo astratto per ottenere statistiche temporali
    * 
    * @param filter oggetto di tipo TempFilter
    * @return Stringa Json dell'oggetto Stats
    */
    public abstract String getTempStats(TempFilter filter) throws Exception;
    /**
     * Dichiarazione metodo astratto per applicare filtri temporali
     * 
     * @param filter filter oggetto di tipo TempFilter
     * @return Stringa Json dell'oggetto Weather 
     */
    public abstract String getTempFilter(TempFilter filter) throws Exception;
    /**
     * Dichiarazione metodo astratto per applicare filtro per margine di errore
     * 
     * @param filter filter oggetto di tipo IndexTempFilter
     * @return Stringa Json dell'oggetto IndexFilter
     */
    public abstract String getIndexFilter(IndexTempFilter filter) throws Exception;

}
