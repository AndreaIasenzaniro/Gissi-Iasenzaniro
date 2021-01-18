package com.gisias.OpenWeather.Filter;

public class xxxxxx {

	protected String cityName;
	protected String inInstant;
	protected String finInstant;
	double errorMarg;
	/**
	 * @param cityName
	 * @param inInstant
	 * @param finInstant
	 * @param errorMarg
	 */
	public xxxxxx(String cityName, String inInstant, String finInstant, double errorMarg) {
		this.cityName = cityName;
		this.inInstant = inInstant;
		this.finInstant = finInstant;
		this.errorMarg = errorMarg;
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
	/**
	 * @return the errorMarg
	 */
	public double getErrorMarg() {
		return errorMarg;
	}
	/**
	 * @param errorMarg the errorMarg to set
	 */
	public void setErrorMarg(double errorMarg) {
		this.errorMarg = errorMarg;
	}
	
}
