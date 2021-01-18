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
	//se errore da 0 a 4 in 1 giorni, valutazione pessima
	//se errore da 0 a 4 in 3 giorni, valutazione buona
	//se errore da 0 a 4 in 5 giorni, valutazione ottima
	double errorMarg;
	String valutation;
	/**
	 * @param errorMarg margine di errore delle previsioni
	 * @param valutation valutazione sulla soglia di errore
	 */
	public IndexFilter(double errorMarg, String valutation) {
		this.errorMarg = errorMarg;
		this.valutation = valutation;
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
	/**
	 * @return the valutation
	 */
	public String getValutation() {
		return valutation;
	}
	/**
	 * @param valutation the valutation to set
	 */
	public void setValutation(String valutation) {
		this.valutation = valutation;
	}
	
	
}
