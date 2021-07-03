package com.example.fitnessapp.model;

public class Exercise {

    private String name;

    public Exercise(){}

    public Exercise(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
