/**
 * 
 */
package com.gisias.OpenWeather.model;

/**
 * @author aiasenzaniro
 *
 */
public class MetaData {

	String Alias;
	String sourceField;
	String type;
	/**
	 * @param alias
	 * @param sourceField
	 * @param type
	 */
	public MetaData(String alias, String sourceField, String type) {
		Alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}
	
	
}
