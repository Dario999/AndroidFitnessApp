package com.example.fitnessapp.model;

public class Exercise {

    private String name;

    private Long category;

    private String description;

    public Exercise(){}

    public Exercise(String name, Long category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
