package com.example.api.example_file_api.controller;

public class WeatherInfo {
    private Double temperature;
    private String dateTime;

    public WeatherInfo(Double temperature, String dateTime) {
        this.temperature = temperature;
        this.dateTime = dateTime;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
