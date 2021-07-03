package com.example.fitnessapp.model;

public class Exercise {

    private String name;

    private Long category;

    private String description;

    private Long id;

    public Exercise(){}

    public Exercise(String name, Long category, String description, Long id) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
