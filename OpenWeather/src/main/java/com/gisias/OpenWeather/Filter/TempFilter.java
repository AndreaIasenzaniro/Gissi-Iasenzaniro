/**
 * 
 */
package com.gisias.OpenWeather.Filter;
/**
 * Classe che permette di creare un filtro temporale
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
public class TempFilter {
	protected String cityName;
	protected String inInstant;
	protected String finInstant;
	/**
	 * @param inInstant data iniziale dell'intervallo
	 * @param finInstant data finale dell'intervallo
	 * @param cityName nome della città
	 */
	public TempFilter(String cityName, String inInstant, String finInstant) {
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
	
}
