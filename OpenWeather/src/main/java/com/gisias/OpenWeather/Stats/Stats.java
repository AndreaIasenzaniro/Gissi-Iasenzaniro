package com.gisias.OpenWeather.Stats;

import java.util.*;
/**
 * Classe che crea un oggetto di tipo stats con i valori delle statistiche effettuate
 * 
 * @author AndreaIasenzaniro
 * @author CarloGissi
 *
 */
public class Stats {
	
	protected double max;
	protected double min;
	protected double realAvg;
	protected double realVariance;
	protected double feelAvg;
	protected double feelVariance;
	/**
	 * @param max temperatura massima
	 * @param min temperatura minima
	 * @param avg media delle temperature reali
	 * @param variance varianza delle temperature reali
	 * @param feelAvg media delle temperature percepite
	 * @param feelVariance varianza delle temperature percepite
	 */
	public Stats(double max, double min, double realAvg, double realVariance, double feelAvg, double feelVariance) {
		this.max = max;
		this.min = min;
		this.realAvg = realAvg;
		this.realVariance = realVariance;
		this.feelAvg = feelAvg;
		this.feelVariance = feelVariance;
	}
	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(double max) {
		this.max = max;
	}

	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(double min) {
		this.min = min;
	}

	/**
	 * @return the realAvg
	 */
	public double getRealAvg() {
		return realAvg;
	}

	/**
	 * @param realAvg the realAvg to set
	 */
	public void setRealAvg(double realAvg) {
		this.realAvg = realAvg;
	}

	/**
	 * @return the realVariance
	 */
	public double getRealVariance() {
		return realVariance;
	}

	/**
	 * @param realVariance the realVariance to set
	 */
	public void setRealVariance(double realVariance) {
		this.realVariance = realVariance;
	}

	/**
	 * @return the feelAvg
	 */
	public double getFeelAvg() {
		return feelAvg;
	}

	/**
	 * @param feelAvg the feelAvg to set
	 */
	public void setFeelAvg(double feelAvg) {
		this.feelAvg = feelAvg;
	}

	/**
	 * @return the feelVariance
	 */
	public double getFeelVariance() {
		return feelVariance;
	}

	/**
	 * @param feelVariance the feelVariance to set
	 */
	public void setFeelVariance(double feelVariance) {
		this.feelVariance = feelVariance;
	}

	/**
	 * Metodo che calcola la media dei valori di un Vettore di tipo double
	 * 
	 * @param values vettore di numeri dei quali viene calcolata la media
	 * @return media dei valori contenuti nel vettore
	 */
	public static double avgCalculate(Vector<Double>values) {
		double sum=0;
		for(int i=0; i< values.size(); i++) {
			sum += values.elementAt(i);
		}
		double risp = sum/values.size();
		return (double)Math.round(risp*100d)/100d;
	}
	/**
	 * Metodo che calcola la varianza dei valori di un Vettore di tipo double
	 * 
	 * @param values vettore di numeri dei quali viene calcolata la varianza
	 * @return varianza dei valori contenuti nel vettore
	 */
	public static double varianceCalculate(Vector<Double>values) {
		double m = avgCalculate(values);
		double sommaScartiQuad = 0;
		for(int i=0; i<values.size(); i++)
			sommaScartiQuad += (values.elementAt(i)-m)*(values.elementAt(i)-m);
		double risp = sommaScartiQuad/values.size();
		return (double)Math.round(risp*100d)/100d;
	}
	/**
	 * Metodo che estrapola il valore massimo di un Vettore di double
	 * 
	 * @param values vettore di numeri da cui estrarre il massimo 
	 * @return valore massimo del vattore
	 */
	public static double getMaxVal(Vector<Double>values) {
		double max=values.elementAt(0);
		for(int i=0; i<values.size(); i++) {
			double temp=values.elementAt(i);
			if(temp>max||temp==max) {
				max=temp;
			}
		}
		return max;
	}
	/**
	 * Metodo che estrapola il valore minimo di un Vettore di double
	 * 
	 * @param values vettore di numeri da cui estrarre il minimo
	 * @return valore minimo del vettore
	 */
	public static double getMinVal(Vector<Double>values) {
		double min=values.elementAt(0);
		for(int i=0; i<values.size(); i++) {
			double temp=values.elementAt(i);
			if(temp<min || temp==min) {
				min=temp;
			}
		}
		return min;
	}
}
