package com.example.api.example_file_api.controller;

import com.example.api.example_file_api.utils.ApiServiceWeather;
import com.example.api.example_file_api.Class.Weather;
import com.example.api.example_file_api.utils.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WeatherController {
    @Autowired
    private ApiServiceWeather apiServiceWeather;

//    @GetMapping("/weather")
//    public String getWeather(Model model){
//        //Consome a api para obter o clima
//        String weatherData = apiServiceWeather.getWather(45, 3);
//
//        model.addAttribute("weatherData", weatherData);
//
//        return "weather";
//    }

    @GetMapping("/weather")
    public String getWeather(Model model){
        model.addAttribute("coordenates", new Weather());
        return "inputData";
    }

    @PostMapping("/weather")
    public String postWeather(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude, Model model){

        FileService fls = new FileService();
        ApiServiceWeather apiService = new ApiServiceWeather();

        if(latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180){
          return "Error with values";
        }

        WeatherInfo weatherInfo = apiService.getWather(latitude, longitude);

        model.addAttribute("temperature", weatherInfo.getTemperature());
        model.addAttribute("dateTime", weatherInfo.getDateTime());

//        fls.saveDataToFile(currentTemperature);
        return "responsePage";
    }
}
