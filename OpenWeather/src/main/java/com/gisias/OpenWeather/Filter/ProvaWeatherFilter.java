/**
 * 
 */
package com.gisias.OpenWeather.Filter;

/**
 * @author aiasenzaniro
 *
 */
public class ProvaWeatherFilter {
	
	long dt;
	double temp;
	/**
	 * @param dt
	 * @param temp
	 * @param feels_like
	 */
	public ProvaWeatherFilter(long dt, double temp) {
		this.dt = dt;
		this.temp = temp;
	}
	/**
	 * @return the dt
	 */
	public long getDt() {
		return dt;
	}
	/**
	 * @param dt the dt to set
	 */
	public void setDt(long dt) {
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
