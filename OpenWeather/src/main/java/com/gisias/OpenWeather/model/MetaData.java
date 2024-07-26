package com.gisias.OpenWeather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaData {

    private String alias;
    private String sourceField;
    private String type;

    // Default constructor
    public MetaData() {}

    // Parameterized constructor
    public MetaData(String name, String description, String type) {
        this.alias = name;
        this.sourceField = description;
        this.type = type;
    }

    @JsonProperty("name")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String name) {
        this.alias = name;
    }

    @JsonProperty("description")
    public String getSourceField() {
        return sourceField;
    }

    public void setSourceField(String description) {
        this.sourceField = description;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}