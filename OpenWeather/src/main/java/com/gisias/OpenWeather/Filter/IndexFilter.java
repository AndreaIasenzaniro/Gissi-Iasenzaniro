package com.gisias.OpenWeather.Filter;

import java.util.Vector;

/**
 * Class related to filtering correct forecasts based on a given margin of error
 * 
 * @author Andrea Iasenzaniro
 * @author Carlo Gissi
 *
 */
public class IndexFilter {

    String startDate;
    String endDate;
    int countCorrect;
    int countUncorrect;
    Vector<Double> uncorrectTemp = new Vector<Double>();

    /**
     * Constructor for IndexFilter
     * 
     * @param startDate        start date of the interval
     * @param endDate       end date of the interval
     * @param countCorrect       counter for correct forecasts
     * @param uncorrectTemp vector of temperatures that exceed the error threshold
     */
    public IndexFilter(String startDate, String endDate, int countCorrect, Vector<Double> uncorrectTemp) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.countCorrect = countCorrect;
        this.uncorrectTemp = uncorrectTemp;
        this.countUncorrect = this.uncorrectTemp.size();
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param date the startDate to set
     */
    public void setStartDate(String date) {
        this.startDate = date;
    }

    /**
     * @return the endDate
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param date the endDate to set
     */
    public void setEndDate(String date) {
        this.endDate = date;
    }

    /**
     * @return the number of correct forecasts
     */
    public int getCountCorrect() {
        return countCorrect;
    }

    /**
     * @param correct the number of correct forecasts to set
     */
    public void setCountCorrect(int correct) {
        this.countCorrect = correct;
    }

    /**
     * @return the vector of temperatures that exceed the error threshold
     */
    public Vector<Double> getTemp() {
        return uncorrectTemp;
    }

    /**
     * @param temp the vector of temperatures that exceed the error threshold to set
     */
    public void setTemp(Vector<Double> temp) {
        this.uncorrectTemp = temp;
    }
}