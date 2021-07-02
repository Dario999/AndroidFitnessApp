package com.example.fitnessapp.model;

public class Exercise {

    private String name;

    private Long category;

    public Exercise(){}

    public Exercise(String name,Long category){
        this.name = name;
        this.category = category;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}
