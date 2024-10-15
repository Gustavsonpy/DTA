package com.example.api.example_file_api.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;

public class WeatherResponse {

    @JsonProperty("current_weather")
    private CurrentWeather currentWeather;

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public static class CurrentWeather{

        @JsonProperty("temperature")
        private Double temperature;
        @JsonProperty("time")
        private String date;

        public String getDate() {
            return date;
        }

        public void setDate(String time) {
            this.date = date;
        }

        public Double getTemperature() {
            return temperature;
        }

        public void setTemperature(Double temperature) {
            this.temperature = temperature;
        }
    }
}
