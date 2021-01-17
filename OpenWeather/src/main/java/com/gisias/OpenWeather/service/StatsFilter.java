/**
 * 
 */
package com.gisias.OpenWeather.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

import com.gisias.OpenWeather.Filter.TempFilter;

/**
 * @author aiasenzaniro
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
   public static Long addDate()
   /**
    * Dichiarazione metodo astratto per ottenere statistiche temporali
    * 
    * @param filter
    * @return
    */
    public abstract String getTempStats(TempFilter filter) throws Exception;
    /**
     * Dichiarazione metodo astratto per applicare filtri temporali
     * 
     * @param filter
     * @return
     */
    public abstract String getTempFilter(TempFilter filter) throws Exception;
    /**
     * Dichiarazione metodo astratto per applicare filtro per margine di errore
     * 
     * @param filter
     * @return
     * @throws Exception
     */
    public abstract String getIndexFilter(TempFilter filter) throws Exception;

}
