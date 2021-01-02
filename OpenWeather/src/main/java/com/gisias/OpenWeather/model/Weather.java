/**
 * 
 */
package com.gisias.OpenWeather.model;

import java.io.Serializable;

/**
 * @author aiasenzaniro
 *
 */
@SuppressWarnings("serial")
public class Weather extends Data implements Serializable{

	long dt;
	double clouds;
	double temp;
	double feels_like;
	double tempMax;
	double tempMin;
	double wind_speed;
	/**
	 * @param cityName
	 * @param dt
	 * @param clouds
	 * @param temp
	 * @param feels_like
	 * @param tempMax
	 * @param tempMin
	 * @param wind_speed
	 */
	public Weather(String cityName, long dt, double clouds, double temp, double feels_like, double tempMax,
			double tempMin, double wind_speed) {
		super(cityName);
		this.dt = dt;
		this.clouds = clouds;
		this.temp = temp;
		this.feels_like = feels_like;
		this.tempMax = tempMax;
		this.tempMin = tempMin;
		this.wind_speed = wind_speed;
	}
	/**
	 * Costruttore vuoto della classe Weather
	 */
	public Weather() {
		
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
	 * @return the clouds
	 */
	public double getClouds() {
		return clouds;
	}
	/**
	 * @param clouds the clouds to set
	 */
	public void setClouds(double clouds) {
		this.clouds = clouds;
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
	/**
	 * @return the feels_like
	 */
	public double getFeels_like() {
		return feels_like;
	}
	/**
	 * @param feels_like the feels_like to set
	 */
	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}
	/**
	 * @return the tempMax
	 */
	public double getTempMax() {
		return tempMax;
	}
	/**
	 * @param tempMax the tempMax to set
	 */
	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}
	/**
	 * @return the tempMin
	 */
	public double getTempMin() {
		return tempMin;
	}
	/**
	 * @param tempMin the tempMin to set
	 */
	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}
	/**
	 * @return the wind_speed
	 */
	public double getWind_speed() {
		return wind_speed;
	}
	/**
	 * @param wind_speed the wind_speed to set
	 */
	public void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}
	
	
}
