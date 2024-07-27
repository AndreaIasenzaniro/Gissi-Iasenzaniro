package com.gisias.OpenWeather.Filter;

/**
 * Class that creates a temporal filter based on an error threshold
 * 
 * @author Andrea Iasenzaniro
 * @author Carlo Gissi
 *
 */
public class IndexTemporalFilter extends TemporalFilter {

    double errorMarg;

    /**
     * Constructor for IndexTempFilter
     * 
     * @param cityName   the name of the city
     * @param inInstant  the start of the time interval
     * @param finInstant the end of the time interval
     * @param errorMarg  the error margin in the forecast
     */
    public IndexTemporalFilter(String cityName, String inInstant, String finInstant, double errorMarg) {
        super(cityName, inInstant, finInstant);
        this.errorMarg = errorMarg;
    }

    /**
     * @return the error margin
     */
    public double getErrorMarg() {
        return errorMarg;
    }

    /**
     * @param errorMarg the error margin to set
     */
    public void setErrorMarg(double errorMarg) {
        this.errorMarg = errorMarg;
    }
}