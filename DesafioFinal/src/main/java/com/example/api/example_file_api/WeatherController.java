package com.example.api.example_file_api;

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
//    @ResponseBody
    public String postWeather(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude, Model model){
        ApiServiceWeather apiService = new ApiServiceWeather();
        String apiResponse = apiService.getWather(latitude, longitude);

        model.addAttribute("apiResponse", apiResponse);
        return "responsePage";
    }
}
