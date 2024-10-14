package com.example.api.example_file_api;

import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ApiServiceMovie {

    public static void main(String[] args){
        System.out.println("Hello, world!");

        try {
            //Configurando o cliente HTTP com proxy
            HttpClient client = HttpClient.newBuilder()
                    .proxy(ProxySelector.of(new InetSocketAddress("proxy.br.bosch.com", 8080)))
                    .build();

            Scanner scan = new Scanner(System.in);
            System.out.println("Put the movie's name: ");
            String movieName = scan.nextLine().replace(' ', '+');

            //Criando a requisição HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://www.omdbapi.com/?t="+movieName+"&apikey=f6c088c8"))
                    .build();

            //Enviando a requisição e obtendo a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //Imprimir a resposta
            System.out.println("Resposta da API: "+response.body());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
