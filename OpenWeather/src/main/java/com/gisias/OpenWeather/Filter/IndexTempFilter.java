package com.gisias.OpenWeather.Filter;

/**
 * Classe che permette di creare un filtro temporale in base ad una soglia di errore
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
public class IndexTempFilter extends TempFilter {

	double errorMarg;
	/**
	 * @param errorMarg errore nella previsione effettuata
	 */
	public IndexTempFilter(String cityName, String inInstant, String finInstant, double errorMarg) {
		super(cityName, inInstant, finInstant);
		this.errorMarg = errorMarg;
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
