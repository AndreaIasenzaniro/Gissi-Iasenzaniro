package com.gisias.OpenWeather.Stats;

import java.util.*;

/**
 * Class that creates an object of type Stats with the values of the calculated statistics
 * 
 * @author Andrea Iasenzaniro
 * @authour Carlo Gissi
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
     * Constructor to initialize Stats object
     * 
     * @param max maximum temperature
     * @param min minimum temperature
     * @param realAvg average of actual temperatures
     * @param realVariance variance of actual temperatures
     * @param feelAvg average of perceived temperatures
     * @param feelVariance variance of perceived temperatures
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
     * Method to calculate the average of values in a Vector of type double
     * 
     * @param values vector of numbers to calculate the average
     * @return average of values in the vector
     */
    public static double avgCalculate(Vector<Double> values) {
        double sum = 0;

        for (int i = 0; i < values.size(); i++) {
            sum += values.elementAt(i);
        }

        double result = Math.round(sum / values.size() * 100d) / 100d;
        return result;
    }

    /**
     * Method to calculate the variance of values in a Vector of type double
     * 
     * @param values vector of numbers to calculate the variance
     * @return variance of values in the vector
     */
    public static double varianceCalculate(Vector<Double> values) {
        double mean = avgCalculate(values);
        double sumSquaredDifferences = 0;

        for (int i = 0; i < values.size(); i++){
			sumSquaredDifferences += (values.elementAt(i) - mean) * (values.elementAt(i) - mean);
		}

        double result = Math.round(sumSquaredDifferences / values.size() * 100d) / 100d;
        return result;
    }

    /**
     * Method to extract the maximum value from a Vector of type double
     * 
     * @param values vector of numbers to extract the maximum value
     * @return maximum value of the vector
     */
    public static double getMaxVal(Vector<Double> values) {
        double max = values.elementAt(0);
        for (int i = 0; i < values.size(); i++) {
            double temp = values.elementAt(i);
            if (temp > max || temp == max) {
                max = temp;
            }
        }
        return max;
    }

    /**
     * Method to extract the minimum value from a Vector of type double
     * 
     * @param values vector of numbers to extract the minimum value
     * @return minimum value of the vector
     */
    public static double getMinVal(Vector<Double> values) {
        double min = values.elementAt(0);
        for (int i = 0; i < values.size(); i++) {
            double temp = values.elementAt(i);
            if (temp < min || temp == min) {
                min = temp;
            }
        }
        return min;
    }
}