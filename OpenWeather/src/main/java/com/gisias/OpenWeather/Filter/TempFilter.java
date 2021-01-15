/**
 * 
 */
package com.gisias.OpenWeather.Filter;

import com.google.gson.JsonObject;

/**
 * @author aiasenzaniro
 *
 */
public class TempFilter {
	
	String inInstant;
	String finInstant;
	String cityName;
	/**
	 * @param inInstant
	 * @param finInstant
	 * @param cityName
	 */
	public TempFilter(String inInstant, String finInstant, String cityName) {
		this.inInstant = inInstant;
		this.finInstant = finInstant;
		this.cityName = cityName;
	}
	/**
	 * @return the inInstant
	 */
	public String getInInstant() {
		return inInstant;
	}
	/**
	 * @param inInstant the inInstant to set
	 */
	public void setInInstant(String inInstant) {
		this.inInstant = inInstant;
	}
	/**
	 * @return the finInstant
	 */
	public String getFinInstant() {
		return finInstant;
	}
	/**
	 * @param finInstant the finInstant to set
	 */
	public void setFinInstant(String finInstant) {
		this.finInstant = finInstant;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public JsonObject parseTempStats() {
		return null;
	}
	
}
