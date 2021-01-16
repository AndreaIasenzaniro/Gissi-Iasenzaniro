package com.gisias.OpenWeather.Stats;

import java.util.*;

import com.gisias.OpenWeather.util.StatsFilter;

public class Stats extends StatsFilter {
	
	/**
	 * 
	 */
	protected double max;
	/**
	 * 
	 */
	protected double min;
	/**
	 * 
	 */
	protected double avg;
	/**
	 * 
	 */
	protected double variance;
	/**
	 * @param max
	 * @param min
	 * @param avg
	 * @param variance
	 */
	public Stats(double max, double min, double avg, double variance) {
		this.max = max;
		this.min = min;
		this.avg = avg;
		this.variance = variance;
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
	 * @return the avg
	 */
	public double getAvg() {
		return avg;
	}
	/**
	 * @param avg the avg to set
	 */
	public void setAvg(double avg) {
		this.avg = avg;
	}
	/**
	 * @return the variance
	 */
	public double getVariance() {
		return variance;
	}
	/**
	 * @param variance the variance to set
	 */
	public void setVariance(double variance) {
		this.variance = variance;
	}
	/**
	 * @param values
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
	 * @param v
	 * @return
	 */
	public static double varianceCalculate(Vector<Double>v) {
		double m = avgCalculate(v);
		double sommaScartiQuad = 0;
		for(int i=0; i<v.size(); i++)
			sommaScartiQuad += (v.elementAt(i)-m)*(v.elementAt(i)-m);
		double risp = sommaScartiQuad/v.size();
		return (double)Math.round(risp*100d)/100d;
	}
	/**
	 * @param values
	 * @return
	 */
	public static double getMaxVal(Vector<Double>values) {
		double max=values.elementAt(0);
		for(int i=0; i<values.size(); i++) {
			double temp=values.elementAt(i);
			if(temp>max) {
				max=temp;
			}
		}
		return max;
	}
	/**
	 * @param values
	 * @return
	 */
	public static double getMinVal(Vector<Double>values) {
		double max=values.elementAt(0);
		for(int i=0; i<values.size(); i++) {
			double temp=values.elementAt(i);
			if(temp<max) {
				max=temp;
			}
		}
		return max;
	}
}
