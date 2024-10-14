package com.example.api.example_file_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ExampleFileApiApplication implements CommandLineRunner {

	@Autowired
	private ApiServiceWeather apiServiceWeather;

	@Autowired
	private FileService fileService;

	public static void main(String[] args) {

		SpringApplication.run(ExampleFileApiApplication.class, args);
	}

	@Override
	public void run(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		double latitude = 0.0;
		double longitude = 0.0;

		//COLOCOAR NO GIT ANTES DE VOLTAR A TRABALHAR, PARA SALVAR E CRIAR BRANCHES

		do {
			System.out.println("Digite a latitude: ");
			latitude = Double.parseDouble(sc.nextLine());
			if(latitude <= 0){System.out.println("\nLatitude inexistente\n");}
			else{
				System.out.println("Digite a longitude: ");
				longitude = Double.parseDouble(sc.nextLine());
				if(longitude <= 0){System.out.println("\nLongitude inexistente\n");}
			}
		}while(latitude <= 0 || longitude <=0);

		String weatherData = apiServiceWeather.getWather(latitude, longitude);

		System.out.println("Api: "+weatherData);

		// Salvar dados no arquivo
		fileService.saveDataToFile(weatherData);
	}

}
