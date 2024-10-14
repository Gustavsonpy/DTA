package com.example.api.example_file_api;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class FileService {
    public void saveDataToFile(String data){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
            writer.write(data);
            writer.close();
        }catch (IOException e){
            System.out.println("Erro ao salvar os dados: "+e.getMessage());
        }
    }
}
