package com.example.api.example_file_api.utils;

import com.example.api.example_file_api.controller.WeatherInfo;
import com.example.api.example_file_api.controller.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Service
public class ApiServiceWeather {
    public WeatherInfo getWather(double latitude, double longitude){
        String url = "https://api.open-meteo.com/v1/forecast?latitude="+latitude+"&longitude="+longitude+"&current_weather=true";

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.br.bosch.com", 8080));
        factory.setProxy(proxy);

        RestTemplate restTemplate = new RestTemplate(factory);

        try{
            WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

            return new WeatherInfo(response.getCurrentWeather().getTemperature(), response.getCurrentWeather().getDate());
        }catch (RestClientException e){
            System.out.println("Erro ao consultar API: "+e.getMessage());
            return new WeatherInfo(0.0, "Nothing");
        }
    }
}
