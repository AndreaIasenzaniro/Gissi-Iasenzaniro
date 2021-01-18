/**
 * 
 */
package com.gisias.OpenWeather.Filter;

/**
 * Classe relatva al filtraggio delle previsioni azzeccate in base ad un dato margine di errore
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
public class IndexFilter{
	
	String dt;
	double temp;
	/**
	 * @param dt
	 * @param temp
	 */
	public IndexFilter(String dt, double temp) {
		this.dt = dt;
		this.temp = temp;
	}
	/**
	 * @return the dt
	 */
	public String getDt() {
		return dt;
	}
	/**
	 * @param dt the dt to set
	 */
	public void setDt(String dt) {
		this.dt = dt;
	}
	/**
	 * @return the temp
	 */
	public double getTemp() {
		return temp;
	}
	/**
	 * @param temp the temp to set
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}
	
}
