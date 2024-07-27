package com.gisias.OpenWeather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaData {

    private String alias;
    private String sourceField;
    private String type;

    /**
     * Default constructor
     */
    public MetaData() {}

    /**
     * Parameterized constructor to initialize MetaData with given values
     * 
     * @param name        the alias or name of the metadata field
     * @param description the description or source field of the metadata
     * @param type        the data type of the metadata field
     */
    public MetaData(String name, String description, String type) {
        this.alias = name;
        this.sourceField = description;
        this.type = type;
    }

    /**
     * Gets the alias of the metadata field
     * 
     * @return the alias of the metadata field
     */
    @JsonProperty("name")
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the alias of the metadata field
     * 
     * @param name the new alias to set
     */
    public void setAlias(String name) {
        this.alias = name;
    }

    /**
     * Gets the source field description of the metadata
     * 
     * @return the source field description of the metadata
     */
    @JsonProperty("description")
    public String getSourceField() {
        return sourceField;
    }

    /**
     * Sets the source field description of the metadata
     * 
     * @param description the new description to set
     */
    public void setSourceField(String description) {
        this.sourceField = description;
    }

    /**
     * Gets the type of the metadata field
     * 
     * @return the type of the metadata field
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the metadata field
     * 
     * @param type the new type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}