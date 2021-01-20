/**
 * 
 */
package com.gisias.OpenWeather.Filter;

import java.util.Vector;

/**
 * Classe relatva al filtraggio delle previsioni azzeccate in base ad un dato margine di errore
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
public class IndexFilter{
	
	String dateIn;
	String dateFin;
	int correct;
	int uncorrect;
	Vector<Double> uncorrectTemp = new Vector<Double>();
	
	/**
	 * @param dateIn data iniziale dell'intervallo
	 * @param dateFin data finale dell'intervallo
	 * @param correct contatore delle previsioni azzeccate
	 * @param uncorrectTemp vettore delle temperature che superano la soglia di errore
	 */
	public IndexFilter(String dateIn, String dateFin, int correct, Vector<Double> uncorrectTemp) {
		this.dateIn = dateIn;
		this.dateFin = dateFin;
		this.correct = correct;
		this.uncorrectTemp = uncorrectTemp;
		this.uncorrect=this.uncorrectTemp.size();
	}
	/**
	 * @return the dt1
	 */
	public String getDt1() {
		return dateIn;
	}
	/**
	 * @param dt1 the dt1 to set
	 */
	public void setDt1(String dt1) {
		this.dateIn = dt1;
	}
	/**
	 * @return the dt2
	 */
	public String getDt2() {
		return dateFin;
	}
	/**
	 * @param dt2 the dt2 to set
	 */
	public void setDt2(String dt2) {
		this.dateFin = dt2;
	}
	/**
	 * @return the correct
	 */
	public int getCorrect() {
		return correct;
	}
	/**
	 * @param correct the correct to set
	 */
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	/**
	 * @return the temp
	 */
	public Vector<Double> getTemp() {
		return uncorrectTemp;
	}
	/**
	 * @param temp the temp to set
	 */
	public void setTemp(Vector<Double> temp) {
		this.uncorrectTemp = temp;
	}
	
}
