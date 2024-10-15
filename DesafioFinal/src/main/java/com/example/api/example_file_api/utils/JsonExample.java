package com.example.api.example_file_api.utils;

import com.google.gson.Gson;

public class JsonExample {
    public static void main(String[] args) {
        //Serializando um objeto Javaa para JSON
        Person person = new Person("Gustavo", 19);
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("JSON: "+json);

        // Desserializando JSON para objeto Java
        String jsonResponse = "{\"name\":\"John\",\"age\":30}";
        Person deserializedPerson = gson.fromJson(jsonResponse, Person.class);
        System.out.println("Nome: "+deserializedPerson.getName());
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {return name;}

    public int getAge() {return age;}

    public void setName(String name) {this.name = name;}

    public void setAge(int age) {this.age = age;}
}