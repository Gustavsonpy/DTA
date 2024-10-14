package com.example.api.example_file_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
    @Autowired
    private ApiServiceWeather apiServiceWeather;

    @GetMapping("/weather")
    public String getWeather(Model model){
        //Consome a api para obter o clima
        String weatherData = apiServiceWeather.getWather(45, 3);

        model.addAttribute("weatherData", weatherData);

        return "weather";
    }
}
