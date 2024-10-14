package com.example.api.example_file_api;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Service
public class ApiServiceWeather {
    public String getWather(double latitude, double longitude){
        String url = "https://api.open-meteo.com/v1/forecast?latitude="+latitude+"&longitude="+longitude+"&hourly=temperature";

        //Criação do Proxy
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.br.bosch.com", 8080));
        factory.setProxy(proxy);

        //Criando RestTemplate com proxy
        RestTemplate restTemplate = new RestTemplate(factory);

        //Fazer a requisição
        try{ //O try para validar se a API não foi desligada
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return  response.getBody();
        }catch (RestClientException e){
            System.out.println("Erro ao consultar API: "+e.getMessage());
            return "Erro na requisição";
        }


    }
}
